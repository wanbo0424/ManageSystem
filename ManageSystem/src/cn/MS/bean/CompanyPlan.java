package cn.MS.bean;

import java.util.Date;

/**
 * 县公司计划
 * @author Administrator
 *
 */
public class CompanyPlan {
	Integer id;  //id
	String planName;  //计划名
	Date planDateStart;  //计划开始时间
	Date planDateEnd;  //计划结束时间
	Date designDate;  //编制时间
	String designer;  //设计者
	String webType;  //网点类型
	String season;  //季节
	int personTimes;  //个人走访次数
	int totalTimes;  //总计走访次数
	int personCollections;  //个人至少收集信息数
	String remark;  //备注
	User user;  //用户
	int state;//状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Date getPlanDateStart() {
		return planDateStart;
	}
	public void setPlanDateStart(Date planDateStart) {
		this.planDateStart = planDateStart;
	}
	public Date getPlanDateEnd() {
		return planDateEnd;
	}
	public void setPlanDateEnd(Date planDateEnd) {
		this.planDateEnd = planDateEnd;
	}
	public Date getDesignDate() {
		return designDate;
	}
	public void setDesignDate(Date designDate) {
		this.designDate = designDate;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getWebType() {
		return webType;
	}
	public void setWebType(String webType) {
		this.webType = webType;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getPersonTimes() {
		return personTimes;
	}
	public void setPersonTimes(int personTimes) {
		this.personTimes = personTimes;
	}
	public int getTotalTimes() {
		return totalTimes;
	}
	public void setTotalTimes(int totalTimes) {
		this.totalTimes = totalTimes;
	}
	public int getPersonCollections() {
		return personCollections;
	}
	public void setPersonCollections(int personCollections) {
		this.personCollections = personCollections;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
