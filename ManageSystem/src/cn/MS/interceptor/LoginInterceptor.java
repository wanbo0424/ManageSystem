package cn.MS.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.MS.bean.User;

public class LoginInterceptor implements HandlerInterceptor{

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
    	
		//��ȡ�����URL   
        String url = request.getRequestURI();  
        //URL:login.jsp�ǹ�����;����ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���  
        if(url.contains("login")){  
            return true;  
        }  
        //��ȡSession  
        HttpSession session = request.getSession();  
        User user = (User)session.getAttribute("user");  
          
        if(user != null){  
            return true;  
        }  
        //�����������ģ���ת����¼����  
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<script>alert('�㻹û��¼��');</script>");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);  
        return false;  
	}

}
