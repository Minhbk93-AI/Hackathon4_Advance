package exam_Advance_1_ra.feature;

import exam_Advance_1_ra.business.design.IGenericService;
import exam_Advance_1_ra.business.entity.Catalog;
import exam_Advance_1_ra.business.entity.Product;
import exam_Advance_1_ra.business.implement.CatalogService;
import exam_Advance_1_ra.business.implement.ProductService;

import java.util.Scanner;

public class CatalogFeature {
    private static IGenericService<Catalog, Integer> catagories = new CatalogService();
    private static IGenericService<Product,String> products = new ProductService();

    //Add new Catalog
    public static void addNewCatalog(Scanner sc) {
        int number;
        while (true) {
            try {
                System.out.println("Bạn hãy nhập số category bạn muốn thêm vào ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Bạn phải nhập là số, hãy thử lại");
            }
        }
        for (int i =0; i < number ;i++){
            Catalog newCatalog = new Catalog();
            System.out.println("Thêm catalog " + (i+1));
            newCatalog.inputData(sc);
            catagories.save(newCatalog);
        }
        System.out.println("Thêm "+number +" thành công");

    }

    //Display all Catalog
    public static void displayAllCatalog() {
        if(catagories.getAll().isEmpty()){
            System.err.println("List Catalog đang trống");
            return;
        }
        for(Catalog catalog: catagories.getAll()){
            System.out.println(catalog);
        }
    }

    //Update CatalogName By Id
    public static void UpdateNameCatalogById(Scanner sc) {
        if(catagories.getAll().isEmpty()){
            System.err.println("List Catalog đang trống");
            return;
        }
        int catalogId;
        while (true){
            try {
                System.out.println("Nhập catagory id bạn muốn thay đổi tên");
                catalogId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("Bạn phải chọn là số hãy nhập lại");
            }
        }
        String newCatalogName = "";
        if(catagories.findById(catalogId) !=null ){
            System.out.println("Nhập catalog Name bạn muốn thay đổi");
            newCatalogName = sc.nextLine();
            catagories.findById(catalogId).setCatalogName(newCatalogName);
            System.out.println("Cập nhật Catalog name thành công");
        }else {
            System.out.println("Cant found catalog with id: "+catalogId);
        }

    }

    //Delete Catalog By Id
    public static void deleteCatalogById(Scanner sc) {
        if(catagories.getAll().isEmpty()){
            System.err.println("List catalog đang trống");
            return;
        }
        int catalogId;
        while (true){
            try {
                System.out.println("Nhập catagory id bạn muốn thay đổi tên");
                catalogId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("Bạn nên nhập lại số, hãy thử lại");
            }
        }
        if(catagories.findById(catalogId) != null){
            boolean check = false;
            for (Product product : products.getAll()){
                if(product.getCatalog().getCatalogId() == catalogId){
                    check = true;
                    System.err.println("Không thể xóa category có products");
                    break;
                }
            }
            if(!check){
                catagories.delete(catalogId);
                System.out.println("Xoá thành công");
            }
        }else{
            System.err.println("Không tìm thấy catalog with id: "+catalogId);
        }
    }
}
