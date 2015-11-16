package hacker.rank.problems;

import org.junit.Test;

public class UtopianTree {

	//a(0) = 1; a(n) = if n is even then a(n-1)+1 else 2*a(n-1).
	
	@Test
	public void test_(){
		int cycle = 1;
		int initHeight = 1;
		UtopianTree.grow(initHeight, cycle);
	}

	private static int grow(int initHeight, int cycle) {
		if(cycle < 1){
			return initHeight;
		}
		final int a = 2;
		if(cycle % 2 == 0){
			return a * (cycle-1)+1 ;
		}else{
			return 2* a *(cycle-1);
		}
	}
}
