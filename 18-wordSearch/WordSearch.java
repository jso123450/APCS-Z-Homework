import java.util.*;
import java.io.*;

public class WordSearch {

    /* ---------------------------------- Instance Variables -------------------------------- */
    
    private char[][] board, key;
    private int maxRows;
    private int maxCols;
    private ArrayList<String> words;
    private ArrayList<String> wordsInPuzzle;
    private Random rnd;

    /* ---------------------------------- Constructors -------------------------------- */
    
    public WordSearch(){
	this(20,40);
    }
    
    public WordSearch(int r, int c){
	rnd = new Random();
	words = new ArrayList<String>();
	Scanner sc = null;

	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e){
	    System.out.println("Can't open word file");
	    System.exit(0);
	}
	words = new ArrayList<String>();
	while (sc.hasNext()){
	    words.add(sc.next());
	}

	board = new char[r][c];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		board[i][j] = '.';
	    }
	}
	maxRows = r;
	maxCols = c;
    }

    /* ---------------------------------- Methods -------------------------------- */

    // prints out the current board

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

    private void makeKey(){
	key = new char[board.length][board[0].length];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		key[i][j] = board[i][j];
	    }
	}
    }

    public String getWIP(){
	return wordsInPuzzle.toString();
    }

    public String getKey() {
	String s = "";
				
	for (int i = 0; i < key.length; i++) {
	    for (int j = 0; j < key[i].length; j++) {
		s = s + key[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }
    
    // checks if the word specified fits onto the board by trying to assign the character on the board
    // at a position one of the characters in the word will be placed in to a placeholder variable
    // if it returns an error in the try block, it will be caught and an error message detailing
    // what happened will be printed

    public boolean checkBounds(String w, int row, int col, int deltaRow, int deltaCol){
	boolean outofbounds = false;
	// if no direction is indicated, return false
	if ((deltaRow == 0) && (deltaCol == 0))
	    return outofbounds;
	int c = col;
	int r = row;
	int len = w.length();
        char check = 'D';
	int index = 0;
	try {
	    for (int i = 0; i < len; i++){
		check = board[r][c];
		r+= deltaRow;
		c+= deltaCol;
		index = i;
	    }
	} catch (IndexOutOfBoundsException e){
	    System.out.println("addWord crashed when trying to add " + w);
	    System.out.println("addWord was attempting to add " + w.charAt(index) + " at R" + r + "C" + c);
	    System.out.println("addWord crashed with the error " + e);
	    outofbounds = true;
	}
	return outofbounds;
    }

    // checks to see if the word w illegaly overlaps with a word already on the board
    
    public boolean checkIllegalOverlap(String w, int row, int col, int deltaRow, int deltaCol){
	int r = row;
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[r][c] != '.') && (board[r][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    r+= deltaRow;
	    c+= deltaCol;
	}
	return illegalOverlap;
    }

    // adds a specified word w to the board in a random orientation and at a random location

    public boolean addWord(String w){
	boolean output = false;
	Random rnd = new Random();
	int r = rnd.nextInt(maxRows);
	int c = rnd.nextInt(maxCols);
	int deltaR = rnd.nextInt(3) - 1;
	int deltaC = rnd.nextInt(3) - 1;
	boolean Bounds = checkBounds(w,r,c,deltaR,deltaC);
	if (Bounds){
	    output = false;
	    System.out.println("Out of Bounds");
        }
	else{
	    boolean Illegal = checkIllegalOverlap(w,r,c,deltaR,deltaC);
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

    // to add a word to a specified location with a specified direction
    
    public void addWord(String w, int row, int col, int deltaRow, int deltaCol){
	int r = row;
	int c = col;
	boolean checkBounds = checkBounds(w,r,c,deltaRow,deltaCol);
	if (!checkBounds){
	    boolean illegalOverlap = checkIllegalOverlap(w,r,c,deltaRow,deltaCol );
	    if (illegalOverlap){
		System.out.println("Illegal Overlap");
	    }
	    else {
		for (int i = 0; i < w.length(); i++){
		    board[r][c] = w.charAt(i);
		    r+= deltaRow;
		    c+= deltaCol;
		}
		System.out.println("The word " + w + " has successfully been added!");
	    }
	}
    }

    public void buildPuzzle(int numwords){

	/*
	  loop 
	  take a random word out of the word list
	  try to add it to the puzzle

	*/
	wordsInPuzzle = new ArrayList<String>();
	while (numwords > 0){
	    int wordIndex = rnd.nextInt(words.size());
	    String word = words.get(wordIndex);
	    if (addWord(word)) {
		numwords--;
		words.remove(wordIndex);
		wordsInPuzzle.add(word);
	    }
	}
	makeKey();
	/* fill the rest of the board */
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j]=='.'){
		    /* method 2 */
		    String letters = "abcdefghijklmnopqrstuvwxyz";
		    char letter = letters.charAt(rnd.nextInt(letters.length()));
		    board[i][j]=letter;
												
		    /* method 1
		       int offset = rnd.nextInt(26);
		       board[i][j]=(char)((int)'a'+offset);
		    */
		}
	    }
	}
    }

    /* ---------------------------------- Main -------------------------------- */
		
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	/*
	  Tests
        System.out.println("Adding hello LR starting at R3C15");
	w.addWord("hello",3,15,0,1);
	System.out.println("Adding hello RL starting at R3C15");
	w.addWord("hello",3,15,0,-1);
	System.out.println("Adding hello upwards starting at R3C15"); // the error should be caught
	w.addWord("hello",3,15,-1,0);
	System.out.println("Adding hello downwards starting at R3C15");
	w.addWord("hello",3,15,1,0);
	System.out.println("Adding hello diagonally up right starting at R3C15"); // the error should be caught
	w.addWord("hello",3,15,-1,1);
	System.out.println("Adding hello diagonally down right starting at R3C15");
	w.addWord("hello",3,15,1,1);
	System.out.println("Adding hello diagonally up left starting at R3C15"); // the error should be caught
	w.addWord("hello",3,15,-1,-1);
	System.out.println("Adding hello diagonally down left starting at R3C15");
	w.addWord("hello",3,15,1,-1);
	System.out.println("Adding homework LR starting at R7C14");
	w.addWord("homework",7,14,0,1);
	System.out.println("Adding homework LR starting at R6C15"); // the error should be caught
	w.addWord("homework",6,15,0,1);
	*/
	w.buildPuzzle(10);
	System.out.println(w);
    }
    
}
