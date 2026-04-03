import java.util.Random;
import java.util.Scanner;
public class Monster {
    public int ans, tans = 0, a, b, hit, difficult;
    Scanner in = new Scanner(System.in);
    Random r = new Random();
    
    public Monster(int a, int b, int hit, int difficult){
        this.a = a;
        this.b = b;
        this.hit = hit;
        this.difficult = difficult;
    }

    int task(){
        switch (difficult) {
            case 1:
                System.out.printf("Введите ответ для примера: %d + %d = ", a, b);
                ans = in.nextInt();
                tans = a + b;
                break;
            case 2:
                System.out.printf("Введите ответ для примера: %d - ", a);
                tans = a;
                for(int i = 0; i <= difficult; i++){
                    a = a * r.nextInt(1, difficult * 3);
                    b = b * r.nextInt(1, difficult * 3);
                    System.out.printf("%d + %d - ", a, b);
                    tans += -a + b;
                }
                System.out.println(23);
                ans = in.nextInt();
                tans -= 23;
                break;
            case 3:
                System.out.printf("Введите ответ для примера: %d - ", a);
                tans = a;
                for(int i = 0; i <= difficult; i++){
                    a = r.nextInt(1, a * difficult * 3);
                    b = r.nextInt(1, b * difficult * 3);
                    System.out.printf("%d + %d - ", a, b);
                    tans += -a + b;
                    a = 1;
                    b = 1;
                }
                System.out.println(123);
                ans = in.nextInt();
                tans -= 123;
                break;
            default:
                throw new AssertionError();
        }
        if (ans == tans){
            System.out.printf("Верно, ответ - %d\n", tans);
            return 0;
        }
        else {
            System.out.printf("Ответ %d неверный, верный ответ - %d\n", ans, tans);
            return hit;
        }
    }
}
