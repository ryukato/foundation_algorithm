package gcd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GcdFinder {
	@Test
	public void test_(){
		final int m = 1769, n = 551;
		int gcd = findGcd(m, n);
		assertEquals(29, gcd);
	}

	private int findGcd(int m, int n) {
		int a = 0, b1 = 0, c = m, d = n, a1 = 1, b =1;
		int q = 0, r = 0;
		
		while((r = c % d) != 0){
			q = (int)(c /d);
			c = d;
			d = r;
			int t = a1;
			a1 = a;
			a = t - q * a;
			t = b1;
			b1 = b;
			b = t - q * b;
			
			assert(c == q * d + r);
			assert(d == a * m + b * n);
			assert(c == a1 * m + b1 * n);
			
		}
		assert(c == a1 * m + b1 * n);
		assert(d == a * m + b * n);
		return d;
	}
}
