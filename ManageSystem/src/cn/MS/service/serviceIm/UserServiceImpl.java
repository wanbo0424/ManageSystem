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

import cn.MS.bean.Department;
import cn.MS.bean.Role;
import cn.MS.bean.User;
import cn.MS.dao.DepartmentMapper;
import cn.MS.dao.UserMapper;
import cn.MS.service.UserService;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper um;
	@Autowired
	private DepartmentMapper dm;
	@Override
	public String getDepartmentByUserId(int id) {
		User u = um.getUserById(id);
		return objectToJson(u.getDepartment(), Department.class);
	}
	@Override
	public String getRoleByUserId(int id) {
		User u = um.getUserById(id);
		return objectToJson(u.getRole(), Role.class);
	}
	@Override
	public String getUser(int id) {
		return objectToJson(um.getUserById(id), User.class);
	}
	@Override
	public User getUserObject(String name) {
		return um.getUserByName(name);
	}
	@Override
	public String getUser(String loginname) {
		return objectToJson(um.getUserByLoginname(loginname), User.class);
	}
	@Override
	public String getAllUser() {
		return listToJson(um.getAllUser(), User.class);
	}
	@Override
	public String getActiveUser() {
		return listToJson(um.getAllActiveUser(), User.class);
	}
	@Override
	public int modifyUser(User user) {
		return um.modifyUserByid(user);
	}
	@Override
	public int addUser(User user) {
		String dep_name = dm.get(user.getDepartment().getId()).getDepartmentName();
		user.setDepartmentName(dep_name);
		return um.addUser(user);
	}
	@Override
	public String getUsersByDepartmentId(int departmentid) {
		return listToJson(um.getUsersByDepartment(departmentid), User.class);
	}
	@Override
	public String getUsersByRoleId(int roleId) {
		return listToJson(um.getUsersByRole(roleId), User.class);
	}
	@Override
	public String getWriteoffUser() {
		return listToJson(um.getAllWriteoffUser(), User.class);
	}
	
	
	/**
	 * ½«list·â×°µ½json
	 * @param list
	 * @return
	 */
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
	private String objectToJson(Object u, Class<?> c) {
		if(u == null)
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
				}else if(fields[i].getType().toString().startsWith("class cn.MS.bean.Department")){
					fields[i].setAccessible(true);
					String name = fields[i].getName();
					Method method = c.getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
					Department dep = (Department) method.invoke(o);
					ob.put("department_id", dep.getId());
					ob.put("department_name", dep.getDepartmentName());
				}else if(fields[i].getType().toString().startsWith("class cn.MS.bean.Role")){
					fields[i].setAccessible(true);
					String name = fields[i].getName();
					Method method = c.getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
					Role role = (Role) method.invoke(o);
					ob.put("role_id", role.getId());
					ob.put("role_name", role.getRoleName());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return ob;
	}
	/* (non-Javadoc)
	 * @see cn.MS.service.UserService#getIdAndName()
	 */
	@Override
	public String getIdAndName() {
		List<User> list=um.getAllUser();
		JSONArray array=new JSONArray();
		for(User u:list){
			JSONObject object=new JSONObject();
			object.put("id", u.getId());
			object.put("name", u.getName());
			array.put(object);
		}
		return array.toString();
	}

}
