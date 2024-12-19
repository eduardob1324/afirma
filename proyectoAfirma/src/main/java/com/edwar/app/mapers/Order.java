package com.edwar.app.mapers;

import java.util.HashMap;
import java.util.List;

public class Order{

    private int idOrder;
    private List<Product> productList;
    private HashMap<String, Double> discounts;
    private double total;
    private double totalDiscount;
    private double totalPay;


    public Order(int id, List<Product> productList) {
        this.idOrder = id;
        this.productList = productList;
        this.discounts = new HashMap<>();
    }

    /**
     * Calculamos el total de la cuenta
     */
    public void calculateTotal(){
        double suma = 0;
        for (Product product : getProductList()) {
            suma += product.getPrice();
        }
        setTotal(suma);
    }

    /**
     * calcula el total de los descuentos
     */
    public void calculateTotalDiscount(){
         setTotalDiscount(discounts.values().stream().mapToDouble(Double::doubleValue).sum());
    }

    /**
     * se calcula el total ya con los descuentos aplicados
     */
    public void calculateTotalPrice(){
        setTotalPay(getTotal() - getTotalDiscount());
    }


    /**
     * agrega un descuento a la cuenta
     */
    public void addDiscount(String discount, double value){
        discounts.put(discount, value);
    }




    public int getId() {
        return idOrder;
    }

    public void setId(int idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPrice) {
        this.totalPay = totalPrice;
    }

    public HashMap<String, Double> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(HashMap<String, Double> discounts) {
        this.discounts = discounts;
    }

}


