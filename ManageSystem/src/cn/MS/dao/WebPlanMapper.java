package cn.MS.dao;

import java.util.List;

import cn.MS.bean.WebPlan;
/**
 * state״̬0��ʾδ������1��ʾ�ѷ���
 * @author wan-ls
 *
 */
public interface WebPlanMapper {
	int addWebPlan(WebPlan wp);
	int updateWebPlan(WebPlan wp);
	WebPlan getWebPlanById(int id, int state);
	List<WebPlan> getAllWebPlan();
	/**
	 * ���ݼƻ���ģ����ѯ
	 * @param name
	 * @return
	 */
	List<WebPlan> getWebPlanByName(String name, int state);
	List<WebPlan> getWebPlanByDesigner(String designer, int state);
	List<WebPlan> getWebPlanByState(int state);
}
