package cn.MS.bean;

import java.util.*;
/**
 * 走访数据
 * @author Administrator
 *
 */
public class VisitData {
	Integer id;  //id
	Date visitDate;  //走访日期
	Date visitTime;  //走访时间
	String address;  //地址
	String visitPerson;  //走访人
	String departmentName;  //走访人所在部门
	String roleName;  //走访人角色
	String countPerson;  //收集信息数
	String details;  //明细
	User user;  //走访人
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVisitPerson() {
		return visitPerson;
	}
	public void setVisitPerson(String visitPerson) {
		this.visitPerson = visitPerson;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCountPerson() {
		return countPerson;
	}
	public void setCountPerson(String countPerson) {
		this.countPerson = countPerson;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
