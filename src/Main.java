import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] quantityOfGoods = new int[products.length];
        int productNumber;
        int productCount;
        int sumProducts = 0;

        System.out.println("Программа, планирующая продуктовую корзину\n");

        System.out.println("Продуктовая корзина:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            System.out.println("\nВведите номер продукта и количество продуктов");
            String input = console.nextLine().toLowerCase().trim(); // 1 10

            if("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" "); // "1" "10"

            if (parts.length != 2) {
                System.out.println("Ошибка ввода! Введите два числа через пробел.");
                continue;
            }

            try {
                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);

                quantityOfGoods[productNumber] = productCount;

                System.out.println("\nВаша корзина:");

                for (int i = 0; i < products.length; i++) {
                    if (quantityOfGoods[i] > 0) {
                        int totalPrice = quantityOfGoods[i] * prices[i];
                        sumProducts += totalPrice;

                        System.out.println(products[i] + " " + quantityOfGoods[i] + " шт. " + prices[i] + " руб./шт.");
                        System.out.println("Итог: " + totalPrice + " руб.");
                    }
                }

                System.out.println("\nОбщая сумма: " + sumProducts + " руб.\n");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите корректные числа.");
            }
        }
    }
}

