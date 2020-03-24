package WordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class WordCount {
		public static void main(String args[]) throws Exception{
			String filepath = "E:\\19202\\java\\ʵ��\\Lab2\\�˲���ĸǴı�Ӣ��.txt";
			
			List<String> lists = readfile(filepath);

			Map<String,Integer> map = wordcount(lists);
			
			Map<String,Integer> result = sort(map);
			
			String result_file_path = "E:\\19202\\java\\ʵ��\\Lab2\\output.txt";
			
			writefile(result_file_path, result);
			
			System.out.println("ͳ�Ƴɹ��������д���ļ���" + result_file_path);
		}
		
		/*
		 * �Ӹ����ļ��ж�ȡ���ݣ����ֳ����ʣ����ѽ������һ��list�з���
		 */
		public static List<String> readfile(String filepath) throws Exception {
			BufferedReader  br = new BufferedReader(new FileReader(filepath));
			List<String> lists = new ArrayList<String>();
			String readline = null;
			while((readline = br.readLine()) != null){
				String[] wordsArr = readline.split("[^a-zA-Z]");
				
				for (int i=0; i<wordsArr.length; i++){
					if(wordsArr[i] != "") {
						lists.add(wordsArr[i]);	
					}				
				}							
			}
			br.close();
			return lists;
		}
		
		/*
		 * �Ӵ����list��ͳ�Ƶ��ʳ��ֵĴ��������������map�в�����
		 */
		public static Map<String,Integer> wordcount(List<String> lists){
			Map<String,Integer> map=new TreeMap<String,Integer>();
			for(int j=0; j<lists.size(); j++){
				if(lists.get(j) != "") {
					String key=lists.get(j).toLowerCase();	
					if(map.get(key) != null){
						map.put(key, map.get(key)+1); 
					}
					else{	
						map.put(key, 1);		
					}	
				}
			}
			return map;
		}
		
		/*
		 * �Դ����map����valueֵ�������򣬽��������һ���µ�map������
		 */
		public static Map<String,Integer> sort(Map<String,Integer> map) {
	        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
	        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
	            @Override
	            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
	                int compare = (o1.getValue()).compareTo(o2.getValue());
	                return -compare;
	            }
	        });
	 
	        Map<String,Integer> returnMap = new LinkedHashMap<String,Integer>();
	        for (Map.Entry<String,Integer> entry : list) {
	            returnMap.put(entry.getKey(), entry.getValue());
	        }
	        return returnMap;
	    }
		
		/*
		 * �������map�е���Ϣ��ʽ��д���������ָ���ļ��С�
		 */
		public static void writefile(String filepath, Map<String,Integer> result) {
			File file = null;
			FileWriter fw = null;
			try {
				file = new File(filepath);
				if (!file.exists()) {
					file.createNewFile();
				}
				fw = new FileWriter(file);
				for(Entry<String, Integer> entry:result.entrySet()) {
					String str = String.format("%-12s", entry.getKey())  + String.valueOf(entry.getValue()) + "\r\n";
					fw.write(str);
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
}	