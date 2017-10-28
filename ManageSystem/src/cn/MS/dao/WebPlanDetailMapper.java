package cn.MS.dao;

import java.util.List;

import cn.MS.bean.WebPlanDetail;

public interface WebPlanDetailMapper {
	int addWebPlanDetail(WebPlanDetail wpd);

	int updateWebPlanDetail(WebPlanDetail wpd);

	WebPlanDetail getWebPlanDetailById(int id,int state);
	
	WebPlanDetail getWebPlanDetailByWebPlanId(int webPlan_id,int state);

	List<WebPlanDetail> getAllWebPlanDetail(Integer state);

	/**
	 * 根据计划名模糊查询
	 * 
	 * @param name
	 * @return
	 */
	List<WebPlanDetail> getWebPlanDetailByName(String name,int state);

	List<WebPlanDetail> getWebPlanByState(int state);
}
