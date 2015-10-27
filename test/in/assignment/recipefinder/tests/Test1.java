package in.assignment.recipefinder.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import in.assignment.recipefinder.models.Ingredient;
import in.assignment.recipefinder.models.Recipe;
import in.assignment.recipefinder.models.Unit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public final class Test1 {
	
	@Test
	public final void testFile() throws IOException {
		String jsonString=null;
		try {
			jsonString = FileUtils.readFileToString(new File("resources/recipes.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();

		@SuppressWarnings("serial")
		Type collectionType = new TypeToken<List<Recipe>>() {
		}.getType();
		// Form an array of java Recipe objects from json Array
		List<Recipe> recipes = gson.fromJson(jsonString, collectionType);
		assertNotNull(recipes);
		assertEquals(2, recipes.size());

		Recipe recipe = recipes.get(1);

		assertEquals("salad sandwich", recipe.getName());

		List<Ingredient> ingredients = recipe.getIngredients();
		assertNotNull(ingredients);
		assertEquals(2, ingredients.size());

		Ingredient ingredient = ingredients.get(1);
		assertEquals("mixed salad", ingredient.getName());
		assertEquals(100, ingredient.getAmount());
		assertEquals(Unit.grams, ingredient.getUnit());
	}
}
