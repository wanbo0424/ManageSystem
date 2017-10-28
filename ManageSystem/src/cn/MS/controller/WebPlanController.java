package cn.MS.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.MS.bean.WebPlan;
import cn.MS.service.WebPlanService;

@RestController
public class WebPlanController {
	@Autowired
	private WebPlanService wps;
	
/*	@RequestMapping("/webPlan_addWebPlan")
	public String addWebPlan(WebPlan wp) {
		if(0 >= wps.add(wp))
			return "ERROR";
		return "SUCCESS";
	}*/
	@RequestMapping("/webPlan_updateWebPlan")
	public String updateWebPlan(WebPlan wp,@RequestParam("p_planDateStart")String planDateStart,@RequestParam("p_planDateEnd")String planDateEnd,@RequestParam("p_designDate")String designDate) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

		wp.setPlanDateStart(formatDate.parse(planDateStart));
		wp.setPlanDateEnd(formatDate.parse(planDateEnd));
		wp.setDesignDate(formatDate.parse(designDate));
		if(wp.getId() == -1){
			if(0 >= wps.add(wp))
				return "ERROR";
			return "SUCCESS";
		}else{
			if(0 >= wps.update(wp))
				return "ERROR";
			return "SUCCESS";
		}
	}
	
	@RequestMapping(value="/getWebPlan", produces = "text/html;charset=UTF-8")
	public String getWebPlan(Integer id,Integer state,String name,String designer){
		if(id != null){
			String wp = wps.getById(id, state);
			if(null == wp)
				return "ERROR";
			return wp;
		}else if(name != null){
			state=1;
			String wp = wps.getByName(name, state);
			if(null == wp)
				return "ERROR";
			return wp;
		}else if(designer != null && state != null){
			String wp = wps.getByDesigner(designer, state);
			if(null == wp)
				return "ERROR";
			return wp;
		}else if(state !=null && state == 1){
			String wp = wps.getReleased();
			if(null == wp)
				return "ERROR";
			return wp;
		}else if(state != null && state == 0){
			String wp = wps.getDraft();
			if(null == wp)
				return "ERROR";
			return wp;
		}else{
			return wps.getAll();
		}
	}
	
	@RequestMapping("/getWebPlanById")
	public String getWebPlanById(Integer id, Integer state) {
		String wp = wps.getById(id, state);
		if(null == wp)
			return "ERROR";
		return wp;
	}
	@RequestMapping("/getAllWebPlan")
	public String getAllWebPlan() {
		return wps.getAll();
	}
	@RequestMapping("/getReleasedWebPlan")
	public String getReleasedWebPlan() {
		String wp = wps.getReleased();
		if(null == wp)
			return "ERROR";
		return wp;
	}
	@RequestMapping("/getDraftWebPlan")
	public String getDraftWebPlan() {
		String wp = wps.getDraft();
		if(null == wp)
			return "ERROR";
		return wp;
	}
	@RequestMapping("/getWebPlanByName")
	public String getWebPlanByName(String name, Integer state) {
		String wp = wps.getByName(name, state);
		if(null == wp)
			return "ERROR";
		return wp;
	}
	@RequestMapping("/getWebPlanByDesigner")
	public String getWebPlanByDesigner(String designer, Integer state) {
		String wp = wps.getByDesigner(designer, state);
		if(null == wp)
			return "ERROR";
		return wp;
	}
}
