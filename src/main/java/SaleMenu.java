import java.io.IOException;
import java.util.Scanner;

public class SaleMenu {
    UserPack users;
    restaurantPack restaurants;
    private int choose;
    public SaleMenu(UserPack users,restaurantPack restaurants) throws IOException, InterruptedException {
        this.users = users;
        this.restaurants = restaurants;
        menuPrint();
    }
    public void chooseMenu() throws IOException, InterruptedException {
        switch(choose)
        {
            case 1:

                break;
            default:
                break;

        }
        if(choose!=6)
        {
            menuPrint();
        }
    }

    public void menuPrint() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner choose_scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("歡迎餐廳管理員使用本軟體，請選擇您所需要的功能");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.登錄");
        System.out.println("2.註冊");
        System.out.println("3.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        this.choose=choose_scan.nextInt();
        String junk = choose_scan.nextLine();
    }
}
