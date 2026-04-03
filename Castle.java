import java.util.Random;
import java.util.Scanner;

public class Castle {
    Scanner in = new Scanner(System.in);
    Random r = new Random();

    int mini_game() {
        System.out.println("Вы нашли замок! Для входа вам нужно пройти мини-игру!");
        System.out.println("Вам нужно будет отгадать число от 1 до 10 за 3 попытки.");
        int a = r.nextInt(1, 10);
        System.out.println("Число загадано.");
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите ответ: ");
            int ans = in.nextInt();
            if (ans == a) {
                System.out.printf("\nВы отгадали число с %d попытки!", i + 1);
                return 1;
            } else {
                if (ans > a) {
                    System.out.println("\nВы не отгадали( ваш ответ больше загаданного числа.");
                } else {
                    System.out.println("\nВы не отгадали( ваш ответ меньше загаданного числа.");
                }
                System.out.printf("Осталось попыток: %d\n", 3 - i - 1);
            }
        }
        return 0;
    }
}

