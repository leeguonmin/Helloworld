package himedia.kdt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// 필터는 인퍼테이스
// 니까 implements Filter 추가 
// 컨트롤 쉬프트 o 해서 임폴트 import jakarta.servlet.Filter;
public class EncodingFilter implements Filter {
	// 소스 > 오버라이드 > 가운데에 있는거만 하면 되지만, 우린 배우는거니까 세개 다 체크했음 
	
	private static Logger logger = Logger.getLogger(EncodingFilter.class.getSimpleName());
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[EencodingFilter] init");
		Filter.super.init(filterConfig);
	}



	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		logger.info("[EencodingFilter] doFilter");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h6>Encoding 필터 작용 전</h6>");
		
		// 뒤쪽 필터로 요청을 넘긴다 (요청 전달)
		chain.doFilter(req, resp);	
		
		out.println("<h6>Encoding 필터 작동 후</h6>");
	}
	
	
	@Override
	public void destroy() {
		logger.info("[EencodingFilter] destroy");
		
		Filter.super.destroy();
	}

	
}
