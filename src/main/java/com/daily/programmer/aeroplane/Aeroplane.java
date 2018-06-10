package com.daily.programmer.aeroplane;

public class Aeroplane {

  private String icao24;
  private String callsign;
  private String originCountry;
  private Integer timePosition;
  private Integer lastContact;
  private Double longitude;
  private Double latitude;
  private Double altitude;
  private Boolean onGround;
  private Double velocity;
  private Double heading;
  private Double verticalRate;
  private Double baroAltitude;
  private Double geodesicDistance;

  public String getIcao24() {
    return icao24;
  }

  public void setIcao24(String icao24) {
    this.icao24 = icao24;
  }

  public String getCallsign() {
    return callsign;
  }

  public void setCallsign(String callsign) {
    this.callsign = callsign;
  }

  public String getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(String originCountry) {
    this.originCountry = originCountry;
  }

  public Integer getTimePosition() {
    return timePosition;
  }

  public void setTimePosition(Integer timePosition) {
    this.timePosition = timePosition;
  }

  public Integer getLastContact() {
    return lastContact;
  }

  public void setLastContact(Integer lastContact) {
    this.lastContact = lastContact;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public Boolean getOnGround() {
    return onGround;
  }

  public void setOnGround(Boolean onGround) {
    this.onGround = onGround;
  }

  public Double getVelocity() {
    return velocity;
  }

  public void setVelocity(Double velocity) {
    this.velocity = velocity;
  }

  public Double getHeading() {
    return heading;
  }

  public void setHeading(Double heading) {
    this.heading = heading;
  }

  public Double getVerticalRate() {
    return verticalRate;
  }

  public void setVerticalRate(Double verticalRate) {
    this.verticalRate = verticalRate;
  }

  public Double getBaroAltitude() {
    return baroAltitude;
  }

  public void setBaroAltitude(Double baroAltitude) {
    this.baroAltitude = baroAltitude;
  }

  public Double getGeodesicDistance() {
    return geodesicDistance;
  }

  public void setGeodesicDistance(Double geodesicDistance) {
    this.geodesicDistance = geodesicDistance;
  }
}
