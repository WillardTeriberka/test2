import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getURLContent {
	/**
	 * �����з���http���ݽӿ�
	 */
	public getURLContent() {
		// TODO Auto-generated constructor stub
	}
	public static String getURLContent(String urlStr) {
//		/** �����url��ַ */
		URL url = null;
//		/** http���� */
//		HttpURLConnection httpConn = null;
		/**//** ������ */
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "gbk"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
 
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		//System.out.println(result);
		return result;
	}
}
