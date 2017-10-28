package cn.MS.dao;

import java.util.List;

import cn.MS.bean.CompanyPlan;

public interface CompanyPlanMapper {
	List<CompanyPlan> select();
	int insert(CompanyPlan cp);
}
