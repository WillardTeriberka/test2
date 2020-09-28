import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @CreateDate : 2019/11/14
 * @UpdateDate : 2020/04/28
 */
public class matchRegex {
    public static void matchFromFile(String fileName, String reg) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long fileLength = file.length();
        byte[] fileContent_cache = new byte[fileLength.intValue()];//把整个文件读取进数组

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent_cache);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String fileContent = new String(fileContent_cache, encoding);//创建一个字符串把文件的内容放入字符串
            ArrayList<String> list = matcherContentByRegex(reg, fileContent);
            for (String s : list) {
                System.out.println(s);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
//            return null;
        }
    }

    public static void matchFromURL(String url, String reg) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            inputStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[8192];
        int len;

        try {
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);//把input读取到的数组春如output
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = outputStream.toString();//把ByteArrayOutputStream的数据写出到字符串
//        System.out.println(content);
        ArrayList<String> list = matcherContentByRegex(reg, content);
        for (String s : list) {
            System.out.println(s);//遍历匹配结果
        }
    }

    public static ArrayList<String> matcherContentByRegex(String reg, String content) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }
}
