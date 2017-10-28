package cn.MS.service;

import java.util.List;

import cn.MS.bean.CompareResults;
import cn.MS.bean.FailPerson;

public interface FailPersonService {
	String getAll();  //查询所有不合格人员
	int add(FailPerson fp);
	int delete(int id);
	int update(FailPerson fp);
	/**
	 * 根据比较结果将不合格的人员自动添加到不合格表中
	 */
	int autoAddFailPerson();
	/**
	 * 进行三方比较
	 * @return 返回比较结果list集合，具体保存在CompareResults类中
	 */
	List<CompareResults> compare();
	String getCompareResults();
}
