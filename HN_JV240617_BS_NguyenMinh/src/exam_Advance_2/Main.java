package exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số ISBN (10 chữ số)");
        String numberIsbn = scanner.nextLine();

    
        if (numberIsbn.length() != 10) {
            System.out.println("Số ISBN phải có chính xác 10 chữ số");
            return;
        }
        int sum = 0;
        Stack<Integer> digits = new Stack<>();
        try {
            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(numberIsbn.charAt(i));
                digits.push(digit);
            }
            int multiplier = 1;

            while (!digits.isEmpty()) {
                sum += multiplier * digits.pop();
                multiplier++;
            }

            if (sum % 11 == 0) {
                System.out.println("Số ISBN  hợp lệ");
            } else {
                System.out.println("Số ISBN không hợp lệ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Chuỗi đầu vào không phải là một số");
        }
    }
}
