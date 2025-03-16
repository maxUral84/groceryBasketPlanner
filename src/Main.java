import java.util.Scanner;

public class Main3 {
    public static final int EXPECTED_PARTS_LENGTH = 2;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] quantityOfGoods = new int[products.length];

        System.out.println("Программа, планирующая продуктовую корзину\n");

        System.out.println("Продуктовая корзина:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            System.out.println("\nВведите номер продукта и количество");
            String input = console.nextLine().toLowerCase().trim(); // 1 10

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length != EXPECTED_PARTS_LENGTH) {
                System.out.println("Ошибка ввода! Введите два числа через пробел.");
                continue;
            }

            try {
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);

                if (productNumber < 0 || productNumber >= products.length) {
                    System.out.println("Ошибка! Некорректный номер продукта.");
                    continue;
                }

                if (productCount <= 0) {
                    System.out.println("Ошибка! Количество должно быть больше нуля.");
                    continue;
                }

                quantityOfGoods[productNumber] += productCount;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите корректные числа.");
            }
        }

        System.out.println("\nВаша корзина:");

        int sumProducts = 0;

        for (int i = 0; i < products.length; i++) {
            if (quantityOfGoods[i] > 0) {
                int totalPrice = quantityOfGoods[i] * prices[i];
                sumProducts += totalPrice;

                System.out.println(products[i] + " " + quantityOfGoods[i] + " шт. " +
                        prices[i] + " руб./шт. Итог: " + totalPrice + " руб.");
            }
        }

        System.out.println("\nИтого " + sumProducts + " руб");

        System.out.println("\nСпасибо за покупки!");
    }
}
