package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/** 
 * �ļ���:       EncodingFilter.java 
 * ��    ����    ���ù���������session���
 */ 
public class SessionCheckFilter implements Filter {
	/** 
	 * FunName:           init 
	 * Description :      ��������ʼ��ʱ�Ķ���
	 * @param��			  FilterConfig filterConfig
	 */
	public void init(FilterConfig filterConfig) throws ServletException {	}
	/** 
	 * FunName:           doFilter 
	 * Description :      ���ù���������session��飬��ֹ�û���ͨ����¼��ֱ��������ַ�����������
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest; 
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession(); 
		if (session.getAttribute("type") == null) {
			response.sendRedirect("/EduSystem/index.jsp");
		}
		filterChain.doFilter(servletRequest, servletResponse); 
	}
	/** 
	 * FunName:           destroy 
	 * Description :      ����������ʱ�Ķ���
	 */
	public void destroy() {	}
}
