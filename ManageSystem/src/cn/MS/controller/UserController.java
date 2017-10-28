package cn.MS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.MS.bean.User;
import cn.MS.service.UserService;
/**
 * 没有考虑权限问题
 * @author wan-ls
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/user_query", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(Integer state,Integer userId,Integer departmentId,Integer roleId) {
		if(state != null){
			if(state == 1){
				String users = us.getActiveUser();
				if(users == null) {
					return "ERROR";
				}
				return users;
			}else if(state == 0){
				String users = us.getWriteoffUser();
				if(null == users)
					return "ERROR";
				return users;
			}else{
				return null;
			}
		}else if(userId != null){
			String user = us.getUser(userId);
			if(null == user)
				return "ERROR";
			return user;
		}else if(departmentId != null){
			String users = us.getUsersByDepartmentId(departmentId);
			if(null == users)
				return "ERROR";
			return users;
		}else if(roleId != null){
			String users = us.getUsersByRoleId(roleId);
			if(null == users)
				return "ERROR";
			return users;
		}else{
			String users = us.getAllUser();
			if(null == users)
				return "ERROR";
			return users;
		}
	}
	@RequestMapping("/user_queryActiveUser")
	@ResponseBody
	public String queryActiveUser() {
		String users = us.getActiveUser();
		if(users == null) {
			return "ERROR";
		}
		return users;
	}
	@RequestMapping("/user_queryWriteoffUser")
	@ResponseBody
	public String queryWriteoffUser() {
		String users = us.getWriteoffUser();
		if(null == users)
			return "ERROR";
		return users;
	}
	@RequestMapping("/user_queryAllUser")
	@ResponseBody
	public String queryAllUser() {
		String users = us.getAllUser();
		if(null == users)
			return "ERROR";
		return users;
	}
	@RequestMapping("/user_queryUser")
	@ResponseBody
	public String queryUser(Integer id) {
		String user = us.getUser(id);
		if(null == user)
			return "ERROR";
		return user;
	}
	@RequestMapping("/user_updateUser")
	@ResponseBody
	public String updateUser(User u) {
		if( u.getId() != null && u.getId() == -1){
			if(0 >= us.addUser(u))
				return "ERROR";
			return "SUCCESS";
		}else{
			if(us.modifyUser(u) <= 0)
				return "ERROR";
			return "SUCCESS";
		}
	}
	/*@RequestMapping("/user_insertUser")
	@ResponseBody
	public String insertUser(User u) {
		if(0 <= us.addUser(u))
			return "ERROR";
		return "SUCCESS";
	}*/
	@RequestMapping("/user_queryUsersByDepartmentId")
	@ResponseBody
	public String queryUsersByDepartmentId(Integer id) {
		String users = us.getUsersByDepartmentId(id);
		if(null == users)
			return "ERROR";
		return users;
	}
	@RequestMapping("/user_queryUsersByRoleId")
	@ResponseBody	
	public String queryUsersByRoleId(Integer id) {
		String users = us.getUsersByRoleId(id);
		if(null == users)
			return "ERROR";
		return users;
	}
	@RequestMapping("/user_queryDepartmentByUserId")
	@ResponseBody
	public String queryDepartmentByUserId(Integer id) {
		String dep = us.getDepartmentByUserId(id);
		if(null == dep)
			return "ERROR";
		return dep;
	}
	@RequestMapping("/user_queryRoleByUserId")
	@ResponseBody
	public String queryRoleByUserId(Integer id) {
		String role = us.getRoleByUserId(id);
		if(null == role)
			return "ERROR";
		return role;
	}
	@RequestMapping(value = "/user_idAndName", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getIdandName(){
		return us.getIdAndName();
	}
}
