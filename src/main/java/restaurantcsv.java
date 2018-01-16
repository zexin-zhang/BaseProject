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
                restaurants.add(temp[1],temp[2],temp[3],location,temp[6],temp[7],temp[8],Integer.valueOf(temp[9]),Integer.valueOf(temp[10]),Integer.valueOf(temp[11]),Integer.valueOf(temp[12]));
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

}
