package com.example.webguineapig.middle;

import com.example.webguineapig.sink.SinkDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class SimpleTransferExamples {

    @Autowired
    private SinkDistributor sinkDistributor;

    /* Trivial example, just direct transfer. */
    public void directTransfer(String payload) {
        sinkDistributor.proceed(payload);
    }

    public void mapTransfer(String payload) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("TEST", payload);
        sinkDistributor.proceed(myMap.get("TEST"));
    }

    /* These leads to FP for SonarQube, ok for Fortify. */
    public void noMapTransfer(String payload) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("TEST1", payload);
        sinkDistributor.proceed(myMap.get("TEST2"));
    }

    /* SonarQube false negative. ok for Fortify */
    public void lambdaTransfer(String payload) {
        String mappedValue = getTransferFunction() .apply(payload);
        sinkDistributor.proceed(mappedValue);
    }




    private Function<String, String> getTransferFunction() {
        return x -> x + "bla";
    }




}
