package assignmentTwo.jsonParse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class JsonParse {

	private final String readFileName = "data.txt";
	private final String writeFileName = "data3.txt";
	private int count = 0;
	Company[] comp;
	Functions func = new Functions();

	public static void main(String[] args) throws FileNotFoundException {
		JsonParse json = new JsonParse();
		json.readLineNumber();
		json.comp = new Company[json.count];
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		// to read from file data.txt and write from the file data3.txt
		json.readWrite();

		json.func.setCount(json.count);
		json.func.setEf(json.comp);
		while (flag) {
			
			System.out.println("1 - to view Company key value");
			System.out.println("2 - to view Fax number");
			System.out.println("3 - to view the weburl");
			System.out.println("4 - to view the company:description text file");
			System.out.println("0 - to quit");
			System.out.print("Enter what you want to do : ");
			int a = 0;
			a = input.nextInt();
			input.nextLine();
			switch (a) {
			// to show company with keyvalue available
			case 1:
				json.func.showCompanyKeyValue();
				break;
			// to show company with fax availabe with '-' remove
			case 2:
				json.func.showFax();
				break;
			// to show compay domain name
			case 3:
				json.func.showWebUrl();
				break;
			case 4:
				Scanner reader = new Scanner(new File("data3.txt"));
				while (reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
				break;
			case 0:
				flag = false;
				break;

			}
		}

		input.close();

	}

	public void readLineNumber() {
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(readFileName));) {
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
			int count1 = 0;
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
