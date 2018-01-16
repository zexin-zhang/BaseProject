
import java.io.IOException;
import java.util.*;

public class type
{
    private restaurantPack foodrestaurant;
    private User username;
    public void main(restaurantPack restaurants,UserPack users) throws IOException, InterruptedException {
        Scanner foodtype = new Scanner(System.in);//新增輸入
        System.out.println("餐廳選項提供:");//選單呈現
        System.out.println("(1)中西式早餐店");
        System.out.println("(2)古早味便當店");
        System.out.println("(3)日式風味店");
        System.out.println("(4)義式餐廳");
        System.out.println("(5)速食店");
        System.out.println("(6)清淡速食店");
        System.out.println("(7)甜食店");
        System.out.println("(8)飲料店");
        System.out.println("(9)港式餐應");
        System.out.println("(10)泰式餐廳");
        System.out.println("(11)越南小吃");
        System.out.println("(12)客家餐廳");
        System.out.println("(13)閩式餐廳");
        System.out.print("請輸入食物及餐廳種類:");//從這開始進行輸入
        String type = foodtype.nextLine();//輸入的東西傳入type中
        foodrestaurant = restaurants.getRestaurantoftype(type);
//        username = User.getName();
        //把type當參數傳入restaurants當中的getRestaurantoftype指向foodrestaurant
        int forward_page = 0,last_page = 0;//先宣告並初始化最上面的一頁(forward_page)和最下面的一頁(last_page)
        if (foodrestaurant.restaurantNumber() < forward_page + 4)
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
                    System.out.println(i + "." + temp.getName());
                    System.out.println("  距離您 " + temp.distance(username.getLocation()) + "公尺");
                    System.out.println("  餐廳類型:" + temp.gettype());
                    System.out.println("  餐廳經緯度:" + temp.getLocation().toString());
                    System.out.println("----------------------------------------------------------------------");
                }
                String MenuSelection = foodtype.next();
                if (MenuSelection.equals("q") || MenuSelection.equals("Q"))
                {
                    break;
                }
                else if (MenuSelection.equals("n") || MenuSelection.equals("N"))
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
                        System.out.println(username.getName() + "您好，您目前位置在：主選單>當前位置附近餐廳>搜尋附近餐廳");
                        System.out.println("----------------------------------------------------------------------");
                 }
                 else
                 {
                        System.out.println("沒有更多了");
                        System.out.println("----------------------------------------------------------------------");
                 }
                }
            }
        }
        else
        {
            System.out.println("沒有資料");
//            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }

}
