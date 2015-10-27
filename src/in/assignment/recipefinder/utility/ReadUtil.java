package in.assignment.recipefinder.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import in.assignment.recipefinder.models.Item;
import in.assignment.recipefinder.models.Recipe;
import in.assignment.recipefinder.models.Unit;

public class ReadUtil {
	
	// CSV parameters
	private static final int ITEM_NAME = 0;
	private static final int ITEM_AMOUNT = 1;
	private static final int ITEM_UNIT = 2;
	private static final int ITEM_USEBY = 3; 

	//Method to read Fridge's Item CSV 
	public static HashMap<String,Item> readCSV(String fileName) {
		
		HashMap<String,Item> items = new HashMap<String,Item>();

		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT;
		try {	
			//initialize FileReader object
			fileReader = new FileReader(fileName);

			//initialize CSVParser object
			csvFileParser = new CSVParser(fileReader, csvFileFormat);

			//Get a list of CSV file records
			List csvRecords = csvFileParser.getRecords(); 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < csvRecords.size(); i++) {
				CSVRecord record = (CSVRecord)csvRecords.get(i);
				items.put(record.get(ITEM_NAME),new Item(record.get(ITEM_NAME), Integer.parseInt(record.get(ITEM_AMOUNT)), 
						Unit.valueOf(record.get(ITEM_UNIT)), formatter.parse(record.get(ITEM_USEBY))));
			}
		} 
		catch(FileNotFoundException exception){
			System.out.println("The CSV file was not found");
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				if(fileReader!=null&&csvFileParser!=null){
				fileReader.close();
				csvFileParser.close();
				}
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser !!!");
				e.printStackTrace();
			}
		}
		return items;
	}


	//Method to read Recipe's JSON 
	public static List<Recipe> readJSON(String recipePath){

		String jsonString = null;
		try {
			jsonString = FileUtils.readFileToString(new File(recipePath));
		} 
		catch(FileNotFoundException exception){
			System.out.println("The JSON file was not found");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		@SuppressWarnings("serial")
		Type collectionType = new TypeToken<List<Recipe>>() {
		}.getType();

		// Deserialize the json array to form an array of java Recipe objects
		List<Recipe> recipes = gson.fromJson(jsonString, collectionType);
		return recipes;
	}
}
