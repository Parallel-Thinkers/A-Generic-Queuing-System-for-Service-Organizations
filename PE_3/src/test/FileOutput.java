package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOutput {

	static File file = null;
	static FileWriter fw;
	static BufferedWriter bw;
	public void setFileWriter(){
		try {

//			String currentTime = ""+System.currentTimeMillis();
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   //get current date time with Date()
			   Date date = new Date();
//			   System.out.println(dateFormat.format(date));
			   String currentDate = dateFormat.format(date);
			   currentDate = currentDate.replaceAll("/", "-");
			   String filePath = "/home/kumar/javaprog/PE_3/src/logs/log"+currentDate+".csv";
//			   filePath = filePath.replaceAll(" ", "");
			   
			file = new File(filePath);
//			file = new File("/home/kumar/javaprog/PE_3/src/logs/abc.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

//			fw = new FileWriter(file.getAbsoluteFile());
//			bw = new BufferedWriter(fw);
//			bw.write(content);
//			bw.close();

//			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getFile(){
		return file;
	}
	
	public void setFileContent(String content){
		
		try {
			fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content+"\n");
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
}