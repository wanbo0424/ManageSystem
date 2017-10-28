package cn.MS.dao;

import java.util.List;

import cn.MS.bean.Role;

public interface RoleMapper {
	int addRole(Role role); // ��ӽ�ɫ

	int deleteRole(Role role); // ɾ����ɫ

	int updateRole(Role role); // ���½�ɫ

	List<Role> selectAll(); // �������н�ɫ������ע����ɫ��

	List<Role> selectAllActiveRole(); // �������м����ɫ

	Role selectRoleByName(String roleName); // ͨ�����ֲ��ɫ

	Role selectRoleById(int id); // ͨ��ID���ɫ

	int cancelRole(Role role); // ע����ɫ

	int activeRole(Role role); // �����ɫ
}
