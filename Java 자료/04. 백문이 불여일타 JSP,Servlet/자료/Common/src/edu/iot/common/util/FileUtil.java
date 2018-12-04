package edu.iot.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static List<String> readLines(File file) {
		return readLines(file, "utf-8");
	}
	
	public static List<String> readLines(File file, 
										String charset) {
		List<String> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),
													charset));) {
			String line;
			while((line = br.readLine())!=null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void serialize(String path, Object obj) 
									throws Exception {
		try(
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(path))
		){
			oos.writeObject(obj);
		}
	}
	
	public static Object deserialize(String path)
									throws Exception {
		try(
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(path))
		){
			return ois.readObject(); 
		}
	}


	public static String readAll(Reader in) throws Exception {
		StringBuilder sb = new StringBuilder();
		try(
			BufferedReader br = new BufferedReader(in);
		){
			int ch;
			while((ch=br.read())!=-1) {
				sb.append((char)ch);
			}
		}
		
		return sb.toString();
	}

	
	
	public static String readAll(String path) throws Exception {
		try(FileReader fr = new FileReader(path)){
			return readAll(fr);
		}
	}
	
	public static String readResource(String path) throws Exception {
		path = FileUtil.class.getResource(path).getPath();
		return FileUtil.readAll(path);
	}
	
	public static byte[] bytes(String path) throws Exception {
		File file = new File(path);
		return bytes(file);
	}
	
	public static byte[] bytes(File file) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try(BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file)) ){
		
			int data ;
			while((data=bis.read())!=-1) {
				out.write(data);
			}
			return out.toByteArray();
		}
	}
	
	public static void save(File file, byte[] data)throws Exception {
		try(
			FileOutputStream fos = new FileOutputStream(file)	
		){
			fos.write(data);
		} 
		
	}
}





