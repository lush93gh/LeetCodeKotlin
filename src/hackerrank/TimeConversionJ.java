package hackerrank;

public class TimeConversionJ {
    public static String timeConversion(String s) {
        // Write your code here
        boolean isAM = s.endsWith("AM");
        boolean isTwelve = s.startsWith("12");
        if (isAM && isTwelve) {
            return "00" + s.substring(2, 8);
        } else if (!isAM && !isTwelve) {
            String hourString = s.substring(0, 2);
            int hour = Integer.parseInt(hourString);
            int hourShift = hour + 12;
            return hourShift + s.substring(2, 8);
        } else {
            return s.substring(0, 8);
        }
    }
}
