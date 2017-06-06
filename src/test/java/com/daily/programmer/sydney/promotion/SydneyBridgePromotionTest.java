package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 06.06.2017.
 */
public class SydneyBridgePromotionTest {

    @Test
    public void calculateInvalidPromotion() {
        SydneyBridgePromotion skyPromotion = new SydneyBridgePromotion();

        Tour operaTour = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        List<Tour> tourList = new ArrayList<>(1);
        tourList.add(operaTour);

        Double deduction = skyPromotion.calculate(tourList);
        Double expectedDeduction = 0.0;

        Assert.assertEquals(expectedDeduction, deduction);
    }

    @Test
    public void calculateValidPromotion() {
        SydneyBridgePromotion skyPromotion = new SydneyBridgePromotion();

        List<Tour> tourList = new ArrayList<>(1);
        Tour operaTour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour operaTour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour operaTour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour operaTour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(operaTour1);
        tourList.add(operaTour2);
        tourList.add(operaTour3);
        tourList.add(operaTour4);

        Double deduction = skyPromotion.calculate(tourList);
        Double expectedDeduction = 20.0;

        tourList = new ArrayList<>(1);
        operaTour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        operaTour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        operaTour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        operaTour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour operaTour5 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(operaTour1);
        tourList.add(operaTour2);
        tourList.add(operaTour3);
        tourList.add(operaTour4);
        tourList.add(operaTour5);

        Assert.assertEquals(expectedDeduction, deduction);
    }

}
