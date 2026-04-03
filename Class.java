import java.util.Random;
import java.util.Scanner;

public class Class{
  public static void main(String[] args){
      int hp = 2;
      Random r = new Random();
      Scanner in = new Scanner(System.in);
      System.out.print("Введите сложность игры (от 1 до 3): ");
      int difficult = in.nextInt();
      System.out.println("Управление на wasd");
      
      String[][] area = {
        {"P", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"}
      };
      String[][] area_whith_all = {
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"}
      };
      int xp = 0, yp = 0;
      int a = r.nextInt(100), b = r.nextInt(100);
      int xm = r.nextInt(1,5), ym = r.nextInt(1, 5);
      int xbm = r.nextInt(1,5), ybm = r.nextInt(1, 5);
      int xc = r.nextInt(1,5), yc = r.nextInt(1, 5);
      while((xc == xm && yc == ym) || (xc == xbm && yc == ybm) || (xm == xbm && ym == ybm)){
        xc = r.nextInt(1, 5);
        yc = r.nextInt(1, 5);

        xbm = r.nextInt(1,5);
        ybm = r.nextInt(1, 5);
      }
      area_whith_all[xm][ym] = "M"; area[xm][ym] = "?";
      area_whith_all[xbm][ybm] = "BM"; area[xbm][ybm] = "?";
      area_whith_all[xc][yc] = "C"; area[xc][yc] = "?";

      Monster monster = new Monster(a, b, 1, difficult);
      a = r.nextInt(200); 
      b = r.nextInt(200);
      Monster big_monster = new Monster(a, b, 2, difficult);
      Castle castle = new Castle();

      boolean start = true;
      while(start){
        String step;
        step = in.nextLine();
        switch (step) {
            case "d":
              area[xp][yp] = "O";
              area[xp][yp + 1] = "P";
              yp++;
              break;
            case "a":
              area[xp][yp] = "O";
              area[xp][yp - 1] = "P";
              yp--;
              break;
            case "s":
              area[xp][yp] = "O";
              area[xp + 1][yp] = "P";
              xp++;
              break;
            case "w":
              area[xp][yp] = "O";
              area[xp - 1][yp] = "P";
              xp--;
              break;
            default:
              break;
        }

        for(int i = 0; i < 5; i++){
          System.out.println("+ - + - + - + - + - +");
          for(int i2 = 0; i2 < 5; i2++){
            System.out.print("| " + area[i][i2] + " ");
          }
          System.out.println("|");
        }
        System.out.println("+ - + - + - + - + - +");

        if(area_whith_all[xp][yp] == "M"){
          hp -= monster.task();
          if(hp > 0){
            area_whith_all[xp][yp] = "O";
            System.out.printf("Текущее здоровье: %d\n", hp);
          }
          else{
            start = false;
            System.out.println("Вы проиграли.");
          }
        }
        else if(area_whith_all[xp][yp] == "BM"){
          hp -= big_monster.task();
          if(hp > 0){
            area_whith_all[xp][yp] = "O";
            System.out.printf("Текущее здоровье: %d\n", hp);
          }
          else{
            start = false;
            System.out.println("Вы проиграли, не ответив на вопрос большого монстра.");
          }
        }
        else if(area_whith_all[xp][yp] == "C"){
          if(castle.mini_game() == 0){
            System.out.println("Вы проиграли.");
          }
          else{
            System.out.println("Вы прошли игру!!!");
          }
          start = false;
        }
      }
    }
}
