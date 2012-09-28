package com.thoughtworks.ir.framework;

public class Message {
  private Object content;

  public Message(Object content) {
    this.content = content;
  }

  public Object getContent() {
    return content;
  }
}
