import java.util.Scanner;

public class couponPack {
    Scanner input = new Scanner(System.in);
    couponOfUser userr = new couponOfUser();

    public couponPack(restaurantPack in) {
        coupon favor=new coupon(in);
        for (int i = 0; i < in.restaurantNumber(); i++){
            favor.getCoupon(i);
        }
        showUser();

    // receive coupon
    System.out.println("Do u want to receive coupon？（Y/N）：");
    String whetherRecive = input.nextLine();
    switch (whetherRecive){
        case ("Y"):{
            System.out.println("Please enter restaurant's id:");
            int couID = input.nextInt();
            this.receiving(couID);
            break;
        }
        case("N"):{
            break;
        }
    }

     //use coupon
        if (whetherRecive.contentEquals("Y")) {
            System.out.println("Do u want to use coupon？（Y/N）：");
            String whetherUse = input.nextLine();
            switch (whetherUse) {
                case ("Y"): {
                    System.out.println("Please enter restaurant's id:");
                    int couID = input.nextInt();
                    this.using(couID);
                    break;
                }
                case ("N"): {
                    break;
                }
            }
        }
  }

  public void showUser(){
    userr.show();
  }

  public void receiving(int id){
    userr.receivedCoupon(id);
  }

  public void using(int id) {
    userr.useCoupon(id);
  }

}
