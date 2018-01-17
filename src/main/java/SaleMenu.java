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
    public void restaurantLogin() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("請進行登錄");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("使用者賬戶:");
        String username=scan.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.print("使用者密碼:");
        String password=scan.nextLine();
        restaurant choose = restaurants.login(username,password);
        if (choose!=null)
        {
            Salemenu(choose);
        }
        else
        {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("您的賬號或密碼錯誤，請重新輸入");
            Thread.sleep(2000);
        }
    }
    public void Salemenu(restaurant restaurant) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            String menuchoose;
            System.out.println("----------------------------------------------------------------------");
            System.out.println("歡迎"+restaurant.getName()+"使用本軟體，請選擇您所需要的功能");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("1.修改餐廳資料");
            System.out.println("2.查看餐廳評論");
            System.out.println("3.優惠券管理");
            System.out.println("4.離開");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("你的選擇：");
            menuchoose=scan.nextLine();
            if (mapSearch.isNumeric(menuchoose))
            {
                int choice = Integer.valueOf(menuchoose);
                switch(choice)
                {
                    case 1:
                        modify(restaurant);
                        break;
                }
            }
        }
    }
    public void modify(restaurant restaurant) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(restaurant.getName()+"您好，您目前位置在：主選單>修改餐廳資料，請選擇您所需要修改的項目");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.店家名稱");
        System.out.println("2.店家地址");
        System.out.println("3.店家營業時間");
        System.out.println("4.店家電話");
        System.out.println("5.店家密碼");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
        String menuchoose=scan.nextLine();
        if (mapSearch.isNumeric(menuchoose))
        {
            int choice = Integer.valueOf(menuchoose);
            switch(choice)
            {
                case 1:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("您的舊名稱為："+restaurant.getName());
                    System.out.print("新名稱：");
                    String name=scan.nextLine();
                    restaurants.getRestaurant(restaurant.getId()).setName(name);
                    System.out.println("----------------------------------------------------------------------");
                    System.out.print("變更完成");
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("您的舊地址為："+restaurant.getAddress());
                    System.out.print("新地址：");
                    String address=scan.nextLine();
                    restaurants.getRestaurant(restaurant.getId()).setAddress(address);
                    System.out.println("----------------------------------------------------------------------");
                    System.out.print("變更完成");
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("您的舊營業時間為："+restaurant.getRunningtime());
                    System.out.print("新營業時間(格式請打 ex:10:30-19:00，若是小於早上十點，請打 ex:09）：");
                    String running=scan.nextLine();
                    int open_hours,open_minutes,close_hours,close_minutes;
                    if(mapSearch.isNumeric(running.substring(0,1)))
                    {
                        if (Integer.valueOf(running.substring(0,1))<24&&Integer.valueOf(running.substring(0,1))>=0)
                        {
                            open_hours=Integer.valueOf(running.substring(0,1));
                        }
                        else
                        {
                            break;
                        }

                    }
                    else
                    {
                        break;
                    }
                    if(mapSearch.isNumeric(running.substring(3,4)))
                    {
                        if (Integer.valueOf(running.substring(3,4))<60&&Integer.valueOf(running.substring(3,4))>=0)
                        {
                            open_minutes=Integer.valueOf(running.substring(3,4));
                        }
                        else
                        {
                            break;
                        }

                    }
                    else
                    {
                        break;
                    }
                    if(mapSearch.isNumeric(running.substring(6,7)))
                    {
                        if (Integer.valueOf(running.substring(6,7))<24&&Integer.valueOf(running.substring(6,7))>=0)
                        {
                            close_hours=Integer.valueOf(running.substring(6,7));
                        }
                        else
                        {
                            break;
                        }

                    }
                    else
                    {
                        break;
                    }
                    if(mapSearch.isNumeric(running.substring(9,10)))
                    {
                        if (Integer.valueOf(running.substring(9,10))<60&&Integer.valueOf(running.substring(9,10))>=0)
                        {
                            close_minutes=Integer.valueOf(running.substring(9,10));
                        }
                        else
                        {
                            break;
                        }

                    }
                    else
                    {
                        break;
                    }
                    restaurants.getRestaurant(restaurant.getId()).setRunningtime(open_hours,open_minutes,close_hours,close_minutes);
                    System.out.println("----------------------------------------------------------------------");
                    System.out.print("變更完成");
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("您的舊電話為："+restaurant.getPhone());
                    System.out.print("新電話：");
                    String phone=scan.nextLine();
                    restaurants.getRestaurant(restaurant.getId()).setPhone(phone);
                    System.out.println("----------------------------------------------------------------------");
                    System.out.print("變更完成");
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
            }
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
