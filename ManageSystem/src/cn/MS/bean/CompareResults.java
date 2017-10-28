package cn.MS.bean;

import java.util.Date;
/**
 * 对比结果
 * @author wan-ls
 *
 */
public class CompareResults {
	private Integer webPlanDetailId;
	private Integer visitDataId;
	private String name;
	private String address;
	private Date date;
	private String result;
	public Integer getWebPlanDetailId() {
		return webPlanDetailId;
	}
	public void setWebPlanDetailId(Integer webPlanDetailId) {
		this.webPlanDetailId = webPlanDetailId;
	}
	public Integer getVisitDataId() {
		return visitDataId;
	}
	public void setVisitDataId(Integer visitDataId) {
		this.visitDataId = visitDataId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
