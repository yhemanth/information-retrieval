package com.thoughtworks.ir.contentretrieval;

import com.thoughtworks.ir.domain.Document;

public interface ICrawler {
  void visitLandingPage(String landingPage);

  Document visitOnePage(String lunchMenuPage);
}
