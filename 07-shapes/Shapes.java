public class Shapes {

    public String box(int r, int c) {

	String s = "";

	while (r>0){
	    int cc = 0;
	    while (cc < c){
		s += "*";
		cc += 1;
	    }
	    s = s + "\n";
	    r--;
	}

	return s;
    }

    // ~ 5 minutes

    public String tri1(int h){
	String output = "";
	int rc = 1;
	while (rc <= h) {
	    int cc = 0;
	    while (cc < rc) {
		output+= "*";
		cc+= 1;
	    }
	    if (rc < h) {
		output+= "\n";
	    }
	    rc+= 1;
	}
	return output;
    }


    // ~ 7 minutes

    public String tri2(int h) {

	String output = "";
	int rc = 1;
	while (rc <= h) {
	    int rc2 = h;	   
	    int rc3 = rc;
	    while (rc2 > rc) {
		output+= " ";
		rc2-= 1;
	    }
	    while (rc3 > 0) {
		output+= "*";
		rc3-= 1;
	    }
	    output+= "\n";
	    rc+= 1;
	}
	return output;
    }


    // tri1 version 2 (using for) done in class

    public String tri1v2(int h){
	String s = "";
	/*
	      int i = 0;
	      while (i < h){
	      
	      i++;
	      }
	*/
	int i, j;
	for (i=0;i<h;i++){
	    for (j=0; j<i; j++){
		s = s+ "*";
	    }
	    s = s + "\n";
	}
	return s;
    }

    // tri2 version 2 (using for) done in class

    public String tri2v2(int height){
	int h;
	int i;
	String s = "";
	for (h=1;h<=height;h++){
	    /* add the next space line */
	    for (i=0;i<height-h;i++){
		s = s + " ";
	    }
	    /* add the next triangle line */
	    for (i=0;i<h; i++){
		s = s + "*";
	    }
	    s = s + "\n";
	}
	return s;
    }


}
