package com.mohamed265.weatherchecker.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mohamed265.weatherchecker.entity.User;
import com.mohamed265.weatherchecker.util.Constants;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter({ "/home.xhtml" })
public class SecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		User user = (session != null) ? (User) session.getAttribute(Constants.SESSION_USER) : null;

		if (user == null) {
			res.sendRedirect(req.getContextPath() + "/index.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
