import java.io.IOException;
import java.util.*;
public class Main {
    public static void  main(String args[]) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        UserPack users = new UserPack();
        User user = new User();
        System.out.println("初始設定：");
        System.out.print("你的姓名：");
        user.setName(scanner.nextLine());

        users.addUser(user);
        Menu menu = new Menu(users);


    }
}
