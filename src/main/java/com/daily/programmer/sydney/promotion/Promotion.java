package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;

import java.util.List;

public interface Promotion {

    /**
     * Return the computed deduction
     *
     * @param tourList
     * @return
     */
    Double calculate(List<Tour> tourList);

}
