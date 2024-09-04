package exam_Advance_1_ra.validate;

import exam_Advance_1_ra.business.design.IGenericService;
import exam_Advance_1_ra.business.entity.Catalog;
import exam_Advance_1_ra.business.entity.Product;
import exam_Advance_1_ra.business.implement.CatalogService;
import exam_Advance_1_ra.business.implement.ProductService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductValidate {
    private static IGenericService<Product,String> products = new ProductService();
    private static IGenericService<Catalog,Integer> categories = new CatalogService();

    //Validate Product Id
    public static String inputProductId(Scanner sc){
        String productIdRegex = "^P\\d{4}$";
        while (true){
            System.out.println("Nhập vào Product Id");
            String productId = sc.nextLine();
            if(Pattern.matches(productIdRegex,productId)){
                boolean check = false;
                for(Product product: products.getAll()){
                    if(product.getProductId().equals(productId)){
                        check = true;
                        System.err.println("ProductId đã tồn tại");
                        break;
                    }
                }
                if(!check){
                    return productId;
                }
            }else{
                System.err.println("Bắt đầu bằng chữ cáí P và thêm 4 kí tự số ");
            }
        }
    }

    //Validate Product Name
    public static String inputProductName(Scanner sc) {
        while (true){
            System.out.println("Nhập vào Product Name");
            String productName = sc.nextLine();
            if(productName.trim().isEmpty()){
                System.err.println("Product name không được null");
            }else{
                return productName;
            }
        }
    }

    //Validate Product Price
    public static double inputProductPrice(Scanner sc) {
        double productPrice;
        while (true){
            while (true) {
                try {
                    System.out.println("Nhập vào product price");
                    productPrice = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn cần phải nhập số, vui lòng nhập lại");
                }
            }
            if(productPrice > 0){
                return productPrice;
            }else{
                System.err.println("Product price phải lớn hơn 0");
            }
        }
    }

    //Validate Product Descriptions
    public static String inputProductDescriptions(Scanner sc) {
        System.out.println("Nhập vao product description");
        return sc.nextLine();
    }

    //Validate Catalog
    public static Catalog inputProductCatalog(Scanner sc) {
        System.out.println("List Category");
        for (Catalog catalog: categories.getAll()){
            System.out.println(catalog);
        }
        int categoryId;
        while (true){
            while (true) {
                try {
                    System.out.println("Nhập vào category id bạn muốn thêm vào");
                    categoryId = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn cần phải nhập là số, vui lòng nhập lại");
                }
            }
            if(categories.findById(categoryId) != null){
                return categories.findById(categoryId);
            }else{
                System.err.println("Không thể tìm kiếm category với Id: " + categoryId +", vui lòng nhập lại");
            }
        }
    }

    //Validate Product Stock
    public static int inputProductStock(Scanner sc) {
        int categoryStock;
        while (true){
            while (true) {
                try {
                    System.out.println("Nhập vào category stock bạn muốn thêm vào");
                    categoryStock = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn cần phải nhập là số, vui lòng nhập lại");
                }
            }
            if(categoryStock< 10){
                System.err.println("Category stock phải lớn hơn 10");
            }else{
                return categoryStock;
            }
        }
    }

    //Validate Product Status
    public static boolean inputProductStatus(Scanner sc) {
        while (true){
            System.out.println("Nhập vào Product status ( true | false )");
            String productStatus = sc.nextLine().toLowerCase();
            if(productStatus.equals("false") || productStatus.equals("true")){
                return Boolean.parseBoolean(productStatus);
            }else{
                System.err.println("status phải là true or false");
            }
        }
    }

}
