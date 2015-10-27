package in.assignment.recipefinder;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import in.assignment.recipefinder.models.Ingredient;
import in.assignment.recipefinder.models.Item;
import in.assignment.recipefinder.models.Pair;
import in.assignment.recipefinder.models.Recipe;
import in.assignment.recipefinder.utility.ReadUtil;
import in.assignment.recipefinder.utility.TimeVariant;

public class FindRecipe {
	
	public static void main(String[] args){
		if (args==null||args.length!=2) {
			System.out.println("Please enter both FridgeItem CSV and Recipe JSON file paths");
			System.exit(0);
		}			  	 
		FindRecipe findRecipe = new FindRecipe();
		System.out.println(findRecipe.getRecipeWrapper(args[0],args[1]));
	}

	//Wrapper function to get the Today's Recipe
	public String getRecipeWrapper(String itemsPath, String recipePath) {
		HashMap<String, Item> items = null;
		List<Recipe> recipes = null;
		
		items = ReadUtil.readCSV(itemsPath);
		recipes = ReadUtil.readJSON(recipePath);
		
		if(items!=null&&!items.isEmpty()&&recipes!=null&&!recipes.isEmpty())
		return getRecipe(items,recipes);
		else
		return "";
	}

	// Function to get the Today's Recipe
	public String getRecipe(HashMap<String, Item> items, List<Recipe> recipes){
		Recipe answer = null;
		Date date = new Date(Long.MAX_VALUE);
       
		for(Recipe recipe : recipes){
			Pair pair = checkPossibleAndDate(items,recipe);
			if(pair.isPossible())
			{
				Date closestDate = pair.getClosestUseBy();
				if(closestDate!=null&&closestDate.before(date))
				{
					date = closestDate;
					answer = recipe;
				}
			}
		}
		if(answer!=null)
			return answer.getName();
		else
			return "Order Takeout";
	}

	// Helper method to check if a Recipe can be made from the available Items 
	// and get the ClosestUseBy Date from amongst its ingredients
	public Pair checkPossibleAndDate(HashMap<String, Item> items, Recipe recipe){
		Date date = new Date(Long.MAX_VALUE);
		boolean possible = false;

		for(Ingredient ingredient : recipe.getIngredients()){
			String name = ingredient.getName();
			Item item = null;
			// Check if ingredient is in the Fridge
			if(items.containsKey(name)){
				item = items.get(name);
			}
			// Check if ingredient has not expired and has the required amount and unit
			if(	(item!=null)&&
				(item.getUseBy().after(TimeVariant.newDate()))&&
				(item.getUnit().equals(ingredient.getUnit()))&&
				(item.getAmount()>=ingredient.getAmount())){
				if(item.getUseBy().before(date))
					date = item.getUseBy();
				possible = true;
			}
			else return new Pair(false,null);
		}
		return new Pair(possible,date);
	}
}
