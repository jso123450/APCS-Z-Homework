public class Arrays {

    // frontPiece ~ 2 mins

    public int[] frontPiece(int[] nums){
	if (nums.length <= 2){
	    return nums;
	}
	else {
	    int[] output = new int[2];
	    for (int i = 0; i < 2; i++){
		output[i] = nums[i];
	    }
	    return output;
	}
    }

    // sum13 ~ 2 mins

    public int sum13(int[] nums){
	int output = 0;
	for (int i = 0; i < nums.length; i++){
	    if (nums[i] == 13){
		i++;
	    }
	    else {
		output+= nums[i];
	    }
	}
	return output;
    }

}
