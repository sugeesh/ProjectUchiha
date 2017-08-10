package lk.aduwata.model;

import javax.persistence.*;

/**
 * @author Sugeesh Chandraweera
 */
//@MappedSuperclass

@Entity
@DiscriminatorColumn(name="Vehicle_TYPE")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(referencedColumnName = "item_id")
@Table(name="Vehicle")
public class Vehicle extends ItemDetail{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer id;*/

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private String year;

    @Column(name = "v_condition")
    private String condition;

    // km
    @Column(name = "mileage")
    private double mileage;

    // cc
    @Column(name = "encapacity")
    private int encapacity;
/*
    // sale or rent, 1 = sale, 0 = rent
    @Column(name = "state")
    private int state;*/

    public Vehicle() {
    }

 /*   public Vehicle(String brand, String year, String condition, double mileage, int encapacity, int state) {
        this.brand = brand;
        this.year = year;
        this.condition = condition;
        this.mileage = mileage;
        this.encapacity = encapacity;
        this.state = state;
    }
*/


  /*  public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getEncapacity() {
        return encapacity;
    }

    public void setEncapacity(int encapacity) {
        this.encapacity = encapacity;
    }

   /* public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }*/
}
