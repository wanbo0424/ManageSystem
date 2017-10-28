package cn.MS.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.MS.util.PowerConstants;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO Auto-generated method stub
		if(Integer.parseInt(request.getParameter("id")) != -1){
			return true;
		}
		int role_limit =(int) request.getSession().getAttribute("role_limit");
		if(role_limit != PowerConstants.SYSTEM_MANAGER){
			response.setContentType("text/html; charset=utf-8");
	        PrintWriter writer = response.getWriter();
	        writer.write("<script>alert('你不是系统管理员！权限不够！');</script>");
			writer.write("<script>history.back();</script>");//js语句：输出网页回退语句
			return false;
		}else{
			return true;
		}
	}

}
