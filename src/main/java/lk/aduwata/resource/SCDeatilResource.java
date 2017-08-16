package lk.aduwata.resource;

import lk.aduwata.model.AdField;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Sugeesh Chandraweera
 */
public class SCDeatilResource {
    private Integer id;
    private String name;
    private Integer type;
    private List dataList;


    public SCDeatilResource() {
    }

    public SCDeatilResource(Integer id, String name, Integer type, List dataList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dataList = dataList;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public static SCDeatilResource createResource(AdField scDetail) {
        SCDeatilResource scDeatilResource = new SCDeatilResource();
        scDeatilResource.setId(scDetail.getId());
        scDeatilResource.setName(scDetail.getName());
        scDeatilResource.setType(scDetail.getType());
        if (scDetail.getDataList() != null) {
            String[] splitted = scDetail.getDataList().split(",");
            List<String> dataList = new ArrayList<>();
            for(String word : splitted){
                dataList.add(word);
            }
            scDeatilResource.setDataList(dataList);
        }
        return scDeatilResource;
    }

    public static AdField createModel(SCDeatilResource scDeatilResource) {
        AdField scDetail = new AdField();
        scDetail.setId(scDeatilResource.getId());
        scDetail.setName(scDeatilResource.getName());
        scDetail.setType(scDeatilResource.getType());
        return scDetail;
    }

}
