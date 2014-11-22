import java.util.*;

public class WordSearch {

    /* ---------------------------------- Instance Variables -------------------------------- */
    
    private char[][] board;
    private int maxRows;
    private int maxCols;
    private String[] whichDir
	= {"u", "d", "l", "r",
	    "dur", "ddr", "dul", "ddl"};

    /* ---------------------------------- Constructors -------------------------------- */
    
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
	maxRows = r;
	maxCols = c;
    }

    /* ---------------------------------- Methods -------------------------------- */

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

    // string direction
    //    1. l = left = place the characters in String w in order from right to left
    //    2. r = right = to the right
    //    3. u = up = upwards
    //    4. d = down = downwards
    //    5. diagonals
    //       - dur = diagonal up right
    //       - ddr = diagonal down right
    //       - dul = diagonal up left
    //       - ddl = diagonal down left

    public int[] indexIncrement( String direction, int row, int col){
	int[] output = new int[2];
	int c = col;
	int r = row;
	if (direction.equals("r"))
	    c++;
	else if (direction.equals("l"))
	    c--;
	else if (direction.equals("u"))
	    r--;
	else if (direction.equals("d"))
	    r++;
	else if (direction.equals("dur")){
	    r--;
	    c++;
	}
	else if (direction.equals("ddr")){
	    r++;
	    c++;
	}
	else if (direction.equals("dul")){
	    r--;
	    c--;
	}
	else if (direction.equals("ddl")){
	    r++;
	    c--;
	}
	else{
	    // ends program if invalid direction is entered as a parameter
	    System.out.println("A valid direction must be entered");
	    System.out.println("Valid directions: u, d, l, r, dur, ddr, dul, ddl ");
	    System.exit(0);
	}
	output[0] = r;
	output[1] = c;
	return output;
    }

    public boolean checkBounds( String direction, String w, int row, int col){
	boolean outofbounds = false;
	int c = col;
	int r = row;
	int len = w.length();
        char check = 'D';
	int index = 0;
	try {
	    for (int i = 0; i < len; i++){
		check = board[r][c];
		r = indexIncrement(direction,r,c)[0];
		c = indexIncrement(direction,r,c)[1];
		index = i;
	    }
	} catch (IndexOutOfBoundsException e){
	    System.out.println("addWord crashed with " + e);
	    System.out.println("addWord crashed when trying to add " + w.charAt(index));
	    outofbounds = true;
	}
	return outofbounds;
    }

    public boolean checkIllegalOverlap(String direction, String w, int row, int col){
	int r = row;
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[r][c] != '.') && (board[r][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    r = indexIncrement(direction,r,c)[0];
	    c = indexIncrement(direction,r,c)[1];
	}
	return illegalOverlap;
    }

    public boolean addWord(String w){
	boolean output = false;
	Random rnd = new Random();
	String direction = "";
	int r;
	int c;
	r = rnd.nextInt(maxRows);
	c = rnd.nextInt(maxCols);
	direction = whichDir[ rnd.nextInt(8) ];
	boolean Bounds = checkBounds( direction, w, r, c );
	if (Bounds){
	    output = false;
	    System.out.println("Out of Bounds");
        }
	else{
	    boolean Illegal = checkIllegalOverlap( direction, w, r, c);
	    if (!(Illegal)){
		addWord( direction, w, r, c );
		output = true;
	    } 
	    else{
		System.out.println("Illegal Overlap");
		output = false;
	    }
	}
	return output;
    }
    
    public void addWord(String direction, String w, int row, int col){
	int r = row;
	int c = col;
	boolean checkBounds = checkBounds( direction, w, row, c );
	if (!checkBounds){
	    boolean illegalOverlap = checkIllegalOverlap( direction, w, row, c );
	    if (illegalOverlap){
		System.out.println("Illegal Overlap");
	    }
	    else {
		for (int i = 0; i < w.length(); i++){
		    board[r][c] = w.charAt(i);
		    r = indexIncrement(direction,r,c)[0];
		    c = indexIncrement(direction,r,c)[1];
		}
		System.out.println("The word " + w + " has successfully been added!");
	    }
	}
    }

    /* ---------------------------------- Main -------------------------------- */
		
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	System.out.println("Adding hello LR starting at R3C15");
	w.addWord("r","hello",3,15); // should work
	System.out.println("Adding look LR starting at R3C14");
	w.addWord("r","look",3,14); // test illegal overlap
	System.out.println("Adding look LR starting at R3C18");
	w.addWord("r","look",3,18); // test legal overlap
	System.out.println("Adding look LR to R-3C20");
	w.addWord("r","look",-3,20); // test illegal row
	System.out.println("Adding look LR to R3C55");
        w.addWord("r","look",3,55); // test illegal col
	System.out.println("Adding hey RL R2C13");
	w.addWord("l","hey",2,13);
	System.out.println("Adding homework DU R5C15");
	w.addWord("u","homework",8,30);
	System.out.println("Adding homework UD R5C15");
	w.addWord("d","homework",5,15);
	System.out.println("Adding homework LR R5C15");
	w.addWord("r","homework",5,15);
	System.out.println("Adding homework RL R7C15");
	w.addWord("l","homework",7,15);
	System.out.println("Adding homework DUR R19C10");
	w.addWord("dur","homework",19,10);
	System.out.println("Adding homework DUL R19C24");
	w.addWord("dul","homework",19,24);
	System.out.println("Adding homework DDR R12C19");
	w.addWord("ddr","homework",12,19);
	System.out.println("Adding homework DDL R12C10");
	w.addWord("ddl","homework",12,10);
	System.out.println("Adding random word");
	w.addWord("World");
	w.addWord("cool","cool",15,15);
	System.out.println(w);
    }
    
}
