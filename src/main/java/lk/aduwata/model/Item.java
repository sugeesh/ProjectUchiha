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
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "state")
    private Integer state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(name = "ITEM_CATEGORY_FK")
    )
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id",
            referencedColumnName = "sub_category_id",
            foreignKey = @ForeignKey(name = "ITEM_SUBCATEGORY_FK")
    )
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_detail_id",
            referencedColumnName = "item_detail_id",
            foreignKey = @ForeignKey(name = "ITEM_ITEMDETAIL_FK")
    )
    private ItemDetail itemDetail;


    public Item() {
    }

    public Item(String name, String description, Double price, String contactNumber, Date date, Integer state, Category category, SubCategory subCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.contactNumber = contactNumber;
        this.date = date;
        this.state = state;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
