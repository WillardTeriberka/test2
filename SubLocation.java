
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SubLocation {
	public SubLocation() {
		// TODO Auto-generated constructor stub

	}
	public static List<String> SubLocation(String rgex,String originstr) {
		
		List<String> list = new ArrayList<String>();  
        Pattern pattern = Pattern.compile(rgex);// Æ¥ÅäµÄÄ£Ê½  
        Matcher m = pattern.matcher(originstr);  
        while (m.find()) {   
            list.add(m.group(1));  
            break;
	}
        return list; 
}
}
	