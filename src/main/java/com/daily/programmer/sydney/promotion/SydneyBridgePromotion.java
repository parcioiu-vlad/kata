package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;

import java.util.List;

public class SydneyBridgePromotion implements Promotion {

    @Override
    public Double calculate(List<Tour> tourList) {
        long bridgeCount = tourList.stream().filter(t -> t.getId().equals(TourCodeEnum.BC.name())).count();

        if (bridgeCount >= 4) {
            return 20.0;
        }

        return 0.0;
    }

}
