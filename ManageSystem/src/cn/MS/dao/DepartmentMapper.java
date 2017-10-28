package cn.MS.dao;

import java.util.List;

import cn.MS.bean.Department;

/**
 * @author VickyDan
 * 
 */
public interface DepartmentMapper {
	int addDepartment(Department de);
	List<Department> selectAll();
	int deleteDepartment(int id);
	int updateDepartment(Department de);
	Department get(int id);
}
