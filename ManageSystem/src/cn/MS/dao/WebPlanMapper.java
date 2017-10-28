package cn.MS.dao;

import java.util.List;

import cn.MS.bean.WebPlan;
/**
 * state状态0表示未发布，1表示已发布
 * @author wan-ls
 *
 */
public interface WebPlanMapper {
	int addWebPlan(WebPlan wp);
	int updateWebPlan(WebPlan wp);
	WebPlan getWebPlanById(int id, int state);
	List<WebPlan> getAllWebPlan();
	/**
	 * 根据计划名模糊查询
	 * @param name
	 * @return
	 */
	List<WebPlan> getWebPlanByName(String name, int state);
	List<WebPlan> getWebPlanByDesigner(String designer, int state);
	List<WebPlan> getWebPlanByState(int state);
}
