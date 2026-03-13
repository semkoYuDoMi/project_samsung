import java.util.Scanner;
public class Monster {
    public int ans, tans, a, b, hit;
    Scanner in = new Scanner(System.in);
    
    public Monster(int a, int b, int hit){
        this.a = a;
        this.b = b;
        this.hit = hit;
    }

    int task(){
        System.out.printf("Реши пример: %d + %d = ?:\n", a, b);
        ans = in.nextInt();
        tans = a + b;
        if (ans == tans){
            System.out.printf("Верно, ответ - %d\n", ans);
            return 0;
        }
        else {
            System.out.printf("Ответ %d неверный, верный ответ - %d\n", ans, tans);
            return hit;
        }
    }
}
