package com.edwar.app.decorators;

import com.edwar.app.mapers.Order;
import com.edwar.app.mapers.Product;
import com.edwar.app.interfaces.IReport;

import java.util.List;

public class Reporte implements IReport {


    @Override
    public String generate(Order order) {
        StringBuilder report = new StringBuilder();
        report.append("######################################\n");
        report.append("###############Reporte################\n");
        report.append("######################################\n");
        List<Product> productList = order.getProductList();
        for (Product product : productList) {
            report.append( "- Product: " + product.getName() + "....$" + product.getPrice()+",  Cantidad:" + product.getQuantity() +"\n");
        };

        return report.toString();
    }


}
