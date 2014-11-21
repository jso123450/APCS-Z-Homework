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

    // char direction
    //    1. l = left = place the characters in String w in order from right to left
    //    2. r = right = to the right
    //    3. u = up = upwards
    //    4. d = down = downwards

    public boolean checkBounds( char direction, String w, int row, int col){
	boolean outofbounds = false;
	int c = col;
	int r = row;
	int len = w.length();
	char check = 'D';
	int index = 0;
	try {
	    for (int i = 0; i < len; i++){
		check = board[r][c];
		if (direction == 'r')
		    c++;
		else if (direction == 'l')
		    c--;
		else if (direction == 'u')
		    r--;
		else if (direction == 'd')
		    r++;
		index = i;
	    }
	} catch (IndexOutOfBoundsException e){
	    System.out.println("addWord crashed with " + e);
	    System.out.println("addWord crashed when trying to add " + w.charAt(index));
	    outofbounds = true;
	}
	return outofbounds;
    }

    public boolean checkIllegalOverlap(char direction, String w, int row, int col){
	int r = row;
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[r][c] != '.') && (board[r][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    if (direction == 'r')
		c++;
	    else if (direction == 'l')
		c--;
	    else if (direction == 'u')
		r--;
	    else if (direction == 'd')
		r++;
	}
	return illegalOverlap;
    }
    
    public void addWord(char direction, String w, int row, int col){
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
		    if (direction == 'r')
			c++;
		    else if (direction == 'l')
			c--;
		    else if (direction == 'u')
			r--;
		    else if (direction == 'd')
			r++;
		}
	    }
	}
    }
		
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	System.out.println("Adding hello LR starting at R3C15");
	w.addWord('r',"hello",3,15); // should work
	System.out.println("Adding look LR starting at R3C14");
	w.addWord('r',"look",3,14); // test illegal overlap
	System.out.println("Adding look LR starting at R3C18");
	w.addWord('r',"look",3,18); // test legal overlap
	System.out.println("Adding look LR to R-3C20");
	w.addWord('r',"look",-3,20); // test illegal row
	System.out.println("Adding look LR to R3C55");
        w.addWord('r',"look",3,55); // test illegal col
	System.out.println("Adding hey RL R2C13");
	w.addWord('l',"hey",2,13);
	System.out.println("Adding homework DU R5C15");
	w.addWord('u',"homework",8,30);
	System.out.println("Adding homework UD R5C15");
	w.addWord('d',"homework",5,15);
	System.out.println("Adding homework LR R5C15");
	w.addWord('r',"homework",5,15);
	System.out.println("Adding homework RL R7C15");
	w.addWord('l',"homework",7,15);
	System.out.println(w);
    }
    
}
