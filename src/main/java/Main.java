import java.io.IOException;
import java.util.*;
public class Main {
    public static void  main(String args[]) throws IOException, InterruptedException {
        restaurantPack restaurants = new restaurantcsv().main();
        Scanner scanner = new Scanner(System.in);
        String junk;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("呷崩V1.0       發佈日期：2018/1/19");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.一般使用者");
        System.out.println("2.餐廳管理員");
        System.out.println("3.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        int choose = scanner.nextInt();
        junk = scanner.nextLine();
        switch(choose)
        {
            case 1:
                Menu menu = new Menu();
                break;
            case 2:
                SaleMenu salemenu = new SaleMenu(restaurants);
                break;
        }

    }
}
