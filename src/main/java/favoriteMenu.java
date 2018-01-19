import java.io.IOException;
import java.util.Scanner;

public class favoriteMenu {
    restaurantPack restaurants;
    favoritePack favor;
    User user;
    int choose;
    String path  = "個人喜好設定";
    public favoriteMenu(User user) throws IOException, InterruptedException {
        restaurants = restaurantcsv.main();
        favor = new favoritePack();
        this.user = user;
        Menu();
    }

    public void Menu() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(user.getName() + "您好，您目前位置在：主選單>"+path);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.查看我的最愛");
        System.out.println("2.查看我的黑名單");
        System.out.println("3.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        this.choose = scanner.nextInt();
        String junk = scanner.nextLine();
        chooseMenu();
    }

    private void chooseMenu() throws IOException, InterruptedException {
        switch (choose) {
            case 1:
                list(1);
                break;
            case 2:
                list(2);
                break;
        }
        if (choose != 3) {
            Menu();
        }
    }

    private void list(int type) throws IOException, InterruptedException {
        restaurantPack love = new restaurantPack();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        for (int i = 0; i < restaurants.restaurantNumber(); i++) {

            favorite thisres = favor.foundfavaoriteByResID(restaurants.getRestaurant(i).getId(), user.getUserID());
            if (thisres != null) {
                if (thisres.getType() == type) {
                    love.add(restaurants.getRestaurant(i));
                    System.out.println("+1");
                }
            }
        }
        showlist(love,type);
    }

    public void showlist(restaurantPack nearby, int type) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int start_page = 0, end_page = 0;
        int page = 1;
        String subPath ;
        System.out.println(nearby.restaurantNumber());
        if (nearby.restaurantNumber() < start_page + 4) {
            end_page = nearby.restaurantNumber();
        } else {
            end_page = start_page + 4;
        }
        if (end_page != 0) {
            while (true) {
                System.out.println("----------------------------------------------------------------------");
                if (type == 1)
                {
                    subPath="我的最愛";
                    System.out.print("我的最愛\n");
                }
                else
                {
                    subPath="黑名單";
                    System.out.print("黑名單\n");
                }

                System.out.println(user.getName() + "您好，您目前位置在：主選單>"+path+">"+subPath);
                System.out.println("----------------------------------------------------------------------");
                System.out.println("您目前在第" + page + "頁");
                System.out.println("----------------------------------------------------------------------");
                for (int i = start_page; i <= end_page; i++) {
                    restaurant temp = nearby.getRestaurant(i);
                    System.out.println((i + 1) + "." + temp.getName());
                    System.out.println("  距離您 " + temp.distance(user.getLocation()) + "公尺");
                    System.out.println("  餐廳類型:" + temp.gettype());
                    if (temp.getOpen()) {
                        System.out.println("  餐廳營業中");
                    } else {
                        System.out.println("  餐廳休息中，營業時間為:" + temp.getRunningtime());
                    }
                    favorite thisres = favor.foundfavaoriteByResID(nearby.getRestaurant(i).getId(), user.getUserID());
                    System.out.println("----------------------------------------------------------------------");
                }
                System.out.println("命令提示：\"n\"：下一頁    \"p\"：上一頁   \"q\"：離開  其他數字選擇相應選項");
                System.out.println("----------------------------------------------------------------------");
                String MenuSelection = scanner.next();
                if (MenuSelection.equals("q") || MenuSelection.equals("Q")) {
                    break;
                } else if (MenuSelection.equals("n") || MenuSelection.equals("N")) {
                    if (end_page < nearby.restaurantNumber() - 1) {
                        start_page += 5;
                        if (nearby.restaurantNumber() < start_page + 4) {
                            end_page = nearby.restaurantNumber() - 1;
                        } else {
                            end_page = start_page + 4;
                        }
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        page++;
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(user.getName() + "您好，您目前位置在：主選單>"+path+">"+subPath);
                        System.out.println("----------------------------------------------------------------------");


                    } else {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("已經是最後一頁了");
                        System.out.println("----------------------------------------------------------------------");
                    }
                } else if (MenuSelection.equals("p") || MenuSelection.equals("P")) {
                    if (start_page > 4) {
                        start_page -= 5;
                        end_page = start_page + 4;
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        page--;
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(user.getName() + "您好，您目前位置在：主選單>"+path+">"+subPath);
                        System.out.println("----------------------------------------------------------------------");

                    } else {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("這是第一頁");
                        System.out.println("----------------------------------------------------------------------");
                    }
                } else if (mapSearch.isNumeric(MenuSelection)) {
                    int chooseMenu = Integer.valueOf(MenuSelection);
                    mapSearch.showonecanteen(nearby.getRestaurant(chooseMenu - 1), this.user,path+">"+subPath);
                }

            }
        } else {
            System.out.println("沒有相關資料");
            Thread.sleep(2000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
