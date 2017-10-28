package cn.MS.bean;

import java.util.List;

/**
 * 角色
 * 
 * @author Administrator
 *
 */
public class Role {
	Integer id; // id
	String roleName; // 角色名
	String description; // 描述
	int state; // 状态
	int roleLimit; // 权限
	List<User> listUser; // 用户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRoleLimit() {
		return roleLimit;
	}

	public void setRoleLimit(int roleLimit) {
		this.roleLimit = roleLimit;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
}
