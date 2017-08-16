package lk.aduwata.model;

/**
 * @author Sugeesh Chandraweera
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Table(name = "Van_Bus")
//@DiscriminatorValue("Van_Bus")
@MappedSuperclass
public class Van_Bus extends Vehicle {

}
