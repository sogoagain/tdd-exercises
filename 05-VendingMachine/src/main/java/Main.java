import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 자판기 셋팅 ===");
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println(" * 음료이름에 q를 입력하면 셋팅이 완료됩니다.");

        while (true) {
            System.out.print(" - 음료이름: ");
            String beverageName = scanner.next();
            if (beverageName.equals("q")) {
                break;
            }

            System.out.print(" - 음료가격: ");
            int beveragePrice = scanner.nextInt();

            System.out.print(" - 음료갯수: ");
            int beverageAmount = scanner.nextInt();

            vendingMachine.addBeverages(beverageName, beveragePrice, beverageAmount);
        }

        System.out.println("=== 사용자 셋팅 ===");
        System.out.print(" - 초기 자본금: ");
        int initMoney = scanner.nextInt();

        Customer customer = new Customer(initMoney);

        System.out.println("=== 시뮬레이션 시작 ===");

        while (true) {
            System.out.print("뽑을 음료: ");
            String beverageName = scanner.next();

            Beverage beverage = vendingMachine.pullBeverage(beverageName);
            boolean isBuy = customer.buy(beverage);
            if (!isBuy) {
                System.out.println("음료 구매 실패");
                break;
            }

            System.out.println(beverageName + "구매!");
        }
    }
}
