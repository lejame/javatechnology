package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manufacture", schema = "phonefactory")
public class ManufactureEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_manu")
    private String idManu;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "employee")
    private int employee;
    public ManufactureEntity(){
        this.idManu = null;
        this.name = null;
        this.location = null;
        this.employee = 0;
    }
    public ManufactureEntity(String idManu, String name, String location, int employee) {
        this.idManu = idManu;
        this.name = name;
        this.location = location;
        this.employee = employee;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufactureEntity that = (ManufactureEntity) o;
        return employee == that.employee && Objects.equals(idManu, that.idManu) && Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManu, name, location, employee);
    }

    @Override
    public String toString() {
        return "ManufactureEntity{" +
                "idManu='" + idManu + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employee=" + employee +
                '}';
    }
}
