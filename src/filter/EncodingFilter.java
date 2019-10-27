package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/** 
 * 文件名:       EncodingFilter.java 
 * 描    述：    利用过滤器解决中文乱码问题
 */ 
public class EncodingFilter implements Filter{
	private String encoding;
	/** 
	 * FunName:           init 
	 * Description :      过滤器初始化时的动作
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");		
	}
	/** 
	 * FunName:           doFilter 
	 * Description :      利用过滤器解决中文乱码问题
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);//解决中文问题
		chain.doFilter(request, response);		
	}
	/** 
	 * FunName:           destroy 
	 * Description :      过滤器消亡时的动作
	 */
	public void destroy() {}
	
}
