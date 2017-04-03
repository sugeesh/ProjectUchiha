package lk.aduwata.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * This is the model class for the Item.
 *
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "ItemName")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Size")
    private String size;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Color")
    private String color;

    @Column(name = "Used")
    private Boolean used;

    @Column(name = "Date")
    private Date date;

    @Column(name = "State")
    private Integer state;

    @Lob
    @Column(length=100000)
    private byte[] image;

    public Item() {
    }

    public Item(String name, String description, String size, Double price, String color, Boolean used, Date date, Integer state, byte[] image) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.color = color;
        this.used = used;
        this.date = date;
        this.state = state;
        this.image = image;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
