package com.example.proy1bueno.listProductsUser.data;

import com.example.proy1bueno.beans.Product;

import java.util.ArrayList;

public class DataProduct {
    private String message;
    private ArrayList<Product> lstProducts;


    public String getMessage() {
        return message;
    }
    public ArrayList<Product> getLstProducts() {
        return lstProducts;
    }
    public void setLstProducts(ArrayList<Product> lstProducts) {
        this.lstProducts = lstProducts;
    }
}
