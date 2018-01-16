import java.io.IOException;
import java.util.Scanner;

public class mapSearch {
    UserPack users ;
    restaurantPack restaurants;
    private int choose;
    public mapSearch(UserPack users,restaurantPack restaurants) throws IOException, InterruptedException {
        this.users = users;
        this.restaurants = restaurants;
        showMenu();
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
        if(choose!=3)
        {
            showMenu();
        }
    }
    public void showcanteen() throws IOException, InterruptedException {
        restaurantPack nearby=new restaurantPack();
        double max_distance;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        User user = users.getUser(0);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(user.getName()+"您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
        System.out.println(users.getUser(0).getLocation().toString());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("請輸入搜尋範圍(單位：m）：");
        max_distance=scanner.nextDouble();
        String junk = scanner.nextLine();
        System.out.println("----------------------------------------------------------------------");

        for (int i =0;i<restaurants.restaurantNumber();i++)
        {
            if(restaurants.getRestaurant(i).distance(users.getUser(0).getLocation())<=max_distance)
            {
                nearby.add(restaurants.getRestaurant(i));
            }
        }
        restaurants.sortbydistance(user.getLocation());
        int start_page=0,end_page=0;
        if (nearby.restaurantNumber()<start_page+4)
        {
            end_page=nearby.restaurantNumber();
        }
        else
        {
            end_page=start_page+4;
        }
        if (end_page!=0) {
            while (true) {
                for (int i = start_page; i < end_page; i++) {
                    restaurant temp = restaurants.getRestaurant(i);
                    System.out.println(i + "." + temp.getName());
                    System.out.println("  距離您 " + temp.distance(user.getLocation()) + "公尺");
                    System.out.println("  餐廳類型:" + temp.gettype());
                    System.out.println("  餐廳經緯度:" + temp.getLocation().toString());
                    System.out.println("----------------------------------------------------------------------");
                }
                String MenuSelection = scanner.next();
                if (MenuSelection.equals("q") || MenuSelection.equals("Q")) {
                    break;
                } else if (MenuSelection.equals("n") || MenuSelection.equals("N")) {
                    if (end_page < nearby.restaurantNumber()) {
                        start_page += 5;
                        if (nearby.restaurantNumber() < start_page + 4) {
                            end_page = nearby.restaurantNumber();
                        } else {
                            end_page = start_page + 4;
                        }
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(user.getName() + "您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
                        System.out.println("----------------------------------------------------------------------");

                    } else {
                        System.out.println("沒有更多了");
                        System.out.println("----------------------------------------------------------------------");
                    }
                }

            }
        }
        else
        {
            System.out.println("沒有資料");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }


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
        chooseMenu();
    }

}
