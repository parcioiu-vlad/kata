package com.daily.programmer.hubspot.api;

import com.daily.programmer.hubspot.model.Country;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.Set;

public class ResultsRestApi {

    public Response postCountries(Set<Country> countries) {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("https://candidate.hubteam.com/candidateTest");
        webTarget = webTarget.path("v2/results");
        webTarget = webTarget.queryParam("userKey","8e3dafb2119b1991d27dc8cdb765");

        LinkedHashMap request  = new LinkedHashMap();
        request.put("countries", countries);

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.post(Entity.entity(request, MediaType.APPLICATION_JSON), Response.class);
        String body = response.readEntity(String.class);

        return response;

    }

}
