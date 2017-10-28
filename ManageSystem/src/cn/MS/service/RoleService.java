package cn.MS.service;

import cn.MS.bean.Role;

public interface RoleService {
	int addRole(Role role);

	int deleteRole(Role role);

	int updateRole(Role role);

	String selectAll();

	String selectAllActiveRole();

	String selectRoleByName(String roleName);
    
	String selectAllIdandName();
	Role selectRoleById(int id);

	int cancelRole(Role role);

	int activeRole(Role role);
}
