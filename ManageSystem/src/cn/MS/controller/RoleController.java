package cn.MS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.MS.bean.Role;
import cn.MS.bean.User;
import cn.MS.service.RoleService;
import cn.MS.service.UserService;

@Controller
public class RoleController {

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

/*	@RequestMapping("/role_addRole")
	@ResponseBody
	public String addRole(Role role) throws Exception {
		if (roleService.selectRoleByName(role.getRoleName()) != null) {
			return "User is already exists !!!";
		} else {
			roleService.addRole(role);
			return "SUCCESS";
		}
	}*/

	@RequestMapping("/role_deleteRole")
	@ResponseBody
	public String deleteRole(Role role) throws Exception {
		if (roleService.deleteRole(role) != 0) {
			return "SUCCESS";
		}
		return "FAIL";
	}

	@RequestMapping("/role_updateRole")
	@ResponseBody
	public String updateRole(Role role) throws Exception {
		if(role.getId() == -1){
			if (roleService.selectRoleByName(role.getRoleName()) != null) {
				return "User is already exists !!!";
			} else {
				roleService.addRole(role);
				return "SUCCESS";
			}
		}else{
			if (roleService.updateRole(role) != 0) {
				return "SUCCESS";
			}
			return "FAIL";
		}
	}
	
	@RequestMapping(value="/role_select", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String select(Integer state,String roleName) throws Exception {
		if(state != null){
			return roleService.selectAllActiveRole();
		}else if(roleName != null){
			return roleService.selectRoleByName(roleName);
		}else{
			return roleService.selectAll();
		}
	}

	@RequestMapping("/role_selectAll")
	@ResponseBody
	public String selectAll() throws Exception {
		return roleService.selectAll();
	}
	
	@RequestMapping("/role_selectAllActiveRole")
	@ResponseBody
	public String selectAllActiveRole() throws Exception {
		return roleService.selectAllActiveRole();
	}

	@RequestMapping("/role_selectRoleByName")
	@ResponseBody
	public String selectRoleByName(String roleName) throws Exception {
		return roleService.selectRoleByName(roleName);
	}

	@RequestMapping("/role_cancelRole")
	@ResponseBody
	public String cancelRole(Role role) throws Exception {
		if (roleService.cancelRole(role) != 0) {
			return "SUCCESS";
		}
		return "FAIL";
	}

	@RequestMapping("/role_activeRole")
	@ResponseBody
	public String activeRole(Role role) throws Exception {
		if (roleService.activeRole(role) != 0) {
			return "SUCCESS";
		}
		return "FAIL";
	}
	
	@RequestMapping("/role_addPower")
	@ResponseBody
	public String addPower(Integer id,Integer roleLimit) {
		Role role = roleService.selectRoleById(id);
		if(role == null) {
			return "FAIL";
		}
		role.setRoleLimit(roleLimit);
		if(roleService.updateRole(role) != 0){
			return "SUCCESS";
		}
		return "FAIL";
	}
	
	//为用户设置权限 
	@RequestMapping("/role_settingPower")
	@ResponseBody
	public String settingPower(Integer roleId,User user) {
		Role role = roleService.selectRoleById(roleId);
		user.setRole(role);
		userService.modifyUser(user);
		return "SUCCESS";
	}
	@RequestMapping(value="/role_selectIdandName", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getALLIdAndName(){
		return roleService.selectAllIdandName();
	}
}
