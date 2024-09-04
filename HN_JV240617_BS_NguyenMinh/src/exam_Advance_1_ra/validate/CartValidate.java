package exam_Advance_1_ra.validate;

import exam_Advance_1_ra.business.design.IGenericService;
import exam_Advance_1_ra.business.entity.Product;
import exam_Advance_1_ra.business.implement.ProductService;
import exam_Advance_1_ra.business.entity.CartItem;
import exam_Advance_1_ra.business.implement.CartService;

import java.util.Scanner;

public class CartValidate {
    private static IGenericService<Product,String> products = new ProductService();
    public static int inputCartId(){
        if(!CartService.cartItems.isEmpty()){
            int max = CartService.cartItems.get(0).getCartItemId();
            for(CartItem cart : CartService.cartItems){
                if(cart.getCartItemId() > max){
                    max = cart.getCartItemId();
                }
            }
            return max +1;
        }
        return 1;
    }

    public static Product inputProduct(String productId) {
        for (Product pr: products.getAll()){
            if (pr.getProductId().equals(productId)) {
                return pr;
            }
        }
        return null;
    }

    public static int inputCategoryQuantiry(Scanner sc, Product product) {
        int qtyProduct;
        while (true){
            while (true){
                try{
                    System.out.println("Nhập vào quantity products");
                    qtyProduct = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.err.println("Bạn phải nhập vào là số, vui lòng nhập lại");
                }
            }
            if(product.getStock() < qtyProduct){
                System.err.println("Số lượng mua không được lớn hơn số lương có trong kho");
            }else {
                return qtyProduct;
            }
        }
    }
}
