package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;


//@WebFilter("/*")
//어노테이션 주석하고 web.xml에서 추가를 해봤음.
//스프링에서는 xml에서 추가하는 방식을 사용하니까
//annotation보다 xml에서 추가하는 방식 연습을 더 할것!
public class CommonFilter extends HttpFilter implements Filter {
       
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		System.out.println("필터거쳤음");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
