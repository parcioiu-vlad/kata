package com.daily.programmer.sydney;

import com.daily.programmer.sydney.promotion.OperaHousePromotion;
import com.daily.programmer.sydney.promotion.Promotion;
import com.daily.programmer.sydney.promotion.SkyTourPromotion;
import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SydneyTest {

    @Test
    public void calculate() {
        Sydney sydney = new Sydney();

        List<Tour> tourList = new ArrayList<>();
        Tour tour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour tour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour tour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour tour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(tour1);
        tourList.add(tour2);
        tourList.add(tour3);
        tourList.add(tour4);

        List<Promotion> promotionList = new ArrayList<>();
        Promotion promotion = new OperaHousePromotion();

        promotionList.add(promotion);

        Double total = sydney.calculate(tourList, promotionList);
        Double expected = 710.00;

        Assert.assertEquals(expected, total);

        tourList = new ArrayList<>();
        tour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        tour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());

        tourList.add(tour1);
        tourList.add(tour2);

        promotionList = new ArrayList<>();
        promotion = new SkyTourPromotion();

        promotionList.add(promotion);

        total = sydney.calculate(tourList, promotionList);
        expected = 300.00;

        Assert.assertEquals(expected, total);
    }
}
