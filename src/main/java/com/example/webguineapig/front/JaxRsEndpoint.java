package com.example.webguineapig.front;

import com.example.webguineapig.middle.MiddleDistributor;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Component
@Path("/jaxrs")
public class JaxRsEndpoint {

    private final MiddleDistributor middleDistributor;

    public JaxRsEndpoint(MiddleDistributor middleDistributor) {
        this.middleDistributor = middleDistributor;
    }

    @GET
    public void get(@QueryParam("payload") String payload) {
        middleDistributor.proceed(payload);
    }

}
