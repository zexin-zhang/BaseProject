import java.io.IOException;
import java.util.Scanner;

public class mapSearch {
    UserPack users ;
    restaurantPack restaurants;
    private int choose;
    public mapSearch(UserPack users,restaurantPack restaurants)
    {
        this.users = users;
        this.restaurants = restaurants;
    }
    public void chooseMenu() throws IOException, InterruptedException {
        switch(choose)
        {
            case 1:
                showcanteen();
                break;
            default:
                break;

        }
        if(choose!=6)
        {
            showMenu();
        }
    }
    public void showcanteen()
    {
        restaurantPack nearby=new restaurantPack();
        double max_distance;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        User user = users.getUser(0);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(user.getName()+"您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("請輸入搜尋範圍(單位：m）：");
        max_distance=scanner.nextDouble();
        String junk = scanner.nextLine();
        System.out.println("----------------------------------------------------------------------");
        for (int i =0;i<restaurants.restaurantNumber();i++)
        {
            if(restaurants.getRestaurant(i).distance(users.getUser(0).getMyLocation())<=max_distance)
            {
                nearby.add(restaurants.getRestaurant(i));
            }
        }
        for (int i = 0;i<nearby.)
    }
    public void showMenu() throws IOException, InterruptedException {
        User user = users.getUser(0);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner choose_scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(user.getName()+"您好，您目前位置在：主選單>當前位置附近餐廳，請選擇所需要功能");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.搜尋附近餐廳");
        System.out.println("2.餐廳大轉盤");
        System.out.println("3.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        this.choose=choose_scan.nextInt();
        String junk = choose_scan.nextLine();
    }

}
