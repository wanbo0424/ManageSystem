package cn.MS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.MS.bean.User;
import cn.MS.bean.WebPlan;
import cn.MS.bean.WebPlanDetail;
import cn.MS.service.UserService;
import cn.MS.service.WebPlanDetailService;
import cn.MS.service.WebPlanService;

@Controller
public class WebPlanDetailController {

	@Autowired
	@Qualifier("webPlanDetailService")
	private WebPlanDetailService wpds;

	@Autowired
	@Qualifier("webPlanService")
	private WebPlanService wps;

	@Autowired
	@Qualifier("userService")
	private UserService us;

	@RequestMapping(value="/webPlanDetail_add", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String add(Integer webPlan_id, WebPlanDetail wpd, Integer state) throws Exception {
		if(wpd.getId() == -1){
			WebPlan webPlan = wps.getObjectById(webPlan_id, state);
			if (webPlan == null) {
				return "NONE";
			}
			User user = us.getUserObject(wpd.getName());
			if (user == null) {
				return "NONE";
			}
			wpd.setWebPlan(webPlan);
			wpd.setUser(user);
			wpd.setState(0);
			if (wpds.add(wpd) != 0) {
				return "SUCCESS";
			} else {
				return "FAIL";
			}
		}else{
			if(wpds.getObjectById(wpd.getId()).getState() == 1){
				return "ERROR";
			}
			int count = 0;
			if (wpd.getName() == null) {
				count = wpds.add(wpd);
			} else {
				User user = us.getUserObject(wpd.getName());
				if (user == null) {
					return "ERROR";
				} else {
					wpd.setUser(user);
					count = wpds.add(wpd);
				}
			}
			if (count != 0) {
				return "SUCCESS";
			} else {
				return "FAIL";
			}
		}
	}

	/*@RequestMapping("/webPlanDetail_update")
	@ResponseBody
	public String update(WebPlanDetail wpd) throws Exception {
		if(wpds.getObjectById(wpd.getId()).getState() == 1){
			return "计划已经发布！不允许修改！";
		}
		int count = 0;
		if (wpd.getName() == null) {
			count = wpds.add(wpd);
		} else {
			User user = us.getUserObject(wpd.getName());
			if (user == null) {
				return "所属用户不存在！";
			} else {
				wpd.setUser(user);
				count = wpds.add(wpd);
			}
		}
		if (count != 0) {
			return "更新成功！";
		} else {
			return "更新失败！";
		}
	}*/
	
	@RequestMapping("/webPlanDetail_get")
	@ResponseBody
	public String get(Integer id,String name,Integer state,Integer webPlan_id) throws Exception{
		if(id != null && state != null){
			return wpds.getById(id,state);
		}else if( webPlan_id != null && state != null){
			return wpds.getByWebPlanId(webPlan_id, state);
		}else if(name != null){
			return wpds.getByName(name,state);
		}else if(state != null && state == 1){
			return wpds.getReleased();
		}else if(state != null && state == 0){
			return wpds.getDraft();
		}else{
			return wpds.getAll(state);
		}
	}
	
	@RequestMapping("/webPlanDetail_getById")
	@ResponseBody
	public String getById(Integer id,Integer state) throws Exception {
		return wpds.getById(id,state);
	}

	@RequestMapping("/webPlanDetail_getAll")
	@ResponseBody
	public String getAll(Integer state) throws Exception {
		return wpds.getAll(state);
	}

	@RequestMapping("/webPlanDetail_getByName")
	@ResponseBody
	public String getByName(String name,Integer state) throws Exception {
		return wpds.getByName(name,state);
	}

	@RequestMapping("/webPlanDetail_getReleased")
	@ResponseBody
	public String getReleased() throws Exception {
		return wpds.getReleased();
	}

	@RequestMapping("/webPlanDetail_getDraft")
	@ResponseBody
	public String getDraft() throws Exception {
		return wpds.getDraft();
	}
}
