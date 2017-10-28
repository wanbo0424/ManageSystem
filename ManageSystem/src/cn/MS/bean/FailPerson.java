package cn.MS.bean;

import java.util.Date;

/**
 * 不合格人员
 * @author Administrator
 *
 */
public class FailPerson {
	Integer id;  //id
	Date faildate; //ͨ������
	String description;  //����
	User user;  //���ϸ���Ա
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFaildate() {
		return faildate;
	}
	public void setFaildate(Date faildate) {
		this.faildate = faildate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
