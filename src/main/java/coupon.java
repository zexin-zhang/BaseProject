
public class coupon {
  private String[] content;
  private String[] contentOfRest;
  private String[] restName;
  private int numOfRest = 0;
  private boolean[] used;

  public coupon() {
    used[0] = false;
  }

  public coupon(int id){

  }

  public void setUsed(int id){
      used[id] = true;
  }
  public String ifUsed(int id){
      if(used[id])  return "used";
      else return "not used";
  }

  public coupon(restaurantPack in) {
      content[0] = "100 minus 10";
      content[1] = "200 minus 25";
      content[2] = "300 minus 45";

      numOfRest = in.restaurantNumber();
      for (int i = 0; i < numOfRest; i++){
          contentOfRest[i+1] = content[(i+1) % 3];
          used[i+1] = false;
          restName[i+1] = in.getRestaurant(i+1).getName();
      }
  }

  public String getCoupon(int i) {
          return restName[i+1] +"   "+ contentOfRest[i+ 1] +  ifUsed(i+1) +"\n";
  }

}
