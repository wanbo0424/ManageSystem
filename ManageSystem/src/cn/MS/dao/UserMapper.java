package cn.MS.dao;

import java.util.List;

import cn.MS.bean.User;
/**
 * 用户管理dao层接口
 * @author wan-ls
 *
 */
public interface UserMapper {
	/**
	 * 根据id查询用户，可按需查询相关角色、部门
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	/**
	 * 根据登录名查询用户，可按需查询相关角色、部门
	 * @param name
	 * @return
	 */
	User getUserByLoginname(String name);
	/**
	 * 查询所有用户，可按需查询相关角色、部门
	 * @return
	 */
	List<User> getAllUser();
	User getUserByName(String name);
	/**
	 * 查询所有已激活用户，可按需查询相关角色、部门
	 * @return
	 */
	List<User> getAllActiveUser();
	/**
	 * 查询所有已注销的用户，可按需查询相关角色、部门
	 * @return
	 */
	List<User> getAllWriteoffUser();
	/**
	 * 根据id，修改用户信息
	 * @param user 只需在类中保存需要修改的属性即可
	 */
	int modifyUserByid(User user);
	/**
	 * 添加用户
	 * @param user
	 */
	int addUser(User user);
	/**
	 * 根据部门id查询用户
	 * @param departmentId
	 * @return
	 */
	List<User> getUsersByDepartment(int departmentId);
	/**
	 * 根据角色id查询用户
	 * @param roleId
	 * @return
	 */
	List<User> getUsersByRole(int roleId);
	
}
