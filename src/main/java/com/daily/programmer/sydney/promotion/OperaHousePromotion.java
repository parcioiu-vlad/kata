package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;

import java.util.List;

public class OperaHousePromotion implements Promotion {

    @Override
    public Double calculate(List<Tour> tourList) {

        long operaHouseCount = tourList.stream().filter(t -> t.getId().equals(TourCodeEnum.OH.name())).count();

        if (operaHouseCount == 3) {
            Tour operaHouseTour = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
            return operaHouseTour.getPrice();
        }

        return 0.0;
    }
}
