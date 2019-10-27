package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/** 
 * �ļ���:       EncodingFilter.java 
 * ��    ����    ���ù��������������������
 */ 
public class EncodingFilter implements Filter{
	private String encoding;
	/** 
	 * FunName:           init 
	 * Description :      ��������ʼ��ʱ�Ķ���
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");		
	}
	/** 
	 * FunName:           doFilter 
	 * Description :      ���ù��������������������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);//�����������
		chain.doFilter(request, response);		
	}
	/** 
	 * FunName:           destroy 
	 * Description :      ����������ʱ�Ķ���
	 */
	public void destroy() {}
	
}
