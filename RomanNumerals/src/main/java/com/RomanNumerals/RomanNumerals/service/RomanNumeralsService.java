/**
 * 
 */
package com.RomanNumerals.RomanNumerals.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RomanNumerals.RomanNumerals.config.RomanNumeralsConfig;

/**
 * @author Mayuresh
 *
 */
@Service
public class RomanNumeralsService {

	@Autowired
	RomanNumeralsConfig romanNumeralConfig;

	private static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String getRomanNumerals(String strVal) {
		if (romanNumeralConfig.isNumeric(strVal)) {
			Integer num = Integer.parseInt(strVal);
			if (num > 4000 || num <= 0) {
				return "Please provide number in the range of 1 to 1000 ! \n";
			}
			StringBuilder roman = new StringBuilder();
			for (int i = 0; i < values.length; i++) {
				while (num >= values[i]) {
					num -= values[i];
					roman.append(romanLiterals[i]);
				}
			}
			return roman.toString();
		}
		return "Please provide number in the range of 1 to 1000 ! \n";
	}

	public String getDecimalNumber(String strVal) {
		if (romanNumeralConfig.isRomanNumeral(strVal)) {
			if (strVal != null && strVal != "") {
				Map<Character, Integer> romanNumeralMap = new HashMap<Character, Integer>();
				romanNumeralMap.put('I', 1);
				romanNumeralMap.put('V', 5);
				romanNumeralMap.put('X', 10);
				romanNumeralMap.put('L', 50);
				romanNumeralMap.put('C', 100);
				romanNumeralMap.put('D', 500);
				romanNumeralMap.put('M', 1000);
				Integer sum = 0;
				for (int i = 0; i < strVal.length() - 1; i++) {
					if (romanNumeralMap.get(strVal.charAt(i)) >= romanNumeralMap.get(strVal.charAt(i + 1))) {
						sum = sum + romanNumeralMap.get(strVal.charAt(i));
					} else {
						sum = sum - romanNumeralMap.get(strVal.charAt(i));
					}
				}
				sum = sum + romanNumeralMap.get(strVal.charAt(strVal.length() - 1));
				return sum.toString();
			}
			return "0";
		}
		return "Please provide roman numarals in the range of I to MMMM ! \n";
	}

}
