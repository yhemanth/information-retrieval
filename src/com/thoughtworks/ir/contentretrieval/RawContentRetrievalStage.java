package com.thoughtworks.ir.contentretrieval;

import com.thoughtworks.ir.contentextraction.ContentExtractionStage;
import com.thoughtworks.ir.domain.Brand;
import com.thoughtworks.ir.domain.Location;
import com.thoughtworks.ir.framework.IStage;
import com.thoughtworks.ir.framework.Message;
import com.thoughtworks.ir.services.LocationService;

public class RawContentRetrievalStage implements IStage {
  private SampleBrandContentRetriever sampleBrandContentRetriever;
  private ContentExtractionStage contentExtractionStage;

  public RawContentRetrievalStage(SampleBrandContentRetriever sampleBrandContentRetriever) {
    this.sampleBrandContentRetriever = sampleBrandContentRetriever;
  }


  @Override
  public void run(Message message) {
    LocationService locationService = new LocationService();
    Iterable<Location> locations = locationService.getLocations((Brand)message.getContent());
    for (Location location : locations) {
      sampleBrandContentRetriever.retrieveContentFor(location);
      Message stageCompletedMessage = new Message(location);
      contentExtractionStage.run(stageCompletedMessage);
    }
  }

  @Override
  public void nextStage(IStage stage) {
    contentExtractionStage = (ContentExtractionStage)stage;
  }
}
