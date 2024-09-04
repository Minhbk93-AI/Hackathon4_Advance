package exam_Advance_1_ra.business.implement;

import exam_Advance_1_ra.business.design.IGenericService;
import exam_Advance_1_ra.business.entity.Product;
import exam_Advance_1_ra.business.entity.CartItem;

import java.util.ArrayList;
import java.util.Scanner;

public class CartService {
    public static ArrayList<CartItem> cartItems = new ArrayList<>();
    private static IGenericService<Product, String> products = new ProductService();

    //Dispay all Product
    public static void displayAllProduct() {
        int count = 0;
        for (Product product : products.getAll()) {
            System.out.println(product);
            count++;
        }
        System.out.println("Shop có " + count + " products");
    }

    //Add to cart
    public static void addToCart(Scanner sc) {
        System.out.println("Nhập vào product id bạn muôn thêm vào Cart của bạn");
        String productId = sc.nextLine();
        boolean checkProductCart = false;
        for(Product product: products.getAll()){
            if(product.getProductId().equals(productId)){
                checkProductCart = true;
                boolean check = false;
                for (CartItem carts : CartService.cartItems){
                    if(carts.getProduct().getProductId().equals(productId)){
                        int qtyProduct;
                        while (true){
                            System.out.println("Sản phẩm đã có trong giỏ hàng của bạn, vui lòng nhập số lượng bạn muốn thêm");
                            qtyProduct = Integer.parseInt(sc.nextLine());
                            if( qtyProduct > product.getStock()){
                                System.err.println("Hết hàng, vui lòng thử lại");
                            }else{
                                break;
                            }
                        }
                        carts.setQuantity(carts.getQuantity() + qtyProduct);
                        product.setStock(product.getStock() - qtyProduct);
                        System.out.println("Thêm vào giỏ hàng thành công");
                        check = true;
                        break;
                    }
                }
                if(!check){
                    CartItem newCart = new CartItem();
                    newCart.inputData(sc,productId);
                    CartService.cartItems.add(newCart);
                    product.setStock(product.getStock() - newCart.getQuantity());
                    System.out.println("Thêm vào giỏ hàng thành công");
                    break;
                }
            }
        }
        if(!checkProductCart){
            System.err.println("Không thể tìm productId: "+productId);
        }
    }

    //display all cart
    public static void displayAllCart() {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List đang trống");
            return;
        }
        int count = 0;
        for(CartItem cartItem: cartItems){
            cartItem.displayData();
            count++;
        }
        System.out.println("Cart có " + count + " products");
    }


    //Change Quantity Product in cart
    public static void changeQtyProductInCart(Scanner sc) {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List đang trống");
            return;
        }
        int cartId;
        while (true){
            try{
                System.out.println("Nhập vào cart id");
                cartId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("Bạn cần phải nhập vào số, vui lòng nhập lại ");
            }
        }
        int qtyCart;
        while (true){
            try {
                System.out.println("Nhập vào quantity bạn muôốn thêm ");
                qtyCart = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("Bạn cần phải nhập vào số, vui lòng nhập lại ");
            }
        }
        boolean check = false;
        for(CartItem carts: cartItems){
            if(carts.getCartItemId() == cartId){
                carts.setQuantity(qtyCart);
                System.out.println("Cập nhật quantity hoàn thành");
                check = true;
                break;
            }
        }
        if(!check){
            System.err.println("Not found Cart with id: "+cartId);
        }
    }

    //Delete One Product In Cart
    public static void deleteACart(Scanner sc) {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List đang trống");
            return;
        }
        int cartId;
        while (true){
            try{
                System.out.println("Nhập vào cart id bạn muốn xóa");
                cartId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("Bạn phải nhập vào số, vui lòng nhập lại");
            }
        }
        boolean check = false;
        for(CartItem carts: cartItems){
            if(carts.getCartItemId() == cartId){
                cartItems.remove(carts);
                System.out.println("Xóa quantity hoàn thành");
                check = true;
                break;
            }
        }
        if(!check){
            System.err.println("Không tìm thấy Cart với id: "+cartId);
        }
    }

    //Delete All Product In Cart
    public static void deleteAllCart() {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List đang trống");
            return;
        }
        cartItems = null;
        System.err.println("Xóa hoàn thành");
    }
}
