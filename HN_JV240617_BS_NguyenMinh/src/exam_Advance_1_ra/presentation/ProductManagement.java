package exam_Advance_1_ra.presentation;

import exam_Advance_1_ra.feature.ProductFeature;

import java.util.Scanner;

public class ProductManagement {
    public static void showProductMenu(Scanner sc) {
        while (true) {
            System.out.println("********************PRODUCT-MANAGEMENT********************");
            System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá giảm dần");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi thông tin của sách theo mã sách");
            System.out.println("7. Quay lại");
            byte choice;
            while (true) {
                try {
                    System.out.println("Nhập lưạ chọn của bạn");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập là số, hãy thử lại");
                }
            }
            switch (choice) {
                case 1:
                    ProductFeature.addNewProduct(sc);
                    break;
                case 2:
                    ProductFeature.displayAllProduct();
                    break;
                case 3:
                    ProductFeature.sortProduct();
                    break;
                case 4:
                    ProductFeature.deleteProductById(sc);
                    break;
                case 5:
                    ProductFeature.searchProductByName(sc);
                    break;
                case 6:
                    ProductFeature.updateProductInformation(sc);
                    break;
                case 7:
                    return;
                default:
                    System.err.println("Bạn chọn các số từ 1 -> 7");
            }
        }
    }
}
