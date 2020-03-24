package FileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopy {
	public static void main(String[] args) {
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try {
			//源文件
			fi = new FileInputStream("E:\\19202\\java\\CopyFileTest\\From\\Java8 API.chm");
			//目标文件
			fo = new FileOutputStream("E:\\19202\\java\\CopyFileTest\\To\\Java8 API.chm");
			byte[] b = new byte[1024];
            int len = 0;
			
			while((len=fi.read(b)) != -1) {
				fo.write(b, 0, len);
			}
			
			System.out.println("复制完成!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fo != null) {
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}



