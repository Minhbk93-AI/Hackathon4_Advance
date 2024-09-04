package exam_Advance_1_ra.presentation;

import exam_Advance_1_ra.feature.CatalogFeature;

import java.util.Scanner;

public class CatalogManagement {
    public static void showCatalogMenu(Scanner sc) {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************");
            System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sửa tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh muc theo mã danh mục");
            System.out.println("5. Quay lại");
            byte choice;
            while (true) {
                try {
                    System.out.println("Nhập lựa chọn của bạn");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập là số");
                }
            }
            switch (choice) {
                case 1:
                    CatalogFeature.addNewCatalog(sc);
                    break;
                case 2:
                    CatalogFeature.displayAllCatalog();
                    break;
                case 3:
                    CatalogFeature.UpdateNameCatalogById(sc);
                    break;
                case 4:
                    CatalogFeature.deleteCatalogById(sc);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Bạn phải nhập lựa chọn từ 1 -> 5");
            }
        }
    }

}
