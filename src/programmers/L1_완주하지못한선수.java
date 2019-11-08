package programmers;

import java.util.Arrays;
import java.util.List;

public class L1_완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String answer = "";
        
        Arrays.sort(participant);
	    Arrays.sort(completion);
	    
	    List<String> participant_ = Arrays.asList(participant);
	    List<String> completion_ = Arrays.asList(completion);
	    
	    for(int i=0; i<completion_.size(); i++) {
	    	if(!participant_.get(i).equals(completion_.get(i))) {
	    		answer = participant_.get(i);
	    		break;
	    	}
	    }
	    
	    if(answer == "") answer = participant_.get(participant_.size()-1);
	}
}
