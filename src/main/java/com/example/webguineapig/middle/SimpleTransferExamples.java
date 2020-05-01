package com.example.webguineapig.middle;

import com.example.webguineapig.sink.SinkDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleTransferExamples {

    @Autowired
    private SinkDistributor sinkDistributor;

    /* Trivial example, just direct transfer. */
    public void directTransfer(String payload) {
        sinkDistributor.proceed(payload);
    }




}
