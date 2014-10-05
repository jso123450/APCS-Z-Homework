public class Strings {

    // 7 mins

    public String frame(int r, int c){

	String output = "";
	for (int rc = 0; rc < r; rc++) {
	    int columns = 0;
	    while ( columns < c ) {
		if ( rc == 0 || rc == r - 1 || columns == 0 || columns == c - 1 ) {
		    output+= "*";
		}
		else {
		    output+= " ";
		}
		columns++;
	    }
	    output+= "\n";
	}
	return output;
    }

    // 2 mins

    public String stringSplosion(String str) {
	String output = "";
	int len = str.length();
	for (int i = 0; i <= len; i++){
	    String sub = str.substring(0,i);
	    output+= sub;
	}
	return output;
    }
    
    // 5 mins

    public String stringX(String str){
	String output = "";
	int len = str.length();
	for (int i = 0; i < len; i++){
	    if ((i == 0 || i == (len - 1)) || (!(str.substring(i, i+1).equals("x")))) {
		output+= str.charAt(i);
	    }
	}
	return output;
    }

}
