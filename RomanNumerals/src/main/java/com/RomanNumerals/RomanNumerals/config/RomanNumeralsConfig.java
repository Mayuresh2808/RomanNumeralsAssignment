package com.RomanNumerals.RomanNumerals.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralsConfig {
	
	public boolean isNumeric(String strVal) {
		try {
			Integer.parseInt(strVal);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public boolean isRomanNumeral(String strVal) {
		String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		Pattern pattern = Pattern.compile(regex);
		String s = strVal.trim();
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}

}
