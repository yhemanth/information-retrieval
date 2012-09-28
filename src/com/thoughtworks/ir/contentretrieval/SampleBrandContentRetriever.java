package com.thoughtworks.ir.contentretrieval;

import com.thoughtworks.ir.domain.Document;
import com.thoughtworks.ir.domain.Location;
import com.thoughtworks.ir.services.DocumentStoreService;

public class SampleBrandContentRetriever {

  private static final String LUNCH_MENU_PAGE = "http://samplebrand.com/lunch";

  private ICrawler crawler;
  private DocumentStoreService documentStoreService;

  public void retrieveContentFor(Location location) {
    crawler.visitLandingPage(location.getLandingPage());
    Document lunchMenu = crawler.visitOnePage(LUNCH_MENU_PAGE);
    documentStoreService.save(location, lunchMenu);
  }
}
