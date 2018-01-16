
public class couponOfUser {
  private coupon[] ownCoupon;
  int num = 0;

  public couponOfUser() {

  }

  public void show() {
    if (num == 0) {
      System.out.println("User do not have coupon.");
      break;
    }
    for (int i = 0; i < num; i++) {
      System.out.println(ownCoupon[num]);
    }
  }

  public void receivedCoupon(restaurant in) {
    ownCoupon[num] = new coupon(in);
    System.out.println("User have:");
    System.out.println(ownCoupon[num]);
    num++;
  }

  public void useCoupon(restaurant in) {
    System.out.println("User have:");
    for (int i = 0; i < num; i++) {
      System.out.print(ownCoupon[num]);
      if (ownCoupon[num].getRestID() == in.getID()) {
        ownCoupon[num].setUsed();
        System.out.println("Have been used.");
      } else
        System.out.println("Haven't been used.");

    }

  }

}
