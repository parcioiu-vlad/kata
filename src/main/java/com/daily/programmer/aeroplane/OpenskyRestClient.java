package com.daily.programmer.aeroplane;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

class OpenskyRestClient {

  private static final String openskyUrl = "https://opensky-network.org/api/states/all";

  private Client client;
  private WebTarget webTarget;

  OpenskyRestClient() {
    this.client = ClientBuilder.newClient();
    this.webTarget = client.target(openskyUrl);
  }

  List<Aeroplane> getAllAeroplanes() {
    List<Aeroplane> aeroplaneList = new ArrayList<>();

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

    LinkedHashMap response  = invocationBuilder.get(LinkedHashMap.class);
    List<List<Object>> aeroplanes = (List<List<Object>>) response.get("states");

    for (List<Object> plane: aeroplanes) {
      aeroplaneList.add(getAeroplane(plane));
    }

    return aeroplaneList;
  }

  private Aeroplane getAeroplane(List<Object> plane) {
    Aeroplane aeroplane = new Aeroplane();
    aeroplane.setIcao24((String) plane.get(0));
    aeroplane.setCallsign((String) plane.get(1));
    aeroplane.setOriginCountry((String) plane.get(2));

    Object timePosition = plane.get(3);

    if (timePosition instanceof Integer) {
      aeroplane.setTimePosition((Integer) timePosition);
    }

    Object lastContact = plane.get(4);

    if (lastContact instanceof Integer) {
      aeroplane.setLastContact((Integer) lastContact);
    }

    Object longitude = plane.get(5);

    if (longitude instanceof Integer) {
      aeroplane.setLongitude(((Integer) longitude).doubleValue());
    } else if (longitude instanceof Double) {
      aeroplane.setLongitude((Double) longitude);
    }

    Object latitude = plane.get(6);

    if (latitude instanceof Integer) {
      aeroplane.setLatitude(((Integer) latitude).doubleValue());
    } else if (latitude instanceof Double) {
      aeroplane.setLatitude((Double) latitude);
    }

    Object altitude = plane.get(7);

    if (altitude instanceof Integer) {
      aeroplane.setAltitude(((Integer) altitude).doubleValue());
    } else if (altitude instanceof Double) {
      aeroplane.setAltitude((Double) altitude);
    }

    Object onGroud = plane.get(8);

    aeroplane.setOnGround((Boolean) onGroud);

    Object velocity = plane.get(9);

    if (velocity instanceof Integer) {
      aeroplane.setVelocity(((Integer) velocity).doubleValue());
    } else if (velocity instanceof Double) {
      aeroplane.setVelocity((Double) velocity);
    }

    Object heading = plane.get(10);

    if (heading instanceof Integer) {
      aeroplane.setHeading(((Integer) heading).doubleValue());
    } else if (heading instanceof Double) {
      aeroplane.setHeading((Double) heading);
    }

    Object verticalRate = plane.get(11);

    if (verticalRate instanceof Integer) {
      aeroplane.setVerticalRate(((Integer) verticalRate).doubleValue());
    } else if (verticalRate instanceof Double) {
      aeroplane.setVerticalRate((Double) verticalRate);
    }

    Object baroAltitude = plane.get(13);

    if (baroAltitude instanceof Integer) {
      aeroplane.setBaroAltitude(((Integer) baroAltitude).doubleValue());
    } else if (baroAltitude instanceof Double) {
      aeroplane.setBaroAltitude((Double) baroAltitude);
    }

    return aeroplane;
  }

}
