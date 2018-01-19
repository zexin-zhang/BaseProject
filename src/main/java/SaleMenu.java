import java.io.IOException;
import java.util.Scanner;

public class SaleMenu {
    UserPack users;
    restaurantPack restaurants;
    private int choose;
    public SaleMenu(restaurantPack restaurants) throws IOException, InterruptedException {

        this.restaurants = restaurants;
        menuPrint();
    }
    public void chooseMenu() throws IOException, InterruptedException {
        switch(choose)
        {
            case 1:
                restaurantLogin();
                break;
            case 2:
                register();
                break;
            default:
                break;

        }
        if(choose!=3)
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
            System.out.println(choose.getName()+"歡迎回來");
            Thread.sleep(2000);
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

        Scanner scan = new Scanner(System.in);
        while(true)
        {
            String menuchoose;
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
                    case 2:
                        while (true)
                        {
                            Scanner scanner = new Scanner(System.in);
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(restaurant.getName()+"您好，您目前位置在：主選單>查看評論");

                            comMenu comMenu = new comMenu(restaurant.getId());
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("命令提示：\"q\"：離開");
                            System.out.println("----------------------------------------------------------------------");
                            String choose = scanner.nextLine();
                            if (choose.equals("q") || choose.equals("Q")) {
                                break;
                            }
                            else {

                            }
                        }

                        break;
                }
                if (choice==4)
                {
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
                    restaurants.getRestaurant(restaurant.getName()).setAddress(address);
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
                    if(mapSearch.isNumeric(running.substring(0,2)))
                    {
                        System.out.println(running.substring(0,2));
                        if (Integer.valueOf(running.substring(0,2))<24&&Integer.valueOf(running.substring(0,2))>=0)
                        {
                            open_hours=Integer.valueOf(running.substring(0,2));
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
                    if(mapSearch.isNumeric(running.substring(3,5)))
                    {
                        System.out.println(running.substring(3,5));
                        if (Integer.valueOf(running.substring(3,5))<60&&Integer.valueOf(running.substring(3,5))>=0)
                        {
                            open_minutes=Integer.valueOf(running.substring(3,5));
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
                    if(mapSearch.isNumeric(running.substring(6,8)))
                    {
                        if (Integer.valueOf(running.substring(6,8))<24&&Integer.valueOf(running.substring(6,8))>=0)
                        {
                            close_hours=Integer.valueOf(running.substring(6,8));
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
                    if(mapSearch.isNumeric(running.substring(9,11)))
                    {
                        if (Integer.valueOf(running.substring(9,11))<60&&Integer.valueOf(running.substring(9,11))>=0)
                        {
                            close_minutes=Integer.valueOf(running.substring(9,11));
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
                case 5:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.print("請輸入舊密碼：");
                    String oldPassword=scan.nextLine();
                    if (!restaurant.checkPassword(restaurant,oldPassword))
                    {
                        System.out.println("您輸入的密碼不正確請重新再試");
                        Thread.sleep(2000);
                        break;
                    }
                    System.out.print("請輸入新密碼：");
                    String newPassword=scan.nextLine();
                    System.out.print("請再次輸入：");
                    String confirmPassword=scan.nextLine();
                    if (!confirmPassword.equals(newPassword))
                    {
                        System.out.println("兩次密碼不正確請重新再試");
                        Thread.sleep(2000);
                        break;
                    }
                    System.out.println("----------------------------------------------------------------------");
                    restaurants.getRestaurant(restaurant.getName()).setPassword(newPassword);
                    System.out.println("變更完成");
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
            }
        restaurantcsv.write(restaurants);
        }
    }
    public void register()
    {
        Scanner scan = new Scanner(System.in);
        String name,username,password,address,type;
        double longtitude,latitude;
        int open_hours,open_minutes,close_hours,close_minutes;
        int invalid=0;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("註冊頁面");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("請輸入你的餐廳名稱：");
        name = scan.nextLine();
        System.out.println("請輸入你的使用者名稱：");
        System.out.println("請輸入你的使用者密碼：");
        System.out.println("請再次輸入你的密碼：");
        System.out.println("請輸入您的餐廳地址：");
        System.out.println("請輸入您的餐廳緯度：");
        System.out.println("請輸入您的餐廳經度：");
        System.out.println("請輸入您的餐廳電話（不含0，ex:432111111）：");
        System.out.print("新營業時間(格式請打 ex:10:30-19:00，若是小於早上十點，請打 ex:09）：");
        String running=scan.nextLine();
        if(mapSearch.isNumeric(running.substring(0,2)))
        {
            System.out.println(running.substring(0,2));
            if (Integer.valueOf(running.substring(0,2))<24&&Integer.valueOf(running.substring(0,2))>=0)
            {
                open_hours=Integer.valueOf(running.substring(0,2));
            }
            else
            {
                invalid=1;
            }

        }
        else
        {
            invalid=1;
        }
        if(mapSearch.isNumeric(running.substring(3,5)))
        {
            System.out.println(running.substring(3,5));
            if (Integer.valueOf(running.substring(3,5))<60&&Integer.valueOf(running.substring(3,5))>=0)
            {
                open_minutes=Integer.valueOf(running.substring(3,5));
            }
            else
            {
                invalid=1;
            }

        }
        else
        {
            invalid=1;
        }
        if(mapSearch.isNumeric(running.substring(6,8)))
        {
            if (Integer.valueOf(running.substring(6,8))<24&&Integer.valueOf(running.substring(6,8))>=0)
            {
                close_hours=Integer.valueOf(running.substring(6,8));
            }
            else
            {
                invalid=1;
            }

        }
        else
        {
            invalid=1;;
        }
        if(mapSearch.isNumeric(running.substring(9,11)))
        {
            if (Integer.valueOf(running.substring(9,11))<60&&Integer.valueOf(running.substring(9,11))>=0)
            {
                close_minutes=Integer.valueOf(running.substring(9,11));
            }
            else
            {
                invalid=1;
            }

        }
        else
        {
            invalid=1;
        }
        if (invalid!=1)
        {

        }
        else
        {

        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("你的選擇：");
//        menuchoose=scan.nextLine();
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
        chooseMenu();
    }
}
