package lk.aduwata.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Address")
    private String address;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "District")
    private String district;

    public User(String name, String email, String password, String address, String mobile, Integer type, Date birthday, String district) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
        this.type = type;
        this.birthday = birthday;
        this.district = district;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
