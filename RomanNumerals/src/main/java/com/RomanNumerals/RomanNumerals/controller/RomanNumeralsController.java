/**
 * 
 */
package com.RomanNumerals.RomanNumerals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RomanNumerals.RomanNumerals.service.RomanNumeralsService;

/**
 * @author Mayuresh
 *
 */
@RestController
public class RomanNumeralsController {

	@Autowired
	RomanNumeralsService romanNumeralsService;

	@GetMapping(path = "/getRomanNumeral/{strVal}", produces = "application/json")
	public String getRomanNumeral(@PathVariable String strVal) {
		return romanNumeralsService.getRomanNumerals(strVal);
	}

	@GetMapping(path = "/getDecimalNumber/{strVal}", produces = "application/json")
	public String getDecimalNumber(@PathVariable String strVal) {
		return romanNumeralsService.getDecimalNumber(strVal);
	}

}
