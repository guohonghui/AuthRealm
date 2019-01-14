package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/error")
public class ErrorController {

  @GetMapping(value = "404")
  public String pageNotFound(){
    return "error/404";
  }

}
