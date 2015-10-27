package in.assignment.recipefinder.models;


import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Recipe {

	@SerializedName("name")
	private String mName;
	
	@SerializedName("ingredients")
	private List<Ingredient> mIngredients;
	
	
	public Recipe(String name, List<Ingredient> ingredients) {
		super();
		mName = name;
		if(ingredients!=null&&ingredients.size()>0)
			mIngredients = ingredients;
	}


	public String getName() {
		return mName;
	}


	public void setName(String name) {
		mName = name;
	}


	public List<Ingredient> getIngredients() {
		return mIngredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		mIngredients = ingredients;
	}


	@Override
	public String toString() {
		return "Recipe [mName=" + mName + ", mIngredients=" + mIngredients + "]";
	}
}
