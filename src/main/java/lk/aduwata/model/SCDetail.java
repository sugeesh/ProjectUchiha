package lk.aduwata.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "SCDetail")
public class SCDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scdetail_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id",
            referencedColumnName = "sub_category_id",
            foreignKey = @ForeignKey(name = "SCDETAILS_SUBCATEGORY_FK")
    )
    private SubCategory subCategory;

    // 0 - input text
    // 1 - input select
    // 2 - radio button
    // 3 - check box
    @Column(name = "type")
    private Integer type;

    @Column(name = "data_list")
    private String dataList;

    public SCDetail() {
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

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDataList() {
        return dataList;
    }

    public void setDataList(String dataList) {
        this.dataList = dataList;
    }
}
