package com.edwar.app.decorators;

import com.edwar.app.mapers.Order;
import com.edwar.app.interfaces.IReport;

public abstract class BaseDecorator implements IReport {

    protected IReport wrappee;

    public BaseDecorator(IReport report) {
        this.wrappee = report;
    }

    @Override
    public String generate(Order order) {
        return wrappee.generate(order);
    }

}
