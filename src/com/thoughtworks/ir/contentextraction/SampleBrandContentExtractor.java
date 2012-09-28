package com.thoughtworks.ir.contentextraction;

import com.thoughtworks.ir.domain.Document;
import com.thoughtworks.ir.domain.Location;
import com.thoughtworks.ir.domain.MenuItems;
import com.thoughtworks.ir.services.DocumentStoreService;
import com.thoughtworks.ir.services.MenuItemService;

import java.util.ArrayList;
import java.util.List;

public class SampleBrandContentExtractor {

  private DocumentStoreService documentStoreService;
  private List<IContentExtractor> registeredContentExtractors;
  private MenuItemService menuItemService;

  public SampleBrandContentExtractor() {
    registeredContentExtractors = new ArrayList<IContentExtractor>();
    registeredContentExtractors.add(new BaseMenuItemsContentExtractor());
    registeredContentExtractors.add(new BeveragesContentExtractor());
  }

  public void extractContentFor(Location location) {
    Iterable<Document> documents = documentStoreService.getDocumentsFor(location);
    for (Document document : documents) {
      for (IContentExtractor contentExtractor : registeredContentExtractors) {
        MenuItems menuItems = contentExtractor.extractContentFrom(document);
        menuItemService.add(menuItems, location);
      }
    }
  }
}
