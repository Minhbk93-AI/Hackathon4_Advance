package exam_Advance_1_ra.presentation;

import exam_Advance_1_ra.business.implement.CartService;

import java.util.Scanner;

public class UserManagement {
    public static void showMenuUser(Scanner sc) {
        while (true) {
            System.out.println("**************************MENU-USER**************************");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm vào giỏ hàng");
            System.out.println("3. Xem tất cả sản phẩm giỏ hàng");
            System.out.println("4. Thay đổi số lượng sản phẩm trong giỏ hàng");
            System.out.println("5. Xóa 1 sản phẩm trong giỏ hàng");
            System.out.println("6. Xóa toàn bộ sản phẩm trong giỏ hàng");
            System.out.println("7. Quay lại");
            byte choice;
            while (true) {
                try {
                    System.out.println("Nhập vào lựa chọn của bạn");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Bạn cần phải nhập vào là số, vui lòng nhập lại");
                }
            }
            switch (choice) {
                case 1:
                    CartService.displayAllProduct();
                    break;
                case 2:
                    CartService.addToCart(sc);
                    break;
                case 3:
                    CartService.displayAllCart();
                    break;
                case 4:
                    CartService.changeQtyProductInCart(sc);
                    break;
                case 5:
                    CartService.deleteACart(sc);
                    break;
                case 6:
                    CartService.deleteAllCart();
                    break;
                case 7:
                    return;
                default:
                    System.err.println("Bạn cần phải chọn các số từ 1 -> 7");
            }
        }
    }
}
