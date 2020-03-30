package com.example.consumingwebservice;

import com.example.producingwebservice.GetCountryRequest;
import com.example.producingwebservice.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountriesClient extends WebServiceGatewaySupport {
private static final Logger log = LoggerFactory.getLogger(CountriesClient.class);

public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
        new SoapActionCallback(
        "http://example.com/producing-web-service/GetCountryRequest"));

        return response;
        }

}
