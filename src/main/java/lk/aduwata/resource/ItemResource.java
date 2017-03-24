package lk.aduwata.resource;


import lk.aduwata.model.Item;

/**
 * ItemResource is for sending the item details to the frontend.
 *
 * @author Sugeesh Chandraweera
 */
public class ItemResource {
    private int itemId;
    private String name;
    private double price;
    private String color;
    private String size;
    private boolean used;
    private String description;


    public ItemResource() {
    }

    public ItemResource(int itemId, String name, double price, String color, String size, boolean used, String description) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.used = used;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ItemResource createResource(Item item) {
        ItemResource itemResource = new ItemResource();
        itemResource.setItemId(item.getItemId());
        itemResource.setName(item.getName());
        itemResource.setPrice(item.getPrice());
        itemResource.setColor(item.getColor());
        itemResource.setSize(item.getSize());
        itemResource.setUsed(item.getUsed());
        itemResource.setDescription(item.getDescription());
        return itemResource;
    }
}

