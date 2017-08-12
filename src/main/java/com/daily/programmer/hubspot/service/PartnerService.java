package com.daily.programmer.hubspot.service;


import com.daily.programmer.hubspot.model.AvailableDate;
import com.daily.programmer.hubspot.model.Country;
import com.daily.programmer.hubspot.model.Partner;

import java.util.*;

public class PartnerService {

    public Set<Country> getCountriesFromPartners(List<Partner> partnerList) {

        Map<Country, List<Partner>> countryListMap = getCountriesMap(partnerList);

        for (Map.Entry<Country, List<Partner>> entry : countryListMap.entrySet()) {

            Country country = entry.getKey();

            Map<String, Long> availableDates = getAvailableSortedDatesCount(entry.getValue());
            AvailableDate availableDate = getMaxDates(availableDates);

            country.setStartDate(availableDate.getStartDate());

            for (Partner partner : entry.getValue()) {

                if (partnerHasDate(partner, availableDate)) {
                    List<String> attendees = country.getAttendees();

                    if (attendees == null) {
                        attendees = new ArrayList<String>();
                        country.setAttendees(attendees);
                    }

                    attendees.add(partner.getEmail());
                }
            }

            country.setAttendeeCount((long) country.getAttendees().size());
        }

        return countryListMap.keySet();
    }

    /**
     * Return a map by country/partners
     * @param partnerList
     * @return
     */
    private Map<Country, List<Partner>> getCountriesMap(List<Partner> partnerList) {
        Map<Country, List<Partner>> countryListMap = new HashMap<Country, List<Partner>>(partnerList.size());

        for (Partner partner : partnerList) {

            Country country = new Country(partner.getCountry());

            List<Partner> partList = countryListMap.get(country);
            if (partList == null) {
                partList = new ArrayList<Partner>();
                countryListMap.put(country, partList);
            }
            partList.add(partner);

        }

        return countryListMap;
    }

    /**
     * Returns a map with available dates counts
     * @param partnerList
     * @return
     */
    private Map<String, Long> getAvailableSortedDatesCount(List<Partner> partnerList) {

        Map<String, Long> availableDateMap = new TreeMap<String, Long>();

        for (Partner partner : partnerList) {
            for (String availableDate : partner.getAvailableDates()) {
                Long count = availableDateMap.get(availableDate);
                if (count == null) {
                    count = 0L;
                }
                availableDateMap.put(availableDate, ++count);
            }
        }

        return  availableDateMap;
    }

    private AvailableDate getMaxDates(Map<String, Long> availableDates) {
        int i;
        int maxPos;
        int max = 0;

        int arraySize = availableDates.values().size();

        int[][] dateArray = new int[arraySize][arraySize];

        Object[] values = availableDates.values().toArray();

        dateArray[0][1] = (int) ((Long)values[0] + (Long)values[1]);
        maxPos = 0;

        for (i=1;i<values.length-1;i++) {
            dateArray[i][i+1] = (int) ((Long)values[i] + (Long)values[i+1]);

            if (dateArray[i][i+1] > max) {
                max = dateArray[i][i+1];
                maxPos = i;
            }
        }

        Object[] valuesDate = availableDates.keySet().toArray();

        AvailableDate availableDate = new AvailableDate();
        availableDate.setStartDate((String) valuesDate[maxPos]);

        if (valuesDate.length >= maxPos + 1) {
            availableDate.setEndDate((String) valuesDate[maxPos + 1]);
        }


        return availableDate;

    }

    private boolean partnerHasDate(Partner partner, AvailableDate availableDate) {

        return availableDate.getStartDate() != null &&
                partner.getAvailableDates().contains(availableDate.getStartDate()) &&
                partner.getAvailableDates().contains(availableDate.getEndDate());

    }

}
