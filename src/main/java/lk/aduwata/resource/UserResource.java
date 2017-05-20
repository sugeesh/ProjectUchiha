package lk.aduwata.resource;

import lk.aduwata.model.User;

import java.util.Date;

/**
 * ItemResource is for sending the item details to the frontend.
 *
 * @author Sugeesh Chandraweera
 */
public class UserResource {
    private int user_id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String mobile;
    private Integer type;
    private Date birthday;
    private String district;

    public UserResource() {
    }

    public UserResource(int user_id, String name, String email, String password, String address, String mobile, Integer type, Date birthday, String district) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
        this.type = type;
        this.birthday = birthday;
        this.district = district;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public static UserResource createResource(User user) {
        UserResource userResource = new UserResource();
        userResource.setUser_id(user.getId());
        userResource.setName(user.getName());
        userResource.setAddress(user.getAddress());
        userResource.setMobile(user.getMobile());
        userResource.setType(user.getType());
        userResource.setBirthday(user.getBirthday());
        userResource.setDistrict(user.getDistrict());
        userResource.setEmail(user.getEmail());
        return userResource;
    }
}

