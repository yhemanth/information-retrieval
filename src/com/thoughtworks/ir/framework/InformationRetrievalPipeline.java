package com.thoughtworks.ir.framework;

import com.thoughtworks.ir.contentextraction.ContentExtractionStage;
import com.thoughtworks.ir.contentextraction.SampleBrandContentExtractor;
import com.thoughtworks.ir.contentretrieval.SampleBrandContentRetriever;
import com.thoughtworks.ir.contentretrieval.RawContentRetrievalStage;
import com.thoughtworks.ir.domain.Brand;

public class InformationRetrievalPipeline {

  private Iterable<IStage> stages;

  public static void main(String[] args) {
    InformationRetrievalPipeline informationRetrievalPipeline = new InformationRetrievalPipeline();
    informationRetrievalPipeline.addStage(new RawContentRetrievalStage(new SampleBrandContentRetriever()));
    informationRetrievalPipeline.addStage(new ContentExtractionStage(new SampleBrandContentExtractor()));
    informationRetrievalPipeline.start();
  }

  private void start() {
    firstStage().run(new Message(new Brand()));
  }

  private IStage firstStage() {
    return null;  //To change body of created methods use File | Settings | File Templates.
  }

  private void addStage(IStage stage) {
    lastStage().nextStage(stage);
  }

  private IStage lastStage() {
    return null;  //To change body of created methods use File | Settings | File Templates.
  }
}
