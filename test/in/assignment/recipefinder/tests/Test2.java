package in.assignment.recipefinder.tests;

import org.junit.Before;
import org.junit.Test;

import in.assignment.recipefinder.FindRecipe;
import in.assignment.recipefinder.utility.TimeVariant;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Test2 {
	
	private static String csvPath;
	private static String jsonPath;
	private FindRecipe findRecipe;
	private TestTimeVariant tv;

	@Before
	public void setUp(){
		csvPath = "resources/fridge.csv";
		jsonPath = "resources/recipes.json";
		findRecipe = new FindRecipe();
		tv = new TestTimeVariant();
		TimeVariant.setDelegate(tv);
	}

	@Test
	public void checkTodayRecipe() throws IOException {
		checkRecipe("salad sandwich");
	}

	@Test
	public void checkRecipeDifferentDates() throws IOException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("21/12/2016");
		tv.setNow(d.getTime());
		checkRecipe("Order Takeout");

		d = sdf.parse("21/12/2015");
		tv.setNow(d.getTime());
		checkRecipe("grilled cheese on toast");

		d = sdf.parse("5/11/2015");
		tv.setNow(d.getTime());
		checkRecipe("salad sandwich");
	}

	private void checkRecipe(String name) throws IOException {
		assertEquals(name, findRecipe.getRecipeWrapper(csvPath, jsonPath));
	}
}
