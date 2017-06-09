package lk.aduwata.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "SubCategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(name = "SUBCATEGORY_CATEGORY_FK")
    )
    private Category category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.EAGER,orphanRemoval = false)
    private Collection<SCDetail> scDetails;

    public SubCategory() {
    }

    public SubCategory(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<SCDetail> getScDetails() {
        return scDetails;
    }

    public void setScDetails(Collection<SCDetail> scDetails) {
        this.scDetails = scDetails;
    }
}
