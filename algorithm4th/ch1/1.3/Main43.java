import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @create 2017-09-23 20:06
 * problem： 程序还存在一些问题，暂时还没想出来，比如当地址为D盘的根地址，即"D:\\"，或"C:\Windows"时会出现异常
 */
public class Main43 {
    public static List<String> getListFiles(String path) {
        List<String> result = new ArrayList<String>();
        File f = new File(path);
        File[] files = f.listFiles();

        // 方法一：文件夹和文件名混合排序
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) { //为目录
//                result.add(files[i].getPath().substring(files[i].getPath().lastIndexOf("\\") + 1));
//                List<String> list = getListFiles(files[i].getAbsolutePath());
//                for (String s : list) {
//                    result.add("\t" + s);
//                }
//            } else { //为文件
//                result.add(files[i].getName());
//            }
//        }

        // 方法二：文件夹在前，文件在后
        ArrayList<File> file = new ArrayList<File>();
        ArrayList<File> directory = new ArrayList<File>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                directory.add(files[i]);
            } else {
                file.add(files[i]);
            }
        }
        Collections.sort(file);
        Collections.sort(directory);

        for (int i = 0; i < directory.size(); i++) {
            result.add(directory.get(i).getPath().substring(directory.get(i).getPath().lastIndexOf("\\") + 1));
            List<String> list = getListFiles(directory.get(i).getAbsolutePath());
            for (String s : list) {
                result.add("\t" + s);
            }
        }
        for (int i = 0; i < file.size(); i++) {
            result.add(file.get(i).getName());
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> result = getListFiles("D:\\java");
        File f = new File("tmp.txt");
        f.delete();  //删除上一次运行后的tmp.txt文件
        FileWriter fw = new FileWriter("tmp.txt", true);
        for (String s : result) {
            fw.write(s + "\n");
        }
        fw.close();
    }
}
