import java.io.*;

public class favoritePack {
    favorite[] favor_restaurant;
    int index=0;
    public favoritePack()
    {
        favor_restaurant = new favorite[100];
        readcsv();
    }
    public void newfavorite(int restaurantID,int UserID,int type)
    {
        favor_restaurant[index] = new favorite(type,restaurantID,UserID);
        index++;
        write();
    }
    public favorite foundfavaoriteByResID(int resid,int usrid)
    {
        for (int i=0;i<index;i++)
        {
            if (favor_restaurant[i].getFavoritebyres(resid,usrid)!=null)
            {
                return favor_restaurant[i];
            }
        }
        return null;
    }
    public favorite foundfavaoriteByType(int type,int usrid)
    {
        for (int i=0;i<index;i++)
        {
            if (favor_restaurant[i].getFavoritebytype(type)!=null)
            {
                return favor_restaurant[i];
            }
        }
        return null;
    }
    public void setfavorite(int restaurantID,int userID,int type)
    {
        favorite thisres = foundfavaoriteByResID(restaurantID,userID);
        thisres.setType(type);
        write();
    }
    public void readcsv() {

        String csvFile = "./src/main/resources/favorite.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"BIG5"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                favorite temp_res;
                String[] temp = line.split(cvsSplitBy);
                temp_res = new favorite(Integer.valueOf(temp[2]),Integer.valueOf(temp[0]),Integer.valueOf(temp[1]));
                favor_restaurant[index] = temp_res;
                index++;
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
    }
    public void write() {

        try {
            File csv = new File("./src/main/resources/favorite.csv");
            String path="./src/main/resources/favorite.csv";
            FileOutputStream wrFile = new FileOutputStream(path,false);

            String title = "restaurantID,UserID,type\n";
            wrFile.write(title.getBytes("BIG5"));

            for (int i=0;i<index;i++)
            {
                wrFile.write((this.favor_restaurant[i].toString()+"\n").getBytes("BIG5"));
            }

            wrFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class favorite
{
    private int type;// 偏好為1，黑名單為2，沒特殊感情為0
    private int restaurantID;
    private int userID;
    public  favorite(int type,int restaurantID,int userID)
    {
        this.type = type;
        this.restaurantID = restaurantID;
        this.userID = userID;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public favorite getFavoritebyres(int restaurantID,int usrID)
    {
        if(restaurantID == this.restaurantID&&usrID == this.userID)
        {
            return this;
        }
        else
        {
            return null;
        }
    }
    public favorite getFavoritebyusr(int userID)
    {
        if(userID == this.userID)
        {
            return this;
        }
        else
        {
            return null;
        }
    }
    public favorite getFavoritebytype(int type)
    {
        if(type == this.type)
        {
            return this;
        }
        else
        {
            return null;
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(restaurantID)+","+String.valueOf(userID)+","+String.valueOf(type);
    }
}
