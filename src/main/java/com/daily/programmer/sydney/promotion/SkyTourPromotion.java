package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;

import java.util.List;

public class SkyTourPromotion implements Promotion {

    @Override
    public Double calculate(List<Tour> tourList) {

        long operaHouseCount = 0;
        long skyTourCount = 0;

        for (Tour tour : tourList) {
            if (tour.getId().equals(TourCodeEnum.OH.name())) {
                operaHouseCount++;
            }
            else if (tour.getId().equals(TourCodeEnum.SK.name())) {
                skyTourCount++;
            }
        }

        if (skyTourCount != 0) {
            Tour skyTour = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());

            if (skyTourCount > operaHouseCount) {
                return operaHouseCount * skyTour.getPrice();
            }
            else {
                return skyTourCount * skyTour.getPrice();
            }
        }

        return 0.0;
    }

}
