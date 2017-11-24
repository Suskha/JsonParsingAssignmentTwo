package assignmentTwo.jsonParse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import com.google.gson.Gson;

public class JsonParse {

	private final String readFileName = "data.txt";
	private final String writeFileName = "data3.txt";
	private int count = 0;
	Company[] comp;
	Functions func = new Functions();

	public static void main(String[] args) {
		JsonParse json = new JsonParse();
		json.readLineNumber();
		json.comp = new Company[json.count];
		
		//to read from file data.txt and write from the file data3.txt
		json.readWrite();

		json.func.setCount(json.count);
		json.func.setEf(json.comp);

		//to show company with keyvalue available
		//json.func.showCompanyKeyValue();
		
		//to show company with fax availabe with '-' removed
		//json.func.showFax();
		
		//to show compay domain name
		json.func.showWebUrl();
	}
	
	public void readLineNumber() {
		try(LineNumberReader lnr = new LineNumberReader(new FileReader(readFileName));){
			while (lnr.readLine() != null) {
				count = count + 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readWrite() {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(readFileName)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writeFileName)))) {
			String value = "";
			int count1 =0;
			while ((value = br.readLine()) != null) {
				String[] data = value.split(",", 2);
				Gson gson = new Gson();
				comp[count1] = gson.fromJson(data[1], Company.class);
				func.toWriteFile(bw, comp[count1]);
				count1 = count1 + 1;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error opening file : " + readFileName);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
