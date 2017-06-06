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

        List<Tour> tourList = new ArrayList<>();
        Tour tour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour tour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour tour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour tour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(tour1);
        tourList.add(tour2);
        tourList.add(tour3);
        tourList.add(tour4);

        Double deduction = skyPromotion.calculate(tourList);
        Double expectedDeduction = 20.0;

        tourList = new ArrayList<>();
        tour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        tour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        tour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        tour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());
        Tour tour5 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(tour1);
        tourList.add(tour2);
        tourList.add(tour3);
        tourList.add(tour4);
        tourList.add(tour5);

        Assert.assertEquals(expectedDeduction, deduction);
    }

}
