package in.assignment.recipefinder.utility;

import java.util.Date;

public class TimeVariant {
	private static ITimeVariant tvDelegate = null;

    public static void setDelegate(ITimeVariant tv) {
        tvDelegate = tv;
    }

    public static Date newDate() {
        if (tvDelegate!=null)
            return tvDelegate.newDate();
        else
            return new Date();
    }
}
