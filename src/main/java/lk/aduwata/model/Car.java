package lk.aduwata.model;

import javax.persistence.*;

/**
 * @author Sugeesh Chandraweera
 */

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "item_id")
@DiscriminatorValue("Car")
public class Car extends Vehicle {
}
