package com.RomanNumerals.RomanNumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RomanNumerals.RomanNumerals.service.RomanNumeralsService;

@SpringBootTest
class RomanNumeralsApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Autowired
	RomanNumeralsService romanNumeralsService;
	
	@Test
    public void test_JUnit() {
        assertEquals("MMM", romanNumeralsService.getRomanNumerals("3000"));
        assertEquals("X", romanNumeralsService.getRomanNumerals("10"));
        assertEquals("IV", romanNumeralsService.getRomanNumerals("4"));
        assertEquals("Please provide number in the range of 1 to 1000 ! \n",
        		romanNumeralsService.getRomanNumerals("-4"));
        
        assertEquals("4000", romanNumeralsService.getDecimalNumber("MMMM"));
        assertEquals("12", romanNumeralsService.getDecimalNumber("XII"));
        assertEquals("34", romanNumeralsService.getDecimalNumber("XXXIV"));
        assertEquals("Please provide roman numarals in the range of I to MMMM ! \n", 
        		romanNumeralsService.getDecimalNumber("IVXXX"));
        
    }

}
