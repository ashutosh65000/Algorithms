import java.util.*;

public class Manacher{
		public static void main(String[] args) {
			
	    int max=Integer.MIN_VALUE;
	    int maxLPSCenterPosition=0;
	    String s1="forgeeksskeegfor";
	    String T=improvedString(s1);
	    int P[]=new int[T.length()];
	    int C = 0, R = -1, rad;  
		
	
	for (int i = 0; i < T.length(); ++i) {
		System.out.println("i= "+i);
    if (i <= R) {
		System.out.println(P[2*C-i]+"   "+ (R-i));
        rad = Math.min(P[2*C-i], R-i); 
    } else {
		System.out.println(0);
        rad = 0; 
    }
	
	
    // Try to extend
    while (i+rad < T.length() && i-rad >= 0 && T.charAt(i-rad) == T.charAt(i+rad)) {
        rad++; 
    }
	
	
    P[i] = rad-1; // storing radius of substring at i 
	
    if (P[i] > max) // Track maxLPSLength 
            { 
                max = P[i]; 
                maxLPSCenterPosition = i; 
            } 
   
			
    if (i + rad - 1 > R) {
        C = i; 
        R = i + rad - 1; 
    }
    }
	
	
    System.out.println(Arrays.toString(P));
    System.out.println(C+"    "+R);
    int start=(maxLPSCenterPosition-max)/2;
    int end=start+max;
    String s2=s1.substring(start,end);
    System.out.println(s2);
    
}

static	String improvedString(String s){
        String n="#";
        for(int i=0;i<s.length();i++){
            n+=s.charAt(i)+"#";
        }
        return n;
    }

}
