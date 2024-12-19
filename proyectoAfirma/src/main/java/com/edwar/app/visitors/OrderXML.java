package com.edwar.app.visitors;

import com.edwar.app.interfaces.ISale;
import com.edwar.app.mapers.Product;
import com.edwar.app.interfaces.IVisitor;

import java.util.List;

public class OrderXML implements ISale {

    private int idOrder;
    private List<Product> productList;
    private String filePath;

    public OrderXML(int idOrder, List<Product> productList, String filePath) {
        this.idOrder = idOrder;
        this.productList = productList;
        this.filePath = filePath;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void Aceptar(IVisitor visitor) {
        visitor.visit(this);
    }
}


