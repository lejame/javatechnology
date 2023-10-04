package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phone", schema = "phonefactory")
public class PhoneEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_phone")
    private String idPhone;
    @Basic
    @Column(name = "id_manu")
    private String idManu;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "quantity")
    private int quantity;

    public String getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(String idPhone) {
        this.idPhone = idPhone;
    }

    public String getIdManu() {
        return idManu;
    }

    public void setIdManu(String idManu) {
        this.idManu = idManu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneEntity that = (PhoneEntity) o;
        return price == that.price && quantity == that.quantity && Objects.equals(idPhone, that.idPhone) && Objects.equals(idManu, that.idManu) && Objects.equals(name, that.name) && Objects.equals(color, that.color) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPhone, idManu, name, price, color, country, quantity);
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "idPhone='" + idPhone + '\'' +
                ", idManu='" + idManu + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    public PhoneEntity (String id,String id_manu,String name,int price,String color,String country,int quantity){
        this.idPhone = id;
        this.idManu = id_manu;
        this.name = name;
        this.price = price;
        this.color = color;
        this.country = country;
        this.quantity = quantity;
    }
    public PhoneEntity(){
    }
}
