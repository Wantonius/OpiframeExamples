/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.helloboot.helloboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Opiframe
 */
@Controller
public class HelloController {
  
  @RequestMapping("/")
  @ResponseBody
  public String getHello(){
    return "Hello World";
  }
}
