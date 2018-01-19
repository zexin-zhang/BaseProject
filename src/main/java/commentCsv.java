import java.io.*;

public class commentCsv {
	public static CommentList read() { 
		CommentList comments = new CommentList();
		String csvFile = "./src/main/resources/comment.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		
        try { 
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"BIG5"));
            line = br.readLine();
            while((line=br.readLine())!=null){ 
                String[] temp = line.split(csvSplitBy);
                Comment tem = new Comment(temp[2]);
                tem.setRestaurantID(Integer.valueOf(temp[0]));
                tem.setUserName(temp[1]);
                comments.addComment(tem);
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
        
        return comments;
    } 
	
	public static void write(CommentList comments) {
		
		try {
			File csv = new File("./src/main/resources/comment.csv");
			String resID = "resID";
			String name = "userName";
			String com = "comment";
			FileOutputStream bw = new FileOutputStream(csv,false);
			bw.write((resID+","+name+","+com+"\n").getBytes("BIG5"));
			for(int i=0;i<comments.getCommentID();i++) {
				bw.write((comments.forSave(i)+"\n").getBytes("BIG5"));
			}
			bw.close();
		} catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) {
        		e.printStackTrace();
        }
	}
}
