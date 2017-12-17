package com.daily.programmer.hubspot;


import com.daily.programmer.hubspot.api.PartnersRestApi;
import com.daily.programmer.hubspot.api.ResultsRestApi;
import com.daily.programmer.hubspot.model.Country;
import com.daily.programmer.hubspot.service.PartnerService;

import java.util.Set;

/**
 * It’s your first day at HubSpot, and you’re in charge of writing the logic to send invitations to a special two-day event in each country for HubSpot’s partners in those countries. We need to find the dates that’ll work best based on survey results that partners have sent in and determine how many people can attend.
 * You’re provided with an API that gives you a list of partners, their countries, and which dates they’re available in ISO 8601 format.
 * Another team will send out the invitations, but you need to tell them when we should host the event and who should attend by POSTing to an API.
 * The date you send in for the country should be the starting date of the two day period where the most partners can make it for both days in a row. In case of multiple dates with the same number of partners, pick the earlier date. If there are no two days in a row when any partners can make it, return null.
 */
public class Main {

    //TODO improve, add ut, improve performance
    public static void main(String[] args) {
        
        PartnersRestApi partnersRestApi = new PartnersRestApi();
        ResultsRestApi resultsRestApi = new ResultsRestApi();
        PartnerService partnerService = new PartnerService();

        Set<Country> countries = partnerService.getCountriesFromPartners(partnersRestApi.getPartners());

        resultsRestApi.postCountries(countries);


    }
    

}
