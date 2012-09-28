package com.thoughtworks.ir.contentextraction;

import com.thoughtworks.ir.domain.Location;
import com.thoughtworks.ir.framework.IStage;
import com.thoughtworks.ir.framework.Message;

public class ContentExtractionStage implements IStage {
  private SampleBrandContentExtractor sampleBrandContentExtractor;

  public ContentExtractionStage(SampleBrandContentExtractor sampleBrandContentExtractor) {
    this.sampleBrandContentExtractor = sampleBrandContentExtractor;
  }

  @Override
  public void run(Message message) {
    Location location = (Location) message.getContent();
    sampleBrandContentExtractor.extractContentFor(location);
  }

  @Override
  public void nextStage(IStage stage) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
