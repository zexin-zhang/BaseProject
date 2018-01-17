import java.io.IOException;
import java.util.*;
public class Menu {
    UserPack users;
    restaurantPack restaurants;
    private int userID;
    private int choose;
    public Menu() throws IOException, InterruptedException {
        this.login();
        //this.menuPrint();
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
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
    public void login() throws IOException, InterruptedException {
    		Scanner chooses = new Scanner(System.in);
    		UserPack users = new UserPack();
    		users = userCsv.read();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1.登錄");
        System.out.println("2.註冊");
        System.out.println("3.離開");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("您的選擇：");
        this.choose = chooses.nextInt();
        chooses.nextLine();
        switch(choose) {
        		case 1:
        	        System.out.println("----------------------------------------------------------------------");
        	        System.out.println("登錄：");
        	        System.out.print("請輸入您的用戶ID：");
        	        int ID = chooses.nextInt();
        	        chooses.nextLine();
        	        System.out.print("請輸入您的用戶密碼：");
        	        String pass = chooses.nextLine();
        	        int i=4;
        	        while(i>0) {
        	        		if(users.getUser(ID).getPassword().equals(pass)) {
        	        			this.userID = ID;
        	        			this.menuPrint();
        	        			i=0;
        	        		} else {
        	        			System.out.println("密碼錯誤，您還可以嘗試"+i+"次！");
        	        			i--;
        	        		}
        	        }
        			break;
        		case 2:
        			String name;
        			String pas;
        	        System.out.println("----------------------------------------------------------------------");
        	        System.out.println("註冊：");
        	        System.out.print("請輸入您的用戶名：");
        	        name = chooses.nextLine();
        	        	System.out.print("請輸入您的密碼：");
        	        	pas = chooses.nextLine();
        	        	System.out.print("請再次確認您的密碼：");
        	        	if(pas.equals(chooses.nextLine())) {
        	        		User newUser = new User(name, pas);
        	        		users.addUser(newUser);
        	        		System.out.println("恭喜您註冊成功！");
        	        		System.out.println("您的用戶ID為："+newUser.getUserID()+" (下次登錄時請使用用戶ID登錄)");
        	        	} else {
        	        		System.out.println("對不起，兩次密碼不相符！");
        	        	}
        			break;
        		default:
        			break;
        }
        chooses.close();
    }
}