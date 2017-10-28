package cn.MS.dao;

import java.util.List;

import cn.MS.bean.Role;

public interface RoleMapper {
	int addRole(Role role); // 添加角色

	int deleteRole(Role role); // 删除角色

	int updateRole(Role role); // 更新角色

	List<Role> selectAll(); // 查找所有角色（包括注销角色）

	List<Role> selectAllActiveRole(); // 查找所有激活角色

	Role selectRoleByName(String roleName); // 通过名字查角色

	Role selectRoleById(int id); // 通过ID查角色

	int cancelRole(Role role); // 注销角色

	int activeRole(Role role); // 激活角色
}
