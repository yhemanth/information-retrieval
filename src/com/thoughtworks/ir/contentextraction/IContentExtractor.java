package com.thoughtworks.ir.contentextraction;

import com.thoughtworks.ir.domain.Document;
import com.thoughtworks.ir.domain.MenuItems;

public interface IContentExtractor {
  MenuItems extractContentFrom(Document document);
}
