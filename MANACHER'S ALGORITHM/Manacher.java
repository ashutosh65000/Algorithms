import java.util.*;

/*
Agar isse clear na ho to hackerrank vale solution ka dry run kara ke dekhna
*/
public class Manacher{
		public static void main(String[] args) {
			
	    int max=Integer.MIN_VALUE;
	    int maxLPSCenterPosition=0;
	    String s1="forgeeksskeegfor";
	    String T=improvedString(s1);
	    int P[]=new int[T.length()];
	    int C = 0, R = -1, rad;  
		/*
		C stands for center of string 
		maxLPSCenterPosition   means that it is the centre of maximum substring
		R  means Rightmost boundary
		rad  means radius of string at i position (matlab ki i ko centre maan ke kitna us substring ko expand kiya ja sakta hai)
		*/
		
	
	for (int i = 0; i < T.length(); ++i) {
		System.out.println("i= "+i);
    if (i <= R) {
		System.out.println(P[2*C-i]+"   "+ (R-i));
        rad = Math.min(P[2*C-i], R-i); 
    } else {
		System.out.println(0);
        rad = 0; 
    }
	/*
	Above se zada samaj me nhi aaya hai
	but itna samje hai ki
	isse ye pata chalta hai ki 
	At i position kitne radius se expand karna shuru karna hai
	because usse pehle ka already symmetric(palindrome) hai
	*/
	
    // Try to extend
    while (i+rad < T.length() && i-rad >= 0 && T.charAt(i-rad) == T.charAt(i+rad)) {
        rad++; 
    }
	/*
	Above se ye pata chal raha hai ki
	i position pe kitne radius tak string symmetric(palindrome) hai
	in short palindromic substring ka pata chal raha hai
	*/
	
	
    P[i] = rad-1; // storing radius of substring at i 
	
    if (P[i] > max) // Track maxLPSLength 
            { 
                max = P[i]; 
                maxLPSCenterPosition = i; 
            } 
    /*
	isse P array ka maximum pta chal raha hai
	maxLPSCenterPosition  isse maximum length ki substring ka centre pata chal raha hai
	*/        
			
	
			
			
    if (i + rad - 1 > R) {
        C = i; 
        R = i + rad - 1; 
    }
    }
    /*
	Agar kisi substring ka radius R exceed kar raha hai to R aur C ko update karna hai
	*/
	
	
	
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