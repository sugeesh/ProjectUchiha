package lk.aduwata.model;

import javax.persistence.*;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "Favourite")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertisement_id",
            referencedColumnName = "advertisement_id",
            foreignKey = @ForeignKey(name = "FAVOURITE_ITEM_FK")
    )
    private Advertisement item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "FAVOURITE_USER_FK")
    )
    private User user;

    public Favourite() {
    }

    public Favourite(Advertisement item, User user) {
        this.item = item;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advertisement getItem() {
        return item;
    }

    public void setItem(Advertisement item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
