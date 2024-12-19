package com.edwar.app.strategies;

import com.edwar.app.interfaces.IDiscountStrategy;

public class SinDescuento implements IDiscountStrategy {

    @Override
    public double getDiscount(double total) {
        System.out.println("No hay descuentos para aplicar");
        return total;
    }

}
