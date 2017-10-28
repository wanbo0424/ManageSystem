package cn.MS.dao;

import java.util.List;

import cn.MS.bean.User;
/**
 * �û�����dao��ӿ�
 * @author wan-ls
 *
 */
public interface UserMapper {
	/**
	 * ����id��ѯ�û����ɰ����ѯ��ؽ�ɫ������
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	/**
	 * ���ݵ�¼����ѯ�û����ɰ����ѯ��ؽ�ɫ������
	 * @param name
	 * @return
	 */
	User getUserByLoginname(String name);
	/**
	 * ��ѯ�����û����ɰ����ѯ��ؽ�ɫ������
	 * @return
	 */
	List<User> getAllUser();
	User getUserByName(String name);
	/**
	 * ��ѯ�����Ѽ����û����ɰ����ѯ��ؽ�ɫ������
	 * @return
	 */
	List<User> getAllActiveUser();
	/**
	 * ��ѯ������ע�����û����ɰ����ѯ��ؽ�ɫ������
	 * @return
	 */
	List<User> getAllWriteoffUser();
	/**
	 * ����id���޸��û���Ϣ
	 * @param user ֻ�������б�����Ҫ�޸ĵ����Լ���
	 */
	int modifyUserByid(User user);
	/**
	 * ����û�
	 * @param user
	 */
	int addUser(User user);
	/**
	 * ���ݲ���id��ѯ�û�
	 * @param departmentId
	 * @return
	 */
	List<User> getUsersByDepartment(int departmentId);
	/**
	 * ���ݽ�ɫid��ѯ�û�
	 * @param roleId
	 * @return
	 */
	List<User> getUsersByRole(int roleId);
	
}
