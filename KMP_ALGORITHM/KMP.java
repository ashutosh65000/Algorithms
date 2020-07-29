import java.util.*;
public class KMP{
	public static void main(String[]s){
			System.out.println(solve("bacbabababacaca","ababaca"));
	}
	
	static List<Integer> solve(String text,String pattern){
		int j=0,i=0;
		ArrayList<Integer> arr=new ArrayList<>();
		int lps[]=getLpsArray(pattern.toCharArray());
		//System.out.println(Arrays.toString(lps));
		for( i=0;i<text.length(); ){
			if(j==pattern.length()){
				arr.add(i-j);
				j=lps[j-1];
				//return i-j;
			}
			if(text.charAt(i)==pattern.charAt(j)){
			//	System.out.println(text.charAt(i)+"    "+i+"    "+j);
				i++;
				j++;
			}
			else{
				if(j>0){
					j=lps[j-1];
				}
				else
					i++;
			}
			
		}
		if(j==pattern.length())
            arr.add(i-j);
		
		return arr;
	}
	
	static int singleIndex(String text,String pattern){
		int j=0,i=0;
		int lps[]=getLpsArray(pattern.toCharArray());
        System.out.println(Arrays.toString(lps));
		for( i=0;i<text.length(); ){
			if(j==pattern.length()){
                System.out.println(i-j);
				return i-j;
			}
			if(text.charAt(i)==pattern.charAt(j)){
                System.out.println(text.charAt(i)+"   "+i+"   "+j);
               // System.out.println(i+"    "+j);
				i++;
				j++;
			}
			else{
				if(j>0){
					j=lps[j-1];
				}
				else
					i++;
			}
			
		}
        if(j==pattern.length())
            return i-j;
		
		return -1;
	}
	
	static int[] getLpsArray(char c[]){
	int lps[]=new int[c.length];
		int len=0;
		for(int i=1;i<c.length; ){
			if(c[len]==c[i]){
				lps[i]=len+1;
				len++;
				i++;
			}
			else{
				if(len>0)
					len=lps[len-1];
				else{
					i++;
				}
			}
		}
		
		return lps;
	}
}