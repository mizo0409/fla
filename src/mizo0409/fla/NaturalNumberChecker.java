package mizo0409.fla;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalNumberChecker {

	private static String EXPRESSION = "(1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
	
	public static void main(String[] args) {
		NaturalNumberChecker checker = new NaturalNumberChecker();
		boolean isNaturalNumber = checker.check(args[0]);
		System.out.println(isNaturalNumber);
	}

	public boolean check(String string) {
		Pattern pattern = Pattern.compile(EXPRESSION);
		Matcher matcher = pattern.matcher(string);
		boolean isNaturalNumber = matcher.matches();
		return isNaturalNumber;
	}
	
}
