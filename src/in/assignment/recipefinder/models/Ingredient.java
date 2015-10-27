package in.assignment.recipefinder.models;
import com.google.gson.annotations.SerializedName;

public class Ingredient {
 
	@SerializedName("item")
	private String mName;
	
	@SerializedName("amount")
	private int mAmount;
	
	@SerializedName("unit")
	private Unit mUnit;
	
	
	public Ingredient(String name, int amount, Unit unit) {
		super();
		mName = name;
		mAmount = amount;
		mUnit = unit;
	}


	public String getName() {
		return mName;
	}


	public void setName(String name) {
		mName = name;
	}


	public int getAmount() {
		return mAmount;
	}


	public void setAmount(int amount) {
		mAmount = amount;
	}


	public Unit getUnit() {
		return mUnit;
	}


	public void setUnit(Unit unit) {
		mUnit = unit;
	}


	@Override
	public String toString() {
		return "Ingredient [mName=" + mName + ", mAmount=" + mAmount + ", mUnit=" + mUnit + "]";
	}
	
}
