import java.util.*;

public class Main {
    static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        Address addresOne = new Address("Russia", "Moscow");
        Address addresTwo = new Address("USA", "New York");
        Address addresThree = new Address("Cyprus", "Larnaca");
        Address addresFour = new Address("Russia", "Anapa");

        costPerAddress.put(addresOne, 100);
        costPerAddress.put(addresTwo, 700);
        costPerAddress.put(addresThree, 400);
        costPerAddress.put(addresFour, 200);

        NewOrder.fillingNewOrder(costPerAddress);
    }

    public static int[] compareAddress(String country, String city, String weight, Map<Address, Integer> costPerAddress) {
        int[] priceAndUnicCount = new int[2];
        Set<String> uniqueCountries = new HashSet<>();

        Address checkAddress = new Address(country, city);

        if (costPerAddress.containsKey(checkAddress)) {
            try {
                priceAndUnicCount[0] = Integer.parseInt(weight) * costPerAddress.get(checkAddress);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный вес!");
            }
        }

        if (priceAndUnicCount[1] == 0) {
            for (Map.Entry<Address, Integer> kv : costPerAddress.entrySet()) {
                uniqueCountries.add(kv.getKey().country);
            }
        }

        priceAndUnicCount[1] = uniqueCountries.size();
        return priceAndUnicCount;
    }
}