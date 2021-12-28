package com.hit.algorithm;
import com.hit.algorithm.KmpAlgoSearch;
import com.hit.algorithm.NaiveSearch;
import com.hit.algorithm.ZSearch;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;


public class IAlgoSearchTest {

	@Test
    public void TrueTest(){
        String s1 = "asdasdasd";
        String s2 = "asdasd111asd";
        String s3 = "asdas2234dasd";

        String subs1 = "asd";
        String subs2 = "d11";
        String subs3 = "as22";
        
        assertTrue(new KmpAlgoSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the KMP Algo");   
        assertTrue(new NaiveSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Naive Algo");   
        assertTrue(new ZSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Z Algo");   
    
        assertTrue(new KmpAlgoSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the KMP Algo");   
        assertTrue(new NaiveSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Naive Algo");   
        assertTrue(new ZSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Z Algo");   
    
        assertTrue(new KmpAlgoSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the KMP Algo");   
        assertTrue(new NaiveSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Naive Algo");   
        assertTrue(new ZSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be True but didn't passed the Z Algo");   
    
	}

	@Test
    public void FalseTest(){
        String s1 = "asdasdasd";
        String s2 = "asdasd111asd";
        String s3 = "asdas2234dasd";

        String subs1 = "asdd";
        String subs2 = "d11a";
        String subs3 = "asddd";

        assertFalse(new KmpAlgoSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be False but passed the KMP Algo");   
        assertFalse(new NaiveSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be False but passed the Naive Algo");   
        assertFalse(new ZSearch().Search(subs1, s1), () -> "Error! you have an end case here, sum string sopposed to be False but didn't passed the Z Algo"); 
	
        assertFalse(new KmpAlgoSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be False but passed the KMP Algo");   
        assertFalse(new NaiveSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be False but passed the Naive Algo");   
        assertFalse(new ZSearch().Search(subs2, s2), () -> "Error! you have an end case here, sum string sopposed to be False but didn't passed the Z Algo"); 
	
        assertFalse(new KmpAlgoSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be False but passed the KMP Algo");   
        assertFalse(new NaiveSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be False but passed the Naive Algo");   
        assertFalse(new ZSearch().Search(subs3, s3), () -> "Error! you have an end case here, sum string sopposed to be False but didn't passed the Z Algo"); 
	
	}
	
	
	public static void main(String args[])
    {
       new IAlgoSearchTest();
    }
	
}