 package cn.MS.service;

import cn.MS.bean.WebPlan;
/**
 * 传入state
 * @author wan-ls
 *
 */
public interface WebPlanService {
	int add(WebPlan wp);
	int update(WebPlan wp);
	String getById(int id, int state);
	WebPlan getObjectById(int id, int state);
	String getAll();
	String getByName(String name, int state);
	String getByDesigner(String designer, int state);
	String getReleased();
	/**
	 * 获取草稿计划
	 * @return 草稿计划列表
	 */
	String getDraft();
}
