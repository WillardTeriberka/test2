import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectHttp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input you origin filePath: ");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("/n");
		String filePath = sc.nextLine();
		File f = new File(filePath); 
		System.out.println("Input you output filePath: ");
		Scanner sc_save = new Scanner(System.in);
		sc_save.useDelimiter("/n");
		String filePath_location = sc.nextLine(); 
		System.out.println("Input you search DistrictID: ");
		Scanner sc_DistrictID = new Scanner(System.in);
		sc_DistrictID.useDelimiter("/n");
		String DistrictID = sc_DistrictID.nextLine();
		//urlstr是高德API链接
		String urlStr1 = "https://restapi.amap.com/v3/place/text?s=rsv3&children=&key=8325164e247e15eea68b59e89200988b&page=1&offset=10&city=";
		String urlStr2 = "&language=zh_cn&callback=jsonp_804943_&platform=JS&logversion=2.0&sdkversion=1.3&appname=https%3A%2F%2Flbs.amap.com%2Fconsole%2Fshow%2Fpicker&csid=C7252352-69A7-41D4-A2F3-D3EE9308E8DD&keywords=";
		String urlStr = urlStr1+ DistrictID +urlStr2;
//		//String poiname = "宝体";
//		System.out.println("Input you want search of POIname: ");
//		Scanner sc = new Scanner(System.in);
//		sc.useDelimiter("/n");
//		String poiname = sc.nextLine();
//		String url = urlStr + convertURLencode.convertURLencode(poiname); //结合整链接
//		sc.close();
//		System.out.println(getURLContent.getURLContent(url));//获取链接访问后获得的内容
//		System.out.println(SubLocation.SubLocation(rgex, getURLContent.getURLContent(url)));//截取location中间的内容
		saveToFile sa = new saveToFile();
		String rgex = "\"location\":\"(.*?)\","; //要素格式为:"location:"xxx",只提取中间部分内容
		File filelocation = new File(filePath_location);
		//File f = new File("E:"+ File.separator+"cityitem.txt"); 
		listeToString listeToString = new listeToString();
		//System.out.println(sa.getlist(f));
		for(int i = 0;i < sa.getlist(f).size();i++) {
//				String result_location = SubLocation.SubLocation(rgex, 
//				getURLContent.getURLContent(urlStr+
//				convertURLencode.convertURLencode(sa.getlist(f).get(i)))).toString();//保存坐标转过格式的
			String temp_poiname = sa.getlist(f).get(i).toString();
			String amount = urlStr + (String)temp_poiname.toString();
			String result_location = SubLocation.SubLocation(rgex, 
			getURLContent.getURLContent(amount));//保存坐标没转过格式的			
				System.out.println("poi名称"+temp_poiname);
				//String result_location = SubLocation.SubLocation(rgex,getURLContent.getURLContent(temp_poiname));
				String result_location_sub = result_location.substring(1,result_location.length()-1);
				System.out.println("url"+urlStr+convertURLencode.convertURLencode(sa.getlist(f).get(i)));
				System.out.println("没转listpoi名称"+sa.getlist(f).get(i));
				System.out.println(result_location);
				System.out.println(result_location_sub);
				System.out.println("内容"+getURLContent.getURLContent(urlStr+convertURLencode.convertURLencode(sa.getlist(f).get(i))));
				System.out.println();
				System.out.println();
				sa.saveToFile(filelocation, result_location_sub+"\r\n");
				System.out.println("第"+(i+1)+"个POI坐标已保存！");
				//System.out.println(SubLocation.SubLocation(rgex, getURLContent.getURLContent(urlStr+convertURLencode.convertURLencode(sa.getlist(f).get(i).toString()))));
				//显示POI名称+坐标//System.out.println(sa.getlist(f).get(i)+SubLocation.SubLocation(rgex, getURLContent.getURLContent(urlStr+convertURLencode.convertURLencode(sa.getlist(f).get(i).toString()))));

		}
		System.out.println("所有POI坐标保存完毕！");
		sc_save.close();
		sc.close();
		sc_DistrictID.close();
	}
}


