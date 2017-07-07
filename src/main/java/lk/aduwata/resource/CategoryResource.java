package lk.aduwata.resource;

import lk.aduwata.model.Category;
import lk.aduwata.model.SubCategory;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sugeesh Chandraweera
 */
public class CategoryResource {
    private int category_id;
    private String name;
    private String description;
    private List subCategoryList;

    public CategoryResource() {
    }

    public CategoryResource(int category_id, String name, String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public List getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public static CategoryResource createResource(Category category){
        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setName(category.getName());
        categoryResource.setCategory_id(category.getId());
        categoryResource.setDescription(category.getDescription());
        categoryResource.setSubCategoryList(getSubCategoryList(category));
        return categoryResource;
    }

    public static Category createModel(CategoryResource categoryResource){
        Category category = new Category();
        category.setName(categoryResource.getName());
        category.setId(categoryResource.getCategory_id());
        category.setDescription(categoryResource.getDescription());
        return category;
    }

    private static List<SubCategoryResource> getSubCategoryList(Category category){
        ArrayList<SubCategoryResource> subCategoryResourceList = new ArrayList<>();
        for(SubCategory subCategory:category.getSubCategories()){
            subCategoryResourceList.add(SubCategoryResource.createResource(subCategory));
        }
//        category.getSubCategories().stream().forEach(subCategory -> {
//            subCategoryResourceList.add(SubCategoryResource.createResource(subCategory));
//        });
        return subCategoryResourceList;
    }
}
