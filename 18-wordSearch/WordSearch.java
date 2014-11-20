public class WordSearch {

    // Instance Variables
    
    private char[][] board;

    // Constructors
    
    public WordSearch(){
	this(20,40);
    }
    
    public WordSearch(int r, int c){
	board = new char[r][c];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		// . is used as a placeholder; default value is null
		// which is non-printing; not good for testing
		// single quotes are used for individual characters
		board[i][j] = '.';
	    }
	}
    }

    // Methods

    public String toString(){
	String output = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		output+= board[i][j];
	    }
	    output+= "\n";
	}
	return output;
    }

    public boolean checkBoundsH( boolean leftR, String w, int row, int col){
	boolean outofbounds = false;
	int c = col;
	int len = w.length();
	char check = 'D';
	int index = 0;
	try {
	    for (int i = 0; i < len; i++){
		check = board[row][c];
		index = i;
		if (leftR)
		    c++;
		else
		    c--;
	    }
	} catch (IndexOutOfBoundsException e){
	    System.out.println("addWordH crashed with " + e);
	    System.out.println("addWordH crashed when trying to add " + w.charAt(index));
	    outofbounds = true;
	}
	return outofbounds;
    }

    public boolean checkIllegalOverlapH(boolean leftR, String w, int row, int col){
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[row][c] != '.') && (board[row][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    if (leftR)
		c++;
	    else
		c--;
	}
	return illegalOverlap;
    }
    
    public void addWordH(boolean leftR, String w, int row, int col){
	int c = col;
	boolean checkBounds = checkBoundsH( leftR, w, row, c );
	if (!checkBounds){
	    boolean illegalOverlap = checkIllegalOverlapH( leftR, w, row, c );
	    if (illegalOverlap){
		System.out.println("Illegal Overlap");
	    }
	    else {
		for (int i = 0; i < w.length(); i++){
		    board[row][c] = w.charAt(i);
		    if (leftR)
			c++;
		    else
			c--;
		}
	    }
	}
    }
		
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	System.out.println("Adding hello forwards starting at R3C15");
	w.addWordH(true,"hello",3,15); // should work
	System.out.println("Adding look forwards starting at R3C14");
	w.addWordH(true,"look",3,14); // test illegal overlap
	System.out.println("Adding look forwards starting at R3C18");
	w.addWordH(true,"look",3,18); // test legal overlap
	System.out.println("Adding look forwards to R-3C20");
	w.addWordH(true,"look",-3,20); // test illegal row
	System.out.println("Adding look forwards to R3C55");
        w.addWordH(true,"look",3,55); // test illegal col
	System.out.println("Adding hey backwards R2C13");
	w.addWordH(false,"hey",2,13);
	System.out.println(w);
    }
    
}
