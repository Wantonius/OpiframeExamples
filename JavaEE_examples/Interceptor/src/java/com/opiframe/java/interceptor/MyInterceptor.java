/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Opiframe
 */
@Interceptor
@InterceptorQualifier
public class MyInterceptor implements Serializable{
  
  @AroundInvoke public Object interceptorTest(InvocationContext ctx) throws Exception{
    System.out.println("Testing interceptor entering method " + ctx.getMethod().getName());
    return ctx.proceed();
  }
  
}
