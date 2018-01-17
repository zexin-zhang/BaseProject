
public class couponOfUser {
  private coupon[] ownCoupon;
  private int[] restID;
  public int num = 0;

  public couponOfUser() {

  }

  public void show() {
    if (this.num == 0) {
      System.out.println("User do not have coupon.");
    }
    if(this.num!=0){
        for (int i = 0; i < this.num; i++) {
            ownCoupon[this.num].getCoupon(restID[i]);
        }
    }

  }

  public void receivedCoupon(int id) {
      this.num++;
      System.out.println("User have:");
      restID[this.num] = id;
      for(int i = 1; i < this.num + 1; i++){
          ownCoupon[i].getCoupon(restID[i]);
      }
  }

  public void useCoupon(int id) {
    System.out.println("User have:");
      for(int i = 1; i < this.num + 1; i++) {
          if (restID[i] == id) ownCoupon[i].setUsed(id);
          ownCoupon[i].getCoupon(restID[i]);
      }
  }

}
