package in.assignment.recipefinder.tests;

import java.util.Date;

import in.assignment.recipefinder.utility.ITimeVariant;

public class TestTimeVariant implements ITimeVariant {
    private long simulatedTime = new Date().getTime();  

    public void setNow(long t) {
        simulatedTime = t;
    }

    public long currentTimeMillis() {
        return simulatedTime;
    }

    public Date newDate() {
        return new Date(simulatedTime);
    }
}