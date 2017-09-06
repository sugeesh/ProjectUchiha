package lk.aduwata.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * This is the model class for the Advertisement.
 *
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "Advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description",length = 10000)
    private String description;

    @Column(name = "district")
    private String district;

    @Column(name = "price")
    private Double price;

    @Column(name = "date")
    private Date date;

    @Column(name = "contact")
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(name = "ADVERTISEMENT_CATEGORY_FK")
    )
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id",
            referencedColumnName = "sub_category_id",
            foreignKey = @ForeignKey(name = "ADVERTISEMENT_SUBCATEGORY_FK")
    )
    private SubCategory subCategory;

    public Advertisement() {
    }

    public Advertisement(String title, String description, String district, Double price, Date date, String contact, Category category, SubCategory subCategory) {
        this.title = title;
        this.description = description;
        this.district = district;
        this.price = price;
        this.date = date;
        this.contact = contact;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
