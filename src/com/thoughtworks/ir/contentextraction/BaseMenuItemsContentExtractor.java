package com.thoughtworks.ir.contentextraction;

import com.thoughtworks.ir.domain.*;
import com.thoughtworks.ir.services.MenuItemService;


public class BaseMenuItemsContentExtractor implements IContentExtractor {
  private MenuItemService menuItemService;

  @Override
  public MenuItems extractContentFrom(Document document) {
    MenuItems menuItems = new MenuItems();
    if (containsRelevantContent(document)) {
      MenuItem item = new MenuItem("itemName", 0.0f, MenuType.DINNER);
      MenuCategory salads = new MenuCategory("Salads");
      item.setCategory(salads);
      menuItems.add(item);
    }
    return menuItems;
  }

  private boolean containsRelevantContent(Document document) {
    return false;
  }
}
