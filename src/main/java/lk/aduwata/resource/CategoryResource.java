package lk.aduwata.resource;

import lk.aduwata.model.Category;

import javax.persistence.Column;

/**
 * @author Sugeesh Chandraweera
 */
public class CategoryResource {
    private int categoryId;
    private String name;
    private String description;

    public CategoryResource() {
    }

    public CategoryResource(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CategoryResource createResource(Category category){
        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setName(category.getName());
        categoryResource.setCategoryId(category.getCategoryId());
        categoryResource.setDescription(category.getDescription());
        return categoryResource;
    }

    public static Category createModel(CategoryResource categoryResource){
        Category category = new Category();
        category.setName(categoryResource.getName());
        category.setCategoryId(categoryResource.getCategoryId());
        category.setDescription(categoryResource.getDescription());
        return category;
    }
}
