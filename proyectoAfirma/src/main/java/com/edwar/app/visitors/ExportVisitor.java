package com.edwar.app.visitors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.edwar.app.mapers.Product;
import com.edwar.app.interfaces.IVisitor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public  class ExportVisitor implements IVisitor {

    /**
     * XML
     */
    @Override
    public void visit(OrderXML orderXML) {
        try {
            // Crear el documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Elemento raíz
            Element rootElement = doc.createElement("Products");
            doc.appendChild(rootElement);

            // Crear elementos para cada producto
            for (Product product : orderXML.getProductList()) {
                Element productElement = doc.createElement("Product");

                Element name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(product.getName()));
                productElement.appendChild(name);

                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(String.valueOf(product.getPrice())));
                productElement.appendChild(price);

                Element description = doc.createElement("Description");
                description.appendChild(doc.createTextNode(product.getDescription()));
                productElement.appendChild(description);

                Element amount = doc.createElement("Amount");
                amount.appendChild(doc.createTextNode(String.valueOf(product.getQuantity())));
                productElement.appendChild(amount);

                rootElement.appendChild(productElement);
            }

            // Escribir el contenido a un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(orderXML.getFilePath()));

            transformer.transform(source, result);

            System.out.println("Archivo XML generado exitosamente en: " + orderXML.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CSV
     */

    @Override
    public void visit(OrderCSV orderCSV) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderCSV.getFilePath()))) {
            writer.write("Nombre,Precio,Descripcion");
            writer.newLine();
            for (Product product : orderCSV.getProductList()) {
                writer.write(product.getName() + "," + product.getDescription() + ","  + product.getDescription());
                writer.newLine();
            }

            System.out.println("Exportación a CSV completada: " + orderCSV.getFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JSON
     */
    @Override
    public void visit(OrderJson orderJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(orderJson.getFilePath()), orderJson.getProductList());
            System.out.println("Exportación a JSON completada: " + orderJson.getFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
