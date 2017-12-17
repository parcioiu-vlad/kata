package com.daily.programmer.hubspot.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by parci on 8/12/2017.
 */
public class Country implements Serializable {

    private long attendeeCount;
    private List<String> attendees;
    private String name;
    private String startDate;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Long getAttendeeCount() {
        return attendeeCount;
    }

    public void setAttendeeCount(Long attendeeCount) {
        this.attendeeCount = attendeeCount;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
