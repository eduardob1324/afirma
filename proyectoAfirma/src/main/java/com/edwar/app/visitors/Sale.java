package com.edwar.app.visitors;

import com.edwar.app.interfaces.IVisitor;

public abstract class Sale {
    private int idSale;

    public abstract void Aceptar(IVisitor visitor);

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }
}
