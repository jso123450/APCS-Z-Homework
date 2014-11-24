import java.util.Random;

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

    public boolean checkBounds( String w, int row, int col, int deltaR, int deltaC ){
	boolean outofbounds = false;
	if (deltaR == 0 && deltaC == 0)
	    return outofbounds;      
	int c = col;
	int r = row;
	int len = w.length();
        char check = 'D';
	int index = 0;
	try {
	    for (int i = 0; i < len; i++){
		check = board[r][c];
	        r+= deltaR;
		c+= deltaC;
		index = i;
	    }
	} catch (IndexOutOfBoundsException e){
	    System.out.println("addWord crashed with " + e);
	    System.out.println("addWord crashed when trying to add " + w.charAt(index));
	    outofbounds = true;
	}
	return outofbounds;
    }

    public boolean checkIllegalOverlap( String w, int row, int col, int deltaR, int deltaC ){
	int r = row;
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[r][c] != '.') && (board[r][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    r+= deltaR;
	    c+= deltaC;
	}
	return illegalOverlap;
    }

    public boolean addWord(String w){
	boolean output = false;
	Random rnd = new Random();
	String direction = whichDir [ rnd.nextInt(8) ];
	int r = rnd.nextInt(maxRows);
	int c = rnd.nextInt(maxCols);
	int deltaR = rnd.nextInt(3) - 1;
	int deltaC = rnd.nextInt(3) - 1;
	boolean Bounds = checkBounds( w, r, c, deltaR, deltaC );
	if (Bounds){
	    output = false;
	    System.out.println("Out of Bounds or deltaR = deltaC = 0");
        }
	else{
	    boolean Illegal = checkIllegalOverlap( w, r, c, deltaR, deltaC );
	    if (!(Illegal)){
		for (int i = 0; i < w.length(); i++){
		    board[r][c] = w.charAt(i);
		    r+= deltaR;
		    c+= deltaC;
		}
		output = true;
	    } 
	    else{
		System.out.println("Illegal Overlap");
		output = false;
	    }
	}
	return output;
    }
    
    public void addWord(String w, int row, int col, int deltaR, int deltaC){
	int r = row;
	int c = col;
	boolean checkBounds = checkBounds( w, row, c, deltaR, deltaC );
	if (!checkBounds){
	    boolean illegalOverlap = checkIllegalOverlap( w, row, c, deltaR, deltaC );
	    if (illegalOverlap){
		System.out.println("Illegal Overlap");
	    }
	    else {
		for (int i = 0; i < w.length(); i++){
		    board[r][c] = w.charAt(i);
		    r+= deltaR;
		    c+= deltaC;
		}
		System.out.println("The word " + w + " has successfully been added!");
	    }
	}
    }

    /* ---------------------------------- Main -------------------------------- */
		
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	w.addWord("hello");
	w.addWord("homework", 15, 15, 0, 1);
	w.addWord("homework", 15, 15, 0, -1);
	w.addWord("homework", 15, 15, 1, 0);
	w.addWord("homework", 15, 15, -1, 0);
	w.addWord("homework", 15, 15, -1, -1);
	w.addWord("homework", 15, 15, 1, -1);
	w.addWord("homework", 15, 15, 1, 1);
	System.out.println(w);
    }
    
}
