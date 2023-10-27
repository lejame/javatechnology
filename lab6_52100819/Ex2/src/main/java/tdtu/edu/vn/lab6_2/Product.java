package tdtu.edu.vn.lab6_2;

import lombok.Getter;

@Getter
public class Product {
    private int id;
    private String name;
    private Double price;
    private String depcription;

    public Product(int id,String name,Double price, String depcription){
        this.id = id;
        this.name= name;
        this. price = price;
        this.depcription = depcription;
    }
}
