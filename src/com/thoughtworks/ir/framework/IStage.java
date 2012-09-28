package com.thoughtworks.ir.framework;

public interface IStage {
  void run(Message message);

  void nextStage(IStage stage);
}
