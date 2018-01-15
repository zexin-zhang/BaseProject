import java.io.IOException;
import java.util.*;
public class Menu {
    UserPack users;
    restaurantPack restaurants;
    private int choose;
    public Menu(UserPack users,restaurantPack restaurants) throws IOException, InterruptedException {
        this.users = users;
        this.restaurants = restaurants;
        menuPrint();
    }
    public void chooseMenu() throws IOException, InterruptedException {
        switch(choose)
        {
            case 1:
                mapSearch();
                break;
            default:
                break;

        }
        if(choose!=6)
        {
            menuPrint();
        }
    }
    public void mapSearch() throws IOException, InterruptedException {
        mapSearch mapSearch_activity = new mapSearch(this.users,this.restaurants);
    }
    public void menuPrint() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner choose_scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("歡迎使用本軟體，請選擇您所需要的功能");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.當前位置搜尋附近餐廳");
        System.out.println("2.查看餐廳評論");
        System.out.println("3.分類檢索餐廳");
        System.out.println("4.利用地圖搜尋附近餐廳");
        System.out.println("5.使用、領用優惠券");
        System.out.println("6.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        this.choose=choose_scan.nextInt();
        String junk = choose_scan.nextLine();
        chooseMenu();
    }
}
