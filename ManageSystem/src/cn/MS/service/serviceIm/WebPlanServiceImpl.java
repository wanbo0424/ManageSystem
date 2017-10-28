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

import cn.MS.bean.WebPlan;
import cn.MS.dao.WebPlanMapper;
import cn.MS.service.WebPlanService;

@Transactional
@Service("webPlanService")
public class WebPlanServiceImpl implements WebPlanService{
	@Autowired
	WebPlanMapper wpm;

	@Override
	public int add(WebPlan wp) {
		return wpm.addWebPlan(wp);
	}

	@Override
	public int update(WebPlan wp) {
		return wpm.updateWebPlan(wp);
	}

	@Override
	public String getById(int id, int state) {
		return objectToJson(wpm.getWebPlanById(id, state), WebPlan.class);
	}
	
	@Override
	public WebPlan getObjectById(int id, int state) {
		return wpm.getWebPlanById(id, state);
	}
	
	@Override
	public String getAll() {
		return listToJson(wpm.getAllWebPlan(), WebPlan.class);
	}

	@Override
	public String getByName(String name, int state) {
		return listToJson(wpm.getWebPlanByName(name, state), WebPlan.class);
	}

	@Override
	public String getByDesigner(String designer, int state) {
		return listToJson(wpm.getWebPlanByDesigner(designer, state), WebPlan.class);
	}

	@Override
	public String getReleased() {
		return listToJson(wpm.getWebPlanByState(1), WebPlan.class);
	}

	@Override
	public String getDraft() {
		return listToJson(wpm.getWebPlanByState(0), WebPlan.class);
	}
	
	
	
	
	/**
	 * ½«list·â×°µ½json
	 * @param list
	 * @return
	 */
	private String listToJson(List<?> list, Class<?> c) {
		if(null == list || 0 == list.size())
			return null;
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i=0;
		for (Object u : list) {
			i++;
			JSONObject ob = objectToJO(u, c);
			array.put(ob);
		}
		jsonObject.put("total", i);
		jsonObject.put("rows", array);
		return jsonObject.toString();
	}
	private String objectToJson(Object u, Class<?> c) {
		if(null == u)
			return null;
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i=0;
		i++;
		JSONObject ob = objectToJO(u, c);
		array.put(ob);
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
			for(int i = 0; i < fields.length; i++) {
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
				}else if(!fields[i].getType().toString().startsWith("class cn.MS.bean.") ) {
					fields[i].setAccessible(true);
					String name = fields[i].getName();
					Method method = c.getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
					ob.put(name, method.invoke(o));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return ob;
	}


}
