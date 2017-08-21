package lk.aduwata.resource;


import lk.aduwata.model.Advertisement;

import java.util.Date;

/**
 * AdvertisementResource is for sending the advertisement details to the frontend.
 *
 * @author Sugeesh Chandraweera
 */
public class AdvertisementResource {
    private int advertisement_id;
    private String title;
    private String description;
    private double price;
    private Date date;
    private String contact;
    private int category;
    private int subCategory;
    private byte[] image;


    public AdvertisementResource() {
    }

    public AdvertisementResource(int advertisement_id, String title, String description, double price, Date date, String contact, int category, int subCategory) {
        this.advertisement_id = advertisement_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.contact = contact;
        this.category = category;
        this.subCategory = subCategory;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(int subCategory) {
        this.subCategory = subCategory;
    }

    public static AdvertisementResource createResource(Advertisement advertisement) {
        AdvertisementResource advertisementResource = new AdvertisementResource();
        advertisementResource.setAdvertisement_id(advertisement.getId());
        advertisementResource.setTitle(advertisement.getTitle());
        advertisementResource.setDescription(advertisement.getDescription());
        advertisementResource.setPrice(advertisement.getPrice());
        advertisementResource.setContact(advertisement.getContact());
        advertisementResource.setDate(advertisement.getDate());
        advertisementResource.setCategory(advertisement.getCategory().getId());
        advertisementResource.setSubCategory(advertisement.getSubCategory().getId());
        return advertisementResource;
    }

    public static Advertisement createModel(AdvertisementResource advertisementResource) {
        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementResource.getAdvertisement_id());
        advertisement.setTitle(advertisementResource.getTitle());
        advertisement.setDescription(advertisementResource.getDescription());
        advertisement.setPrice(advertisementResource.getPrice());
        advertisement.setContact(advertisementResource.getContact());
        advertisement.setDate(advertisementResource.getDate());
        /*advertisement.setCategory(advertisementResource.getCategory());
        advertisement.setSubCategory(advertisementResource.getSubCategory());*/
        return advertisement;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

