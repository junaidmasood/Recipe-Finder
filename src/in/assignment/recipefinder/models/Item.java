package in.assignment.recipefinder.models;

import java.util.Date;

public class Item{

	private String mName;
	private int mAmount;
	private Unit mUnit;
	private Date mUseBy;


	public Item(String name, int amount, Unit unit, Date useBy) {
		mName = name;
		mAmount = amount;
		mUnit = unit;
		mUseBy = useBy;
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


	public Date getUseBy() {
		return mUseBy;
	}


	public void setUseBy(Date useBy) {
		mUseBy = useBy;
	}


	@Override
	public String toString() {
		return "Item [mName=" + mName + ", mAmount=" + mAmount + ", mUnit=" + mUnit + ", mUseBy=" + mUseBy + "]";
	}

}


