package com.daily.programmer.aeroplane;

import ch.hsr.geohash.GeoHash;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

public class DistanceCalculator {

  private OpenskyRestClient openskyRestClient;

  public DistanceCalculator() {
    this.openskyRestClient = new OpenskyRestClient();
  }

  public Aeroplane getNearestAeroplane(double latitude, double longitude) {
    Aeroplane nearestAeroplane = new Aeroplane();

    GeoHash geohash = GeoHash.withCharacterPrecision(latitude, longitude, 6);
    String geohashString = geohash.toBase32();

    Trie<String, Aeroplane> aeroplaneTrie = getAeroplanes();

    while (geohashString.length() > 0) {
      SortedMap<String, Aeroplane> aeroplaneSortedMap =
          aeroplaneTrie.prefixMap(geohashString);

      if (aeroplaneSortedMap.isEmpty()) {
        geohashString = geohashString.substring(0, geohashString.length() - 1);
        continue;
      }

      List<Aeroplane> aeroplaneList = new ArrayList<>(aeroplaneSortedMap.values());

      double min = calculateDistance(latitude, longitude, aeroplaneList.get(0).getLatitude(),
          aeroplaneList.get(0).getLongitude());

      for (int i=1;i<aeroplaneList.size();i++) {
        if (calculateDistance(latitude, longitude, aeroplaneList.get(i).getLatitude(),
            aeroplaneList.get(i).getLongitude()) < min) {
          nearestAeroplane = aeroplaneList.get(i);
        }
      }

      nearestAeroplane.setGeodesicDistance(min);

      return nearestAeroplane;
    }

    return nearestAeroplane;
  }

  private Trie<String, Aeroplane> getAeroplanes() {
    List<Aeroplane> aeroplaneList = this.openskyRestClient.getAllAeroplanes();
    Trie<String, Aeroplane> aeroplaneTrie = new PatriciaTrie<>();

    aeroplaneList.forEach(aeroplane -> {
      if (aeroplane.getLatitude() == null || aeroplane.getLongitude() == null) {
        return;
      }

      String geohash = GeoHash.geoHashStringWithCharacterPrecision(aeroplane.getLatitude(),
          aeroplane.getLongitude(), 6);
      aeroplaneTrie.put(geohash, aeroplane);
    });

    return aeroplaneTrie;
  }

  private double calculateDistance(double lat1, double lon1,
      double lat2, double lon2) {

    double latDistance = Math.toRadians(lat1 - lat2);
    double lngDistance = Math.toRadians(lon1 - lon2);

    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
        * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return 6371000 * c;

  }

}
