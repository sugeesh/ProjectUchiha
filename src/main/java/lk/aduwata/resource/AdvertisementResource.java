package lk.aduwata.resource;


import lk.aduwata.model.Advertisement;
import lk.aduwata.model.Category;
import lk.aduwata.model.SubCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * AdvertisementResource is for sending the item details to the frontend.
 *
 * @author Sugeesh Chandraweera
 */
public class AdvertisementResource {
    private int advertisement_id;
    private String district;
    private int category_id;
    private String category_name;
    private int subCategory_id;
    private String subCategory_name;
    private String title;
    private String description;
    private double price;
    private String contact;
    private Object details;
    private List<AdDetailResource> detailsObjList;
    private byte[] image;

    public AdvertisementResource() {
    }

    public int getAdvertisement_id() {
        return advertisement_id;
    }

    public void setAdvertisement_id(int advertisement_id) {
        this.advertisement_id = advertisement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static AdvertisementResource createResource(Advertisement advertisement) {
        AdvertisementResource advertisementResource = new AdvertisementResource();
        advertisementResource.setAdvertisement_id(advertisement.getId());
        advertisementResource.setTitle(advertisement.getTitle());
        advertisementResource.setDescription(advertisement.getDescription());
        advertisementResource.setDistrict(advertisement.getDistrict());
        advertisementResource.setCategory_id(advertisement.getCategory().getId());
        advertisementResource.setSubCategory_id(advertisement.getSubCategory().getId());
        advertisementResource.setPrice(advertisement.getPrice());
        advertisementResource.setContact(advertisement.getContact());
        advertisementResource.setCategory_name(advertisement.getCategory().getName());
        advertisementResource.setSubCategory_name(advertisement.getSubCategory().getName());
        return advertisementResource;
    }

    public static Advertisement createModel(AdvertisementResource advertisementResource) {
        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementResource.getAdvertisement_id());
        advertisement.setTitle(advertisementResource.getTitle());
        advertisement.setDescription(advertisementResource.getDescription());
        advertisement.setDistrict(advertisementResource.getDistrict());
        advertisement.setPrice(advertisementResource.getPrice());
        advertisement.setContact(advertisementResource.getContact());
        Category category = new Category();
        category.setId(advertisementResource.getCategory_id());
        SubCategory subCategory = new SubCategory();
        subCategory.setId(advertisementResource.getSubCategory_id());
        advertisement.setCategory(category);
        advertisement.setSubCategory(subCategory);
        return advertisement;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSubCategory_id() {
        return subCategory_id;
    }

    public void setSubCategory_id(int subCategory_id) {
        this.subCategory_id = subCategory_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSubCategory_name() {
        return subCategory_name;
    }

    public void setSubCategory_name(String subCategory_name) {
        this.subCategory_name = subCategory_name;
    }

    public List getDetailsObjList() {
        return detailsObjList;
    }

    public void setDetailsObjList(List detailsObjList) {
        this.detailsObjList = detailsObjList;
    }
}

