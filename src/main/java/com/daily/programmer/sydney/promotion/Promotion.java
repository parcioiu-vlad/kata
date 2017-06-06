package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;

import java.util.List;

public interface Promotion {

    public Double calculate(List<Tour> tourList);

    public default Double calculateTotal(List<Tour> tourList) {
        return tourList.stream().mapToDouble(Tour::getPrice).sum();
    }

}
