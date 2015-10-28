package hacker.rank.problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class PlusMinus {
	@Test
	public void test_(){
		float t = 6.00f;
		int[] source = new int[]{-4, 3, -9, 0, 4, 1};
		float positiveNumberCount = 0.00f;
		float negativeNumberCount = 0.00f;
		float zeroCount = 0.00f;
		for(int i = 0; i < t; i++){
			int number = source[i];
			if(number > 0){
				positiveNumberCount++;
			}else if(number < 0){
				negativeNumberCount++;
			}else if(number == 0){
				zeroCount++;
			}
		}
		
		System.out.println(new Fraction(positiveNumberCount, t).evaluate(3));
		System.out.println(new Fraction(negativeNumberCount, t).evaluate(3));
		System.out.println(new Fraction(zeroCount, t).evaluate(3));
	}
	
	private static class Fraction{
		private final double numerator;
		private final double denominator;
		
		public Fraction(double numerator, double denominator) {
			super();
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		public String evaluate(int scale){
			final BigDecimal b = new BigDecimal((numerator / denominator)).setScale(scale, RoundingMode.HALF_EVEN);
			return b.toString();
		}
		
	}
}
