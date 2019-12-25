import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class convertURLencode {
	public convertURLencode() {
		// TODO Auto-generated constructor stub
	}
	public static String convertURLencode(String poiname) {
		try {
			String para = java.net.URLEncoder.encode(poiname,"gbk");
			//System.out.println(para);
			return para;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poiname;
	}
}
