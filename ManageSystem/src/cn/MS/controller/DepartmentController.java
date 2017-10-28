package cn.MS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.MS.bean.Department;
import cn.MS.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService ds;

	@RequestMapping(value = "/de_departments", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDepatments() {
		return ds.selectAll();
	}
	@RequestMapping(value = "/de_idAndName", produces = "text/html;charset=UTF-8")
    @ResponseBody
	public String getAllIdandName(){
    	return ds.getAllIdandName();
    }
	@RequestMapping("/de_updateDe")
	@ResponseBody
	public String updateDepartment(Department de) {
		int flag = 0;
		if (de.getId() == -1) {
			flag = ds.addDepartment(de);
		} else {
			flag = ds.updateDepartment(de);
		}
		if (flag > 0)
			return "SUCCESS";
		return "wrong";
	}

	@RequestMapping("/de_deleteDe")
	@ResponseBody
	public String deleteDepartment(Integer id) {
		int flag = ds.delete(id);
		if (flag > 0)
			return "success";
		else
			return "wrong";
	}
}
