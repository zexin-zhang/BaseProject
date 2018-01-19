/*
    create by :古項臣
    date : 2018/1/16
*/
import java.io.IOException;
import java.util.*;

public class type
{
    private restaurantPack foodrestaurant,restaurants;
    private User username;
    public type(User user) throws IOException, InterruptedException
    {
        restaurants = restaurantcsv.main();//讀取csv資料
        this.username = user;//知道目前是誰在操作
        Scanner foodtype = new Scanner(System.in);//新增輸入
        System.out.println("----------------------------------------------------------------------");
        System.out.println(username.getName() + "您好，您目前位置在：主選單>分類檢索餐廳");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("餐廳類型選項提供:");//選單呈現
        System.out.println("(1)中西式早餐店");
        System.out.println("(2)便當店");
        System.out.println("(3)日式風味店");
        System.out.println("(4)義式餐廳店");
        System.out.println("(5)速食店");
        System.out.println("(6)清淡速食店");
        System.out.println("(7)甜食店");
        System.out.println("(8)飲料店");
        System.out.println("(9)港式餐應店");
        System.out.println("(10)泰式餐廳店");
        System.out.println("(11)越南小吃店");
        System.out.println("(12)客家餐廳店");
        System.out.println("(13)閩式餐廳店");
        System.out.println("(14)水餃鍋貼店");
        System.out.println("(15)牛排店");
        System.out.println("(16)台式小吃");
        System.out.println("(17)火鍋店");

        System.out.print("請輸入食物及餐廳種類:");//從這開始進行輸入
        String type = foodtype.nextLine();//輸入的東西傳入type中
        foodrestaurant = restaurants.getRestaurantoftype(type);
//        username = User.getName();
        //把type當參數傳入restaurants當中的getRestaurantoftype指向foodrestaurant
        int forward_page = 0,last_page = 0;//先宣告並初始化最上面的一頁(forward_page)和最下面的一頁(last_page)
        if (foodrestaurant.restaurantNumber() < forward_page + 4)//以下為做翻頁的部分跟mapsearch.java雷同，以及呈現一些相關資料
        {
            last_page = foodrestaurant.restaurantNumber();
        }
        else
        {
            last_page = forward_page + 4;
        }
        if ( last_page != 0)
        {
            while (true)
            {
                for (int i = forward_page ; i < last_page ; i++)
                {
                    restaurant temp = restaurants.getRestaurant(i);
                    System.out.println((i+1) + "." + temp.getName());
                    System.out.println("  距離您大約 " + temp.distance(username.getLocation()) + "公尺(m)");
                    System.out.println("  餐廳類型:" + temp.gettype());
                    System.out.println("  餐廳經緯度:" + temp.getLocation().toString());
                    if (temp.getOpen())//這個是判斷是否有營業的部分，如果為真就呈現"餐廳營業中的情況"，反之則呈現這個餐廳的營業時間
                    {
                        System.out.println(" 餐廳營業中");
                    }
                    else
                    {
                        System.out.println("  餐廳休息中，營業時間為:"+temp.getRunningtime());
                    }
                    System.out.println("----------------------------------------------------------------------");
                }
                System.out.println("命令提示：\"n\"：下一頁    \"p\"：上一頁   \"q\"：離開  其他數字選擇相應選項");
                System.out.println("----------------------------------------------------------------------");
                String MenuSelection = foodtype.next();//輸入接下來的動作代碼
                if (MenuSelection.equals("q") || MenuSelection.equals("Q"))//離開
                {
                    break;
                }
                else if (MenuSelection.equals("n") || MenuSelection.equals("N"))//下一頁
                {
                    if (last_page < foodrestaurant.restaurantNumber())
                    {
                        forward_page += 5;
                        if (foodrestaurant.restaurantNumber() < forward_page + 4)
                        {
                            last_page = foodrestaurant.restaurantNumber();
                        }
                        else
                        {
                            last_page = forward_page + 4;
                        }
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(username.getName() + "您好，您目前位置在：主選單>分類檢索餐廳");
                        System.out.println("----------------------------------------------------------------------");
                 }
                    else if (mapSearch.isNumeric(MenuSelection)) {
                        int chooseMenu = Integer.valueOf(MenuSelection);
                        mapSearch.showonecanteen(foodrestaurant.getRestaurant(chooseMenu - 1), this.username, "分類檢索餐廳");
                    }
                 else
                 {
                        System.out.println("沒有更多了!");
                        System.out.println("----------------------------------------------------------------------");
                 }
                }
            }
        }
        else
        {
            System.out.println("資料已經到底了喔!");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

    }
}
