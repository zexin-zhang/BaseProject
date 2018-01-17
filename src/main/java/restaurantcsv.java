    import java.io.*;

    public class restaurantcsv {
    public static restaurantPack main() {
        restaurantPack restaurants = new restaurantPack();
        String csvFile = "./src/main/resources/restaurant.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"BIG5"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                Location location ;
                // use comma as separator
                String[] temp = line.split(cvsSplitBy);
                location = new Location(Double.valueOf(temp[4]),Double.valueOf(temp[5]));
                restaurants.add(temp[1],temp[2],temp[3],location,temp[6],temp[7],temp[8],Integer.valueOf(temp[10]),Integer.valueOf(temp[11]),Integer.valueOf(temp[12]),Integer.valueOf(temp[13]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return restaurants;
    }
        public static void write(restaurantPack restaurants) {

            try {
                File csv = new File("./src/main/resources/restaurant.csv");
                String path="./src/main/resources/restaurant.csv";
                FileOutputStream wrFile = new FileOutputStream(path,false);

                String title = "id,username,password,name,longitude,latitude,type,address,phone,available,open_hours,open_minutes,close_hours,close_minutes\n";
                wrFile.write(title.getBytes("BIG5"));

                for (int i=0;i<restaurants.restaurantNumber();i++)
                {
                    wrFile.write((restaurants.getRestaurant(i).toString()+"\n").getBytes("BIG5"));
                }

                wrFile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
