package cn.MS.bean;
/**
 * 部门
 * @author Administrator
 *
 */
public class Department {
	Integer id;  //id
	String departmentName;  //部门名称
	String phone;  //电话
	int state;  //状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
