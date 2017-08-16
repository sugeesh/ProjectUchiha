package lk.aduwata.model;

/**
 * @author Sugeesh Chandraweera
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AutoPart")
public class AutoPart extends Vehicle {

    @Column(name = "type")
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
