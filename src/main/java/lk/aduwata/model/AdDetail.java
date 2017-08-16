package lk.aduwata.model;

import javax.persistence.*;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "AdDetail")
public class AdDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_detail_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_field_id",
            referencedColumnName = "ad_field_id",
            foreignKey = @ForeignKey(name = "ADDETAILL_ADFIELD_FK")
    )
    private AdField field;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertisement_id",
            referencedColumnName = "advertisement_id",
            foreignKey = @ForeignKey(name = "ADDDETAIL_ADVERTISEMENT_FK")
    )
    private Advertisement advertisement;


    @Column(name = "value")
    private String value;

    public AdDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdField getField() {
        return field;
    }

    public void setField(AdField field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
