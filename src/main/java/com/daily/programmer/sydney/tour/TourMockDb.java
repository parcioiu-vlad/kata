package com.daily.programmer.sydney.tour;

import java.util.HashMap;
import java.util.Map;

public class TourMockDb {

    private static TourMockDb instance;

    private Map<String, Tour> mockDb;

    private TourMockDb() {
        Tour operaHouse = new Tour("OH", "Opera house tour", 300.00);
        Tour sydneyBridge = new Tour("BC", "Sydney Bridge Climb", 110.00);
        Tour sydneySky = new Tour("SK", "Sydney Sky Tower", 30.00);

        mockDb = new HashMap<>(3);

        mockDb.put("OH", operaHouse);
        mockDb.put("BC", sydneyBridge);
        mockDb.put("SK", sydneySky);
    }

    public static TourMockDb getInstance() {
        if (instance == null) {
            instance = new TourMockDb();
        }

        return instance;
    }

    public Tour getTourById(String id) {
        return new Tour(mockDb.get(id));
    }

}
