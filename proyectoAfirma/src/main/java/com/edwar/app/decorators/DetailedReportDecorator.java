package com.edwar.app.decorators;

import com.edwar.app.mapers.Order;
import com.edwar.app.interfaces.IReport;

import java.util.Set;

public class DetailedReportDecorator extends BaseDecorator{
    public DetailedReportDecorator(IReport iReport) {
        super(iReport);
    }

    @Override
    public String generate(Order order) {
        StringBuilder report = new StringBuilder();
        Set<String> keys = order.getDiscounts().keySet();
        report.append("######################################\n");
        report.append("###############Totals################\n");
        report.append("######################################\n");
        report.append( "* total......................$" + order.getTotal() + "\n");
        report.append( "* totalDiscount...............$" + order.getTotalDiscount() + "\n");
        report.append( "* totalPay...................$" + order.getTotalPay() + "\n");
        report.append("######################################\n");
        report.append("###############Discounts################\n");
        report.append("######################################\n");
        for (String key : keys) {
            report.append("- Discount "+key + ": $" + order.getDiscounts().get(key) + "\n");
        }
        return super.generate(order).concat(report.toString());
    }
}
