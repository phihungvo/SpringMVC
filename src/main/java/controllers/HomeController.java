package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping(path={"/","/home.html"})
	public String home() {
		//return "home";	//viewResolver --> prefix + 'view name' + suffix = /WEB-INF/views/home.jsp
		return "chao";		//tên định nghĩa trong tiles.xml
	}
	@RequestMapping(path = "/setCookie", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		Cookie ck1 = new Cookie("userName", "Tran_Vi_Tinh");
		response.addCookie(ck1);
		return "Đã thiết lập Cookie";
	}
	@RequestMapping(path = "/getCookie", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getCookie(HttpServletRequest request) {
		Cookie[] mck = request.getCookies();
		String s = "";
//		for(Cookie ck:mck)
//			s += ck.getName() + " - " + ck.getValue();
		for(Cookie ck:mck)
			if(ck.getName().equals("userName"))
				s = ck.getValue();
		return s;
	}
	@RequestMapping(path = "/getCookie2", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getCookie2(@CookieValue(name = "userName") String s) {
		return s;
	}
}
