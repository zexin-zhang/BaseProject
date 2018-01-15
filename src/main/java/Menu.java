import java.io.IOException;

public class Menu {
    UserPack users;
    private int choose;
    public Menu(UserPack users) throws IOException, InterruptedException {
        this.users = users;
        menuPrint();
    }
    public void chooseMenu()
    {
        switch(choose)
        {

        }
    }
    public void mapSearch()
    {
        mapSearch mapSearch_activity = new mapSearch(this.users);
    }
    public void menuPrint() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("歡迎使用本軟體，請選擇您所需要的功能");
        System.out.println("----------------------------------------------------------------------");
    }
}
