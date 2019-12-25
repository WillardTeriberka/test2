import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class saveToFile {
	public saveToFile() {
		// TODO Auto-generated constructor stub
	}
	public  int saveToFile(File file,String content) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}
    public  List<String> getlist(File file){
    	//将文件每行的内容放到集合中
        StringBuilder result = new StringBuilder();
        List<String> alllist = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                //result.append(s);
            	alllist.add(s);
                //System.out.println(alllist);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        //return result.toString();
        return alllist;
    }
}
