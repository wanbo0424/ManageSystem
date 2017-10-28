package cn.MS.service;

import cn.MS.bean.WebPlanDetail;

public interface WebPlanDetailService {
	int add(WebPlanDetail wpd);
	int update(WebPlanDetail wpd);
	String getById(int id,int state);
	String getByWebPlanId(int webPlan_id,int state);
	WebPlanDetail getObjectById(int id);
	String getAll(Integer state);
	String getByName(String name,int state);
	String getReleased();
	/**
	 * ��ȡ�ݸ�ƻ�
	 * @return �ݸ�ƻ��б�
	 */
	String getDraft();
}
