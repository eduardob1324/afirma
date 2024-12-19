package com.edwar.app.strategies;

import com.edwar.app.interfaces.IDiscountStrategy;

public class DescuentoClienteFrecuente implements IDiscountStrategy {

    @Override
    public double getDiscount(double total) {
        return total * .05;
    }


}
