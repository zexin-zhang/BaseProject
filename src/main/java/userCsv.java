import java.io.*;

public class userCsv {
	public static UserPack read() { 
		UserPack users = new UserPack();
		String csvFile = "./src/main/resources/user.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		
        try { 
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"BIG5"));//换成你的文件名
            line = br.readLine();
            while((line=br.readLine())!=null){ 
                String[] temp = line.split(csvSplitBy);
                User tem = new User(temp[0],temp[2]);
                users.addUser(tem);
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
        
        return users;
    } 
	
	public static void write(UserPack users) {
		
		try {
			File csv = new File("./src/main/resources/user.csv");
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
			
			bw.write(users.getUser(0).getName()+","+users.getUser(0).getPassword());
			bw.newLine();
			bw.close();
		} catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) {
        		e.printStackTrace();
        }
	}
}
