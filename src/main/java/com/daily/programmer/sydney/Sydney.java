package com.daily.programmer.sydney;

import com.daily.programmer.sydney.promotion.Promotion;
import com.daily.programmer.sydney.tour.Tour;

import java.util.List;

/**
 * This challenge is to build a tourist booking engine where customers can book tours and activities around the Sydney.
 * Specially, you're task today is to build the shopping cart system.
 * We will start with the following tours in our database.
 *
 * Id	Name	                Price
 * OH	Opera house tour	    $300.00
 * BC	Sydney Bridge Climb	    $110.00
 * SK	Sydney Sky Tower	    $30.00
 *
 * As we want to attract attention, we intend to have a few weekly specials.
 * We are going to have a 3 for 2 deal on opera house ticket. For example, if you buy 3 tickets, you will pay the price of 2 only getting another one completely free of charge.
 * We are going to give a free Sky Tower tour for with every Opera House tour sold
 * The Sydney Bridge Climb will have a bulk discount applied, where the price will drop $20, if someone buys more than 4
 * These promotional rules have to be as flexible as possible as they will change in the future.
 * Items can be added in any order.
 */
public class Sydney {

    public Double calculate(List<Tour> tourList, List<Promotion> promotionList) {

        if (tourList == null) {
            return 0.0;
        }

        if (promotionList == null) {
            return calculate(tourList);
        }

        double total = tourList.stream().mapToDouble(Tour::getPrice).sum();
        double deduction = promotionList.stream().mapToDouble(p -> p.calculate(tourList)).sum();

        return total - deduction;
    }

    public Double calculate(List<Tour> tourList) {

        if (tourList == null) {
            return 0.0;
        }

        return tourList.stream().mapToDouble(Tour::getPrice).sum();
    }

}
