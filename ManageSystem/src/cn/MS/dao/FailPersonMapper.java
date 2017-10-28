package cn.MS.dao;

import java.util.List;

import cn.MS.bean.FailPerson;

public interface FailPersonMapper {
	int add(FailPerson fp);
	int delete(int id);
	int update(FailPerson fp);
	List<FailPerson> getAll();
}
