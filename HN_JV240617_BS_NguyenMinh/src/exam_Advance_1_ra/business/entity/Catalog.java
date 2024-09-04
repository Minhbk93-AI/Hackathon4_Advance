package exam_Advance_1_ra.business.entity;

import exam_Advance_1_ra.validate.CatalogValidate;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private String desciptions;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String desciptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.desciptions = desciptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDesciptions() {
        return desciptions;
    }

    public void setDesciptions(String desciptions) {
        this.desciptions = desciptions;
    }

    //Input Data Catalog
    public void inputData(Scanner sc){
        this.catalogId = CatalogValidate.inputCatalogId(sc);
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.desciptions = CatalogValidate.inputCatalogDescriptions(sc);
    }

    //Update Data Catalog
    public void saveData(Scanner sc){
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.desciptions = CatalogValidate.inputCatalogDescriptions(sc);
    }

    //Display Catalog
    @Override
    public String toString() {
        return "CatalogID: " +this.catalogId + "   |   CatalogName: "+this.catalogName +"\n"
                +"------------------------------------------------------------------";
    }
}
