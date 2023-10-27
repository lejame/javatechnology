package vn.edu.tdtd.lab6_1;

import lombok.Getter;

@Getter
public class Product {
    private int id ;
    private String name;
    private Double price;
    private String Depcription;

    public Product(int id, String name, Double price, String Depcription){
        this.id = id;
        this.name = name;
        this.price = price;
        this.Depcription = Depcription;
    }
}
