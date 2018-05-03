/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Opiframe
 */
@Component
public class ContactFilter implements Filter {

  @Bean
  public FilterRegistrationBean myFilterBean(ContactFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(filter);
    registration.addUrlPatterns("/api/*");
    registration.setEnabled(true);
    registration.setName("HonoFilter");
    registration.setAsyncSupported(true);
    registration.setOrder(1);
    return registration;
  }

  @Override
  public void init(FilterConfig fc) throws ServletException {
    System.out.println("Tereve");
  }

  @Override
  public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
    boolean isFound = false;
    HttpServletRequest req = (HttpServletRequest) sr;
    HttpServletResponse res = (HttpServletResponse) sr1;
    Enumeration headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String header = (String) headerNames.nextElement();
      if (header.equals("authtoken")) {
        if (req.getHeader("authtoken").equals("123")) {
          fc.doFilter(sr, sr1);
          isFound = true;
        }
      }
    }
    if (!isFound) {
      res.sendError(403);
    }
  }

  @Override
  public void destroy() {
    System.out.println("MOU");
  }

}
