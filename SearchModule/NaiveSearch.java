package com.hit.algorithm;

public class NaiveSearch implements IAlgoSearch {
	public boolean Search(String str, String pattern) 
    { 
        int n = str.length(); 
        int m = pattern.length(); 
        
        for (int s = 0; s <= n - m; s++) { 
            int j; 
            for (j = 0; j < m; j++) 
                if (str.charAt(s + j) != pattern.charAt(j)) 
                    break; 
            if (j == m) 
            	return true;
                //System.out.println("Pattern occurs at index " + s); 
        } 
        return false;
    } 
  

}
