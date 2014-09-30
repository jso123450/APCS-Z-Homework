public class Strings {
    public String frontTimes(String str, int n){
	if (str.length() <= 3)
	    String front = str;
	else
	    String front = str.substring(0, 3);
	String output = "";
	while (n > 0) {
	    output = output + front;
	    n = n - 1;
	}
	return output;
    }
}
