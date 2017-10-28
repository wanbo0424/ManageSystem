package cn.MS.service.serviceIm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.MS.bean.WebPlanDetail;
import cn.MS.dao.WebPlanDetailMapper;
import cn.MS.service.WebPlanDetailService;

@Transactional
@Service("webPlanDetailService")
public class WebPlanDetailServiceImpl implements WebPlanDetailService {

	@Autowired
	private WebPlanDetailMapper wpdm;

	@Override
	public int add(WebPlanDetail wpd) {
		return wpdm.addWebPlanDetail(wpd);
	}

	@Override
	public int update(WebPlanDetail wpd) {
		return wpdm.updateWebPlanDetail(wpd);
	}

	@Override
	public String getById(int id,int state) {
		return objectToJson(wpdm.getWebPlanDetailById(id,state), WebPlanDetail.class);
	}

	@SuppressWarnings("null")
	@Override
	public WebPlanDetail getObjectById(int id) {
		Integer state = null;
		return wpdm.getWebPlanDetailById(id,state);
	}
	
	@Override
	public String getByWebPlanId(int webPlan_id, int state) {
		return objectToJson(wpdm.getWebPlanDetailByWebPlanId(webPlan_id, state), WebPlanDetail.class);
	}

	@Override
	public String getAll(Integer state) {
		return listToJson(wpdm.getAllWebPlanDetail(state), WebPlanDetail.class);
	}

	@Override
	public String getByName(String name,int state) {
		return listToJson(wpdm.getWebPlanDetailByName(name,state), WebPlanDetail.class);
	}

	@Override
	public String getReleased() {
		return listToJson(wpdm.getWebPlanByState(1), WebPlanDetail.class);
	}

	@Override
	public String getDraft() {
		return listToJson(wpdm.getWebPlanByState(0), WebPlanDetail.class);
	}

	/**
	 * ½«list·â×°µ½json
	 * 
	 * @param list
	 * @return
	 */
	private String listToJson(List<?> list, Class<?> c) {
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i = 0;
		if (list != null) {
			for (Object u : list) {
				i++;
				JSONObject ob = objectToJO(u, c);
				array.put(ob);
			}
		} else {
			return null;
		}
		jsonObject.put("total", i);
		jsonObject.put("rows", array);
		return jsonObject.toString();
	}

	private String objectToJson(Object u, Class<?> c) {
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i = 0;
		if (u != null) {
			i++;
			JSONObject ob = objectToJO(u, c);
			array.put(ob);
		} else {
			return null;
		}
		jsonObject.put("total", i);
		jsonObject.put("rows", array);

		return jsonObject.toString();
	}

	private JSONObject objectToJO(Object obj, Class<?> c) {
		JSONObject ob = new JSONObject();
		try {
			Object o = c.newInstance();
			o = obj;
			Field[] fields = c.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if(fields[i].getType().toString().startsWith("class java.util.Date")) {
				fields[i].setAccessible(true);
				String name = fields[i].getName();
				Method method = c.getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
				Date date = (Date) method.invoke(o);
				if(date != null){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String sdfDate = sdf.format(date);
					ob.put(name, sdfDate);
				}
			}else if (!fields[i].getType().toString().startsWith("class cn.MS.bean.")) {
					fields[i].setAccessible(true);
					String name = fields[i].getName();
					Method method = c.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
					ob.put(name, method.invoke(o));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return ob;
	}



}
