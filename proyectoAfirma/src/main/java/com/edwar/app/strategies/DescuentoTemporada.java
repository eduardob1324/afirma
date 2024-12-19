package com.edwar.app.strategies;

import com.edwar.app.interfaces.IDiscountStrategy;

public class DescuentoTemporada implements IDiscountStrategy {

    @Override
    public double getDiscount(double total) {
        return total * .15;
    }


}
