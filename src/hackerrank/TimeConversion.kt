package hackerrank

class TimeConversion {
    /*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

    fun timeConversion1(s: String): String {
        // Write your code here
        return if (s.endsWith("AM")) {
            if (s.startsWith("12")) "00" + s.substring(2, 8)
            else s.dropLast(2)
        } else {
            if (s.startsWith("12")) s.dropLast(2)
            else (s.take(2).toInt() + 12).toString() + s.substring(2, 8)
        }
    }

    fun timeConversion(s: String): String {
        // Write your code here
        val hh = (s[0] - '0') * 10 + (s[1] - '0')
        val mm = (s[3] - '0') * 10 + (s[4] - '0')
        val ss = (s[6] - '0') * 10 + (s[7] - '0')

        return if (s[8] == 'A' && hh == 12) {
            String.format("%02d:%02d:%02d", 0, mm, ss)
        } else if (s[8] == 'P' && hh != 12) {
            String.format("%02d:%02d:%02d", hh + 12, mm, ss)
        } else String.format("%02d:%02d:%02d", hh, mm, ss)
    }
}