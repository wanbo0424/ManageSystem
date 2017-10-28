package cn.MS.service;

import cn.MS.bean.Department;

public interface DepartmentService {
	int addDepartment(Department de);
	int delete(int id);
	String selectAll();
	int updateDepartment(Department de);
	String getAllIdandName();
}
