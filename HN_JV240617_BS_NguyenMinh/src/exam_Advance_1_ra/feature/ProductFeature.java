package exam_Advance_1_ra.feature;

import exam_Advance_1_ra.business.design.IGenericService;
import exam_Advance_1_ra.business.entity.Product;
import exam_Advance_1_ra.business.implement.ProductService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductFeature {
    private static IGenericService<Product, String> product = new ProductService();

    //Add new Product
    public static void addNewProduct(Scanner sc) {
        int number;
        while (true) {
            try {
                System.out.println("Nhập số product bạn muốn thêm ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Bạn phải nhập là số, hãy thử lại");
            }
        }
        for (int i = 0; i < number; i++) {
            Product newProduct = new Product();
            System.out.println("Thêm Product " + (i + 1));
            newProduct.inputData(sc);
            product.save(newProduct);
        }
        System.out.println("Thêm " + number + " product thành công");

    }

    //Display all product
    public static void displayAllProduct() {
        int count = 0;
        for (Product product : product.getAll()) {
            System.out.println(product);
            count++;
        }
        System.out.println("Shop có " + count + " products");
    }

    //Sort products by price in descending order
    public static void sortProduct() {
        List<Product> sortedList = product.getAll().stream()
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .toList();
        for (Product product : sortedList) {
            System.out.println(product);
        }
        System.out.println("Sắp xếp thành công");
    }

    //Delete product by Id
    public static void deleteProductById(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product đang trống");
            return;
        }
        System.out.println("Nhập product Id bạn muốn xóa");
        String productId = sc.nextLine();
        product.delete(productId);
    }

    //Search Product By ProductName
    public static void searchProductByName(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product đang trống");
            return;
        }
        System.out.println("Nhập product name bạn muốn tìm kiếm");
        String productName = sc.nextLine();
        int count = 0;
        for (Product product : product.getAll()) {
            if (product.getProductName().contains(productName)) {
                System.out.println(product);
                count++;
            }
        }
        System.out.println("Tồn tại " + count + " products");
    }

    //Update Product by ProductId
    public static void updateProductInformation(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product đang trống");
            return;
        }
        System.out.println("Nhập product Id bạn muốn update");
        String productId = sc.nextLine();
        if(product.findById(productId) != null){
            product.save(product.findById(productId));
        }else{
            System.err.println("Không tồn tại product với Id: " + productId);
        }
    }
}
