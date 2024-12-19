package com.edwar.app.interfaces;

import com.edwar.app.visitors.OrderCSV;
import com.edwar.app.visitors.OrderJson;
import com.edwar.app.visitors.OrderXML;

public interface IVisitor {

    void visit(OrderXML orderXML);

    void visit(OrderCSV orderCSV);

    void visit(OrderJson orderJson);
}
