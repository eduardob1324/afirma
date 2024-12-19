package com.edwar.app;

import com.edwar.app.decorators.*;
import com.edwar.app.interfaces.IDiscountStrategy;
import com.edwar.app.interfaces.IVisitor;
import com.edwar.app.mapers.Order;
import com.edwar.app.mapers.Product;
import com.edwar.app.strategies.DescuentoClienteFrecuente;
import com.edwar.app.strategies.DescuentoTemporada;
import com.edwar.app.visitors.ExportVisitor;
import com.edwar.app.visitors.OrderCSV;
import com.edwar.app.visitors.OrderJson;
import com.edwar.app.visitors.OrderXML;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Product product1 = new Product(1, "Laptop", "Computadora personal", 17000.0, 1);
        Product product2 = new Product(2, "Smartphone", "Teléfono inteligente de última generación", 9500.0, 5);
        Product product3 = new Product(3, "Tablet", "Tablet ligera y portátil", 7000.0, 2);
        Product product4 = new Product(4, "Smartwatch", "Reloj inteligente con múltiples funciones", 3000.0, 5);
        Product product5 = new Product(5, "Monitor", "Monitor Full HD de 27 pulgadas", 12500.0, 2);

        List<Product> lista = new ArrayList<>();
        lista.add(product1);
        lista.add(product2);
        lista.add(product3);
        lista.add(product4);
        lista.add(product5);


        Order order = new Order(1, lista);
        order.calculateTotal();
        IDiscountStrategy descuento = new DescuentoClienteFrecuente();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>> Iniciando el proceso <<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Total de la orden realizada $" + order.getTotal() );
        System.out.println("Aplicando descuento de Cliente frecuente 5%");
        order.addDiscount("Cliente frecuente", descuento.getDiscount(order.getTotal()));
        order.calculateTotalDiscount();
        order.calculateTotalPrice();
        System.out.println("Total a pagar con descuento de cliente frecuente 5%: $" + order.getTotalPay());
        descuento = new DescuentoTemporada();
        System.out.println("Aplicando descuento de Temporado 15%");
        order.addDiscount("Temporada", descuento.getDiscount(order.getTotal()));
        order.calculateTotalDiscount();
        order.calculateTotalPrice();
        System.out.println("Total a pagar con descuento de Temporado 15% mas descuento de cliente frecuente 5%: $" + order.getTotalPay());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        BaseDecorator reportDecorator = new SimpleReportDecorator(new Reporte());
        System.out.println(">>>>>>>>>>>>>>>>> Generando reporte simple <<<<<<<<<<<<<<<<<<<<<<<<");
        reportDecorator = new SimpleReportDecorator(new Reporte());
        System.out.println(reportDecorator.generate(order));

        System.out.println(">>>>>>>>>>>>>>>>> Generando reporte Detallado <<<<<<<<<<<<<<<<<<<<<<<<");
        reportDecorator = new DetailedReportDecorator(new Reporte());
        System.out.println(reportDecorator.generate(order));

        System.out.println(">>>>>>>>>>>>>>>>> Generando reporte extendido <<<<<<<<<<<<<<<<<<<<<<<<");
        reportDecorator = new ExtendedReportDecorator(new Reporte());
        System.out.println(reportDecorator.generate(order));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        OrderCSV orderCSV = new OrderCSV(1, lista, "./reportes/products.csv");
        OrderJson orderJson = new OrderJson(1, lista, "./reportes/products.json");
        OrderXML orderXml = new OrderXML(1, lista, "./reportes/products.xml");
        IVisitor visitor = new ExportVisitor();
        System.out.println(">>>>>>>>>>>>>>>>> Exportación a CSV <<<<<<<<<<<<<<<<<<<<<<<<");
        visitor.visit(orderCSV);
        System.out.println(">>>>>>>>>>>>>>>>> Exportación a XML <<<<<<<<<<<<<<<<<<<<<<<<");
        visitor.visit(orderXml);
        System.out.println(">>>>>>>>>>>>>>>>> Exportación a JSON <<<<<<<<<<<<<<<<<<<<<<<<");
        visitor.visit(orderJson);
    }
}