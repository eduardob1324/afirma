package com.edwar.app.decorators;

import com.edwar.app.mapers.Order;
import com.edwar.app.interfaces.IReport;

public class SimpleReportDecorator extends BaseDecorator {

    public SimpleReportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate(Order order) {
        StringBuilder report = new StringBuilder();
        report.append("######################################\n");
        report.append("###############Totals################\n");
        report.append("######################################\n");
        report.append( "* total......................$" + order.getTotal() + "\n");
        report.append( "* totalDiscount...............$" + order.getTotalDiscount() + "\n");
        report.append( "* totalPay...................$" + order.getTotalPay() + "\n");
        return super.generate(order).concat(report.toString());
    }


}
