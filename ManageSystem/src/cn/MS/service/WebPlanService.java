 package cn.MS.service;

import cn.MS.bean.WebPlan;
/**
 * ����state
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
	 * ��ȡ�ݸ�ƻ�
	 * @return �ݸ�ƻ��б�
	 */
	String getDraft();
}
