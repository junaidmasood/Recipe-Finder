package in.assignment.recipefinder.models;

import java.util.Date;

public class Pair{
    private  boolean isPossible;
    private  Date closestUseBy;
    
	public Pair(boolean isPossible, Date closestUseBy) {
	
		this.isPossible = isPossible;
		this.closestUseBy = closestUseBy;
	}

	public boolean isPossible() {
		return isPossible;
	}

	public void setPossible(boolean isPossible) {
		this.isPossible = isPossible;
	}

	public Date getClosestUseBy() {
		return closestUseBy;
	}

	public void setClosestUseBy(Date closestUseBy) {
		this.closestUseBy = closestUseBy;
	}  
}
