import java.util.Map;
import java.util.Scanner;

public class NewOrder {
    public static void fillingNewOrder(Map<Address, Integer> costPerAddress) {
        Scanner scanner = new Scanner(System.in);

        String country;
        String city;
        String weight;
        int[] priceAndUnicCount;
        int priceAll = 0;

        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }

            System.out.print("Введите город: ");
            city = scanner.nextLine();
            if ("end".equals(city)) {
                break;
            }

            System.out.print("Введите вес (кг): ");
            weight = scanner.nextLine();
            if ("end".equals(weight)) {
                break;
            }

            priceAndUnicCount = Main.compareAddress(country, city, weight, costPerAddress);
            priceAll += priceAndUnicCount[0];

            if (priceAndUnicCount[0] != 0) {
                System.out.println("Стоимость доставки составит: " + priceAndUnicCount[0] + " руб.");
                System.out.println("Общая стоимость всех доставок: " + priceAll + " руб.");
                System.out.println("Количество уникальных стран: " + priceAndUnicCount[1] + " шт");
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
    }
}
