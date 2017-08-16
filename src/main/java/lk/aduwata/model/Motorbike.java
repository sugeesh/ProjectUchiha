package lk.aduwata.model;

/**
 * @author Sugeesh Chandraweera
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "item_id")
@DiscriminatorValue("Motorbike")
public class Motorbike extends Vehicle {

}
