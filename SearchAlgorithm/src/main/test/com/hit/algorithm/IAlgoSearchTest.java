package com.hit.algorithm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IAlgoSearchTest {

	String txt, pat;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("In setUp Before IAlgoSearch");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In tearDown After IAlgoSearch");
	}

	
	//kmp
	@Before
	public void initKmp() throws Exception {
		System.out.println("In init-kmp");
		txt = "ABABDABACDABABCABAB";
        pat = "ABABCABAB";
	}

	@After
	public void finishKmp() throws Exception {
		System.out.println("In finish-kmp");
		String txt = "";
        String pat = "";
	}

	@Test
	public void testKmp1() {
		System.out.println("In kmp test no.1-blackBox");
        
	}
	@Test
	public void testKmp2() {
		System.out.println("In kmp test no.2-random");
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KmpAlgoSearch().Search(pat, txt);
	}

	
	
	
	
	
}
