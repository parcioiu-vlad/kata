package com.daily.programmer.hubspot.api;

import com.daily.programmer.hubspot.model.Partner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by parci on 8/12/2017.
 */
public class PartnersRestApi {

    public List<Partner> getPartners() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://candidate.hubteam.com/candidateTest");
        webTarget = webTarget.path("v2/partners");

        webTarget = webTarget.queryParam("userKey","8e3dafb2119b1991d27dc8cdb765");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        LinkedHashMap response  = invocationBuilder.get(LinkedHashMap.class);

        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.convertValue(response.get("partners"), new TypeReference<List<Partner>>() { });

    }

}
