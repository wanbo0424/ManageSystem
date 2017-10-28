package cn.MS.service;

import cn.MS.bean.User;

public interface UserService {
	String getDepartmentByUserId(int id);
	String getRoleByUserId(int id);
	String getUser(int id);
	User getUserObject(String name);
	String getUser(String loginname);
	String getAllUser();
	String getActiveUser();
	String getWriteoffUser();
	int modifyUser(User user);
	int addUser(User user);
	String getUsersByDepartmentId(int departmentid);
	String getUsersByRoleId(int roleId);
	String getIdAndName();
}
