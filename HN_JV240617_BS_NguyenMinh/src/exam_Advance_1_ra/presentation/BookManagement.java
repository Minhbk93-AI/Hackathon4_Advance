package exam_Advance_1_ra.presentation;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("************************BASIC-MENU************************");
            System.out.println("1.Quản lý danh mục");
            System.out.println("2.Quản lý sản phẩm");
            System.out.println("3.Dành cho người dùng");
            System.out.println("4.Thoát");
            byte choice;
            while (true) {
                try {
                    System.out.println("Nhập lựa chọn của bạn");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn phải nhập là số, hãy thử lại");
                }
            }
            switch (choice) {
                case 1:
                    CatalogManagement.showCatalogMenu(sc);
                    break;
                case 2:
                    ProductManagement.showProductMenu(sc);
                    break;
                case 3:
                    UserManagement.showMenuUser(sc);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Bạn phải chọn số từ 1-4");

            }
        }

    }
}
