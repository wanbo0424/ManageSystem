package cn.MS.service.serviceIm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.MS.bean.CompareResults;
import cn.MS.bean.FailPerson;
import cn.MS.bean.VisitData;
import cn.MS.bean.WebPlanDetail;
import cn.MS.dao.FailPersonMapper;
import cn.MS.dao.UserMapper;
import cn.MS.dao.VisitDataMapper;
import cn.MS.dao.WebPlanDetailMapper;
import cn.MS.service.FailPersonService;

@Transactional
@Service("filePersonService")
public class FailPersonServiceImpl implements FailPersonService{
	@Autowired
	private FailPersonMapper fpm;
	@Autowired
	private WebPlanDetailMapper wpdm;
	@Autowired
	private VisitDataMapper vdm;
	@Autowired
	private UserMapper um;

	@Override
	public String getAll() {
		return listToJson(fpm.getAll(), FailPerson.class);
	}

	@Override
	public int add(FailPerson fp) {
		return fpm.add(fp);
	}

	@Override
	public int delete(int id) {
		return fpm.delete(id);
	}

	@Override
	public int update(FailPerson fp) {
		return fpm.update(fp);
	}

	@Override
	public int autoAddFailPerson() {
		List<CompareResults> list = compare();
		FailPerson fp = new FailPerson();
		int i = 0;
		for(CompareResults cr : list) {
			if(cr.getResult().equals("不合格")) {
				fp.setFaildate(cr.getDate());
				fp.setDescription(cr.getName());
				fp.setUser(um.getUserByName(cr.getName()));
				i += add(fp);
			}
		}
		return i;
	}
	@Override
	public String getCompareResults() {
		return listToJson(compare(), CompareResults.class);
	}

	@Override
	public List<CompareResults> compare() {
		List<WebPlanDetail> list0= wpdm.getAllWebPlanDetail(1);  //查询所有计划
		if(null == list0 || 0 == list0.size())
			return null;
		List<CompareResults> list = new ArrayList<CompareResults>();
		for(WebPlanDetail wpd : list0) {
			String name = wpd.getName();
			List<VisitData> list1 = vdm.getVisitDataByVisitPerson(name);  //根据计划员工查询实际走访数据
			if(null != list1 && 0 < list1.size()) {
				CompareResults cr = new CompareResults();
				cr.setWebPlanDetailId(wpd.getId());
				cr.setName(wpd.getName());
				int flag = 0;  //标记
				for(VisitData vd : list1) {
					if(0 == vd.getVisitDate().compareTo(wpd.getVisitDate())
							&& vd.getAddress().equals(wpd.getVisitAddress())){
						cr.setVisitDataId(vd.getId());
						cr.setResult("合格");
						cr.setDate(vd.getVisitDate());
						cr.setAddress(vd.getAddress());
						flag++;
						break;
					}
				}
				if(0 == flag)
					cr.setResult("不合格");
				list.add(cr);
			}
		}
		return list;
	}
	
	
	
	private String listToJson(List<?> list, Class<?> c) {
		if(list == null || list.size() == 0)
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
