package com.org.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

  private String message;

  public MyException(String message){
    super(message);
    this.message=message;
  }
}
