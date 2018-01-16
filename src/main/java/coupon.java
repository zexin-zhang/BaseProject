
public class coupon {
  private String[] content;
  private int restID;
  private int couponID;
  private boolean used;

  public coupon() {
    restID = 0;
    couponID = 0;
    used = false;
  }

  public coupon(restaurant in) {
    restID = in.getID();
    couponID = restID % 3;
    content[0] = "100 minus 10";
    content[1] = "200 minus 25";
    content[2] = "300 minus 45";
    used = false;
  }

  public int getRestID() {
    return this.restID;
  }

  public void setUsed() {
    this.used = true;
  }

  public String getCoupon() {
    return in.getName() + content[couponID];
  }

  public String toString() {
    return "-------" + getCoupon() + "------";
  }
}
