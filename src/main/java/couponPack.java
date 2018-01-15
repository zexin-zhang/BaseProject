
public class couponPack {

  couponOfUser userr = new couponOfUser();
  coupon love = new coupon();

  couponPack(restaurant in) {
    coupon(in);
    System.out.println(love);
    userr.show();
    userr.receivedCoupon(in);
  }

  public void using(restaurant in) {
    userr.useCoupon(in);
  }

}
