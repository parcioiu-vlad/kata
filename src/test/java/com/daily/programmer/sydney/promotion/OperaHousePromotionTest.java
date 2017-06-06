package com.daily.programmer.sydney.promotion;

import com.daily.programmer.sydney.tour.Tour;
import com.daily.programmer.sydney.tour.TourCodeEnum;
import com.daily.programmer.sydney.tour.TourMockDb;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OperaHousePromotionTest {

    private Logger LOG = LoggerFactory.getLogger(OperaHousePromotionTest.class);

    @Test
    public void calculateInvalidPromotion() {
        OperaHousePromotion operaHousePromotion = new OperaHousePromotion();

        Tour operaTour = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        List<Tour> tourList = new ArrayList<>(1);
        tourList.add(operaTour);

        Double deduction = operaHousePromotion.calculate(tourList);
        Double expectedDeduction = 0.0;

        LOG.debug("Got total : " + deduction);

        Assert.assertEquals(expectedDeduction, deduction);
    }

    @Test
    public void calculateValidPromotion() {
        OperaHousePromotion operaHousePromotion = new OperaHousePromotion();

        List<Tour> tourList = new ArrayList<>(1);
        Tour operaTour1 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour2 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour3 = TourMockDb.getInstance().getTourById(TourCodeEnum.OH.name());
        Tour operaTour4 = TourMockDb.getInstance().getTourById(TourCodeEnum.BC.name());

        tourList.add(operaTour1);
        tourList.add(operaTour2);
        tourList.add(operaTour3);
        tourList.add(operaTour4);

        Double deduction = operaHousePromotion.calculate(tourList);
        Double expectedDeduction = 300.0;

        LOG.debug("Got total : " + deduction);

        Assert.assertEquals(expectedDeduction, deduction);
    }

}
