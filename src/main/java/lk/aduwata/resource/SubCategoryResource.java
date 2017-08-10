package lk.aduwata.resource;

import lk.aduwata.model.SubCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author Sugeesh Chandraweera
 */
public class SubCategoryResource {
    private Integer id;
    private String name;
    private String description;
    private List scdetailList;

    public SubCategoryResource() {
    }

    public SubCategoryResource(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List getScdetailList() {
        return scdetailList;
    }

    public void setScdetailList(List scdetailList) {
        this.scdetailList = scdetailList;
    }

    public static SubCategoryResource createResource(SubCategory subCategory) {
       SubCategoryResource subCategoryResource = new SubCategoryResource();
       subCategoryResource.setId(subCategory.getId());
       subCategoryResource.setName(subCategory.getName());
       subCategoryResource.setDescription(subCategory.getDescription());
       List scDetailList = new ArrayList();
//       subCategory.getScDetails().stream().forEach(scDetail -> scDetailList.add(SCDeatilResource.createResource(scDetail)));
    /*   for(SCDetail scDetail:subCategory.getScDetails()){
           scDetailList.add(SCDeatilResource.createResource(scDetail));
       }*/
       subCategoryResource.setScdetailList(scDetailList);
       return subCategoryResource;
    }

    public static SubCategory createModel(SubCategoryResource subCategoryResource) {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryResource.getId());
        subCategory.setName(subCategoryResource.getName());
        subCategory.setDescription(subCategoryResource.getDescription());
        return subCategory;
    }
}
