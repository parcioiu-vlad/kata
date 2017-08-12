package com.daily.programmer.hubspot.model;

import java.util.List;

/**
 * Created by parci on 8/12/2017.
 */
public class Partner {

    private String firstName;

    private String lastName;

    private String email;

    private String Country;

    private List<String> availableDates;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public List<String> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<String> availableDateList) {
        this.availableDates = availableDateList;
    }
}
