package cn.MS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class WebController {
   
   @RequestMapping("/home")
   public String goHome() {
	   return "home";
   }
   @RequestMapping("/login")
   public String login() {
	   return "login";
   }
   
   @RequestMapping("/admin")
   public String admin() {
	   return "AdminManage";
   }
   
   @RequestMapping("/departmentmodify")
   public String departmentmodify(){
	   return "departmentmodify";
   }

  
   @RequestMapping("/usermodify")
   public String Usermodify(){
	   return "Usermodify";
   }
   @RequestMapping("/CompanyplanAdd")
   public String CompanyplanAdd(){
	   return "CompanyplanAdd";
   }
   @RequestMapping("/WebPlanAdd")
   public String WebPlanAdd(){
	   return "WebPlanAdd";
   }
   @RequestMapping("/WebPlandetailAdd")
   public String WebPlandetailAdd(){
	   return "WebPlandetailAdd";
   }

}
