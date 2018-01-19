import java.io.IOException;
import java.util.Scanner;

public class mapSearch {
    User user ;
    restaurantPack restaurants;
    private int choose;
    public mapSearch(User user) throws IOException, InterruptedException {
        this.user = user;
        this.restaurants = restaurantcsv.main();
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
        String blacklist;
        boolean black = false;
        int pass=0;
        favoritePack myfavaorite = new favoritePack();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(user.getName()+"您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("請輸入搜尋範圍(單位：m）：");
        max_distance=scanner.nextDouble();
        String junk = scanner.nextLine();
        System.out.println("----------------------------------------------------------------------");

        do {
            System.out.println("是否要顯示黑名單(Y/N)：");
            blacklist = scanner.nextLine();
            if (blacklist.equals("Y")||blacklist.equals("y"))
            {
                black = true;
                pass=1;
            }
            else if(blacklist.equals("N")||blacklist.equals("n"))
            {
                black = false;
                pass=1;
            }
        }while(pass==0);
        System.out.println("----------------------------------------------------------------------");
        for (int i =0;i<restaurants.restaurantNumber();i++)
        {
            if(restaurants.getRestaurant(i).distance(user.getLocation())<=max_distance)
            {
                if (black==false)
                {
                    favorite thisres = myfavaorite.foundfavaoriteByResID(restaurants.getRestaurant(i).getId(),user.getUserID());
                    if (thisres!=null)
                    {
                        if (thisres.getType()!=2)
                        {
                            nearby.add(restaurants.getRestaurant(i));
                        }
                    }
                    else
                    {
                        nearby.add(restaurants.getRestaurant(i));
                    }
                }
                else
                {
                    nearby.add(restaurants.getRestaurant(i));
                }
            }
        }
        nearby.sortbydistance(user.getLocation());
        int start_page=0,end_page=0;
        int page=1;
        if (nearby.restaurantNumber()-1<start_page+4)
        {
            end_page=nearby.restaurantNumber()-1;
        }
        else
        {
            end_page=start_page+4;
        }
        if (end_page!=0) {
            while (true) {
                System.out.println("您目前在第"+page+"頁");
                System.out.println("----------------------------------------------------------------------");
                for (int i = start_page; i <= end_page; i++) {
                    restaurant temp = nearby.getRestaurant(i);
                    System.out.println((i+1) + "." + temp.getName());
                    System.out.println("  距離您 " + temp.distance(user.getLocation()) + "公尺");
                    System.out.println("  餐廳類型:" + temp.gettype());
                    if (temp.getOpen())
                    {
                        System.out.println("  餐廳營業中");
                    }
                    else
                    {
                        System.out.println("  餐廳休息中，營業時間為:"+temp.getRunningtime());
                    }
                    favorite thisres = myfavaorite.foundfavaoriteByResID(nearby.getRestaurant(i).getId(),user.getUserID());
                    if (thisres!=null)
                    {
                        if (thisres.getType()==1)
                        {
                            System.out.println("  此餐廳為你的最愛");
                        }
                        else if (thisres.getType()==2)
                        {
                            System.out.println("  此餐廳為你的黑名單");
                        }
                    }
                    System.out.println("----------------------------------------------------------------------");
                }
                System.out.println("命令提示：\"n\"：下一頁    \"p\"：上一頁   \"q\"：離開  其他數字選擇相應選項");
                System.out.println("----------------------------------------------------------------------");
                String MenuSelection = scanner.next();
                if (MenuSelection.equals("q") || MenuSelection.equals("Q")) {
                    break;
                } else if (MenuSelection.equals("n") || MenuSelection.equals("N")) {
                    if (end_page < nearby.restaurantNumber()-1) {
                        start_page += 5;
                        if (nearby.restaurantNumber() < start_page + 4) {
                            end_page = nearby.restaurantNumber()-1;
                        } else {
                            end_page = start_page + 4;
                        }
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        page++;
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(user.getName() + "您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
                        System.out.println("----------------------------------------------------------------------");


                    } else {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("已經是最後一頁了");
                        System.out.println("----------------------------------------------------------------------");
                    }
                }
                else if (MenuSelection.equals("p") || MenuSelection.equals("P")) {
                    if (start_page > 4) {
                        start_page -= 5;
                        end_page = start_page + 4;
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        page--;
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(user.getName() + "您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
                        System.out.println("----------------------------------------------------------------------");

                    } else {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("這是第一頁");
                        System.out.println("----------------------------------------------------------------------");
                    }
                }
                else if(isNumeric(MenuSelection))
                {
                    int chooseMenu = Integer.valueOf(MenuSelection);
                    showonecanteen(nearby.getRestaurant(chooseMenu-1),this.user,"當前位置附近餐廳>搜尋附近餐廳");
                }

            }
        }
        else
        {
            System.out.println("沒有相關資料");
            Thread.sleep(2000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }


    }
    public static void showonecanteen(restaurant restaurant,User user,String Path) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        favoritePack myfavaorite = new favoritePack();
        favorite thisres;
        while(true)
        {

            System.out.println("----------------------------------------------------------------------");
            System.out.println("您好，您目前位置在：主選單>"+Path+">"+restaurant.getName());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("餐廳名稱:"+restaurant.getName());
            System.out.println("餐廳位置:"+restaurant.getAddress());
            System.out.println("餐廳電話:0"+restaurant.getPhone());
            System.out.println("餐廳類型:"+restaurant.gettype());
            System.out.println("餐廳營業時間:"+restaurant.getRunningtime());
            thisres = myfavaorite.foundfavaoriteByResID(restaurant.getId(),user.getUserID());
            if(thisres!=null)
            {
                if(thisres.getType()==1)
                {
                    System.out.print("此餐廳為我的最愛");
                    System.out.print("\n");
                }
                else if (thisres.getType()==2)
                {
                    System.out.print("此餐廳為我的黑名單");
                    System.out.print("\n");
                }

            }
            System.out.println("----------------------------------------------------------------------");
            System.out.print("命令提示：\"c\"：顯示相關優惠券 \"p\"：顯示評論   \"q\"：離開");
            if(thisres!=null)
            {
                if(thisres.getType()==1)
                {
                    System.out.print("   \"d\":取消我的最愛");
                }
                else if (thisres.getType()==2)
                {
                    System.out.print("   \"d\":取消我的黑名單");
                }
                else
                {
                    System.out.print("   \"l\":新增我的最愛   \"dl\":新增為我的黑名單");
                }
            }
            else
            {
                System.out.print("   \"l\":新增我的最愛   \"dl\":新增為我的黑名單");
            }
            System.out.print("\n");
            System.out.println("----------------------------------------------------------------------");
            String choose = scanner.nextLine();
            if (choose.equals("q")||choose.equals("Q"))
            {
                break;
            }
            else if(choose.equals("p")||choose.equals("P"))
            {
                comMenu comment = new comMenu(restaurant.getId(),user);
            }
            else if (choose.equals("l")||choose.equals("L"))
            {
                if (thisres!=null)
                {
                    if (thisres.getType()==0)
                    {
                        myfavaorite.setfavorite(restaurant.getId(),user.getUserID(),1);
                    }
                    else
                    {
                        System.out.println("指令輸入錯誤，請重新輸入");
                        Thread.sleep(2000);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                }
                else
                {
                    myfavaorite.newfavorite(restaurant.getId(),user.getUserID(),1);
                }
            }
            else if(choose.equals("d")||choose.equals("D"))
            {
                if (thisres!=null)
                {
                    myfavaorite.setfavorite(restaurant.getId(),user.getUserID(),0);
                }
            }
            else if (choose.equals("dl")||choose.equals("DL"))
            {
                if (thisres!=null)
                {
                    if (thisres.getType()==0)
                    {
                        myfavaorite.setfavorite(restaurant.getId(),user.getUserID(),2);
                    }
                    else
                    {
                        System.out.println("指令輸入錯誤，請重新輸入");
                        Thread.sleep(2000);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                }
                else
                {
                    myfavaorite.newfavorite(restaurant.getId(),user.getUserID(),2);
                }
            }
            else
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

        }

    }
    public void showMenu() throws IOException, InterruptedException {

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
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


}
