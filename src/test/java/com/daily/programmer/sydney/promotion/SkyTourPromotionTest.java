package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SkyTourPromotionTest {

    @Test
    public void calculateInvalidPromotion() {
        SkyTourPromotion skyPromotion = new SkyTourPromotion();

        Tour operaTour = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());
        List<Tour> tourList = new ArrayList<>(1);
        tourList.add(operaTour);

        Double deduction = skyPromotion.calculate(tourList);
        Double expectedDeduction = 0.0;

        Assert.assertEquals(expectedDeduction, deduction);
    }

    @Test
    public void calculateValidPromotion() {
        SkyTourPromotion skyPromotion = new SkyTourPromotion();

        List<Tour> tourList = new ArrayList<>(1);
        Tour operaTour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());

        tourList.add(operaTour1);
        tourList.add(operaTour2);
        tourList.add(operaTour3);
        tourList.add(operaTour4);

        Double deduction = skyPromotion.calculate(tourList);
        Double expectedDeduction = 30.0;

        tourList = new ArrayList<>(1);
        operaTour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        operaTour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());
        operaTour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());
        operaTour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.SK.name());

        tourList.add(operaTour1);
        tourList.add(operaTour2);
        tourList.add(operaTour3);
        tourList.add(operaTour4);

        Assert.assertEquals(expectedDeduction, deduction);
    }

}
