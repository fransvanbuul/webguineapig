package com.example.webguineapig.middle;

import com.example.webguineapig.middle.SimpleTransferExamples;
import org.springframework.stereotype.Component;

@Component
public class MiddleDistributor {

    private final SimpleTransferExamples simpleTransferExamples;

    public MiddleDistributor(SimpleTransferExamples simpleTransferExamples) {
        this.simpleTransferExamples = simpleTransferExamples;
    }

    public void proceed(String payload) {
        simpleTransferExamples.directTransfer(payload);
        // simpleTransferExamples.mapTransfer(payload);
  //      simpleTransferExamples.noMapTransfer(payload);
    //    simpleTransferExamples.lambdaTransfer(payload);
    }

}
