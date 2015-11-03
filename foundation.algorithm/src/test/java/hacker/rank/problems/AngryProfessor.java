package hacker.rank.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class AngryProfessor {

	private static class AngryProfessorClass {
		private int lateCount = 0;
		private int attendedStudents;
		private final int numOfStudents, onTimeStudentsLimit;
		private boolean isCanceled = false;
		
		public AngryProfessorClass(int numOfStudents, int onTimeStudentsLimit) {
			this.numOfStudents = numOfStudents;
			this.onTimeStudentsLimit = onTimeStudentsLimit;
		}
		
		public boolean attend(int i) {
			if(isCanceled()){
				return false;
			}
			if(isFull()){
				return false;
			}
			if(isLate(i)){
				++lateCount;
			}
			doCancelOrProceedClass();
			return true;
		}

		private boolean isFull() {
			return numOfStudents < ++attendedStudents;
		}

		private void doCancelOrProceedClass() {
			if(isEveryoneInClass()){
				if(numOfStudents - lateCount < onTimeStudentsLimit){
					doCancelClass();
				}else{
					doProceedClass();
				}
			}
		}

		private void doProceedClass() {
			System.out.println("NO");
		}

		private boolean isEveryoneInClass() {
			return numOfStudents == attendedStudents;
		}

		private boolean isLate(int i) {
			return i > 0;
		}

		private void doCancelClass() {
			System.out.println("YES");
			this.isCanceled = true;
		}

		boolean isCanceled(){
			return this.isCanceled;
		}
	}

	@Test
	public void test_(){
		int numOfStudents = 4, onTimeStudentsLimit = 3;
		
		AngryProfessorClass clas = new AngryProfessorClass(numOfStudents, onTimeStudentsLimit);
		boolean isAttended = false; 
		isAttended = clas.attend(-1);
		assertTrue(isAttended);
		isAttended = clas.attend(-3);
		assertTrue(isAttended);
		isAttended = clas.attend(4);
		assertTrue(isAttended);
		isAttended = clas.attend(2);
		assertTrue(isAttended);
		
		assertTrue(clas.isCanceled());
		
		isAttended = clas.attend(4);
		assertFalse(isAttended);
		
		
		numOfStudents = 4;
		onTimeStudentsLimit = 2;
		clas = new AngryProfessorClass(numOfStudents, onTimeStudentsLimit);
		isAttended = clas.attend(0);
		assertTrue(isAttended);
		isAttended = clas.attend(-1);
		assertTrue(isAttended);
		isAttended = clas.attend(2);
		assertTrue(isAttended);
		isAttended = clas.attend(1);
		assertTrue(isAttended);
		
		assertFalse(clas.isCanceled());
		
		isAttended = clas.attend(4);
		assertFalse(isAttended);
		
		
		/*
		10 10
		-32 -3 -70 8 -40 -96 -18 -46 -21 -79
		 */
		numOfStudents = 10;
		onTimeStudentsLimit = 10;
		clas = new AngryProfessorClass(numOfStudents, onTimeStudentsLimit);
		isAttended = clas.attend(-32);
		isAttended = clas.attend(-3);
		isAttended = clas.attend(-70);
		isAttended = clas.attend(8);
		isAttended = clas.attend(-40);
		isAttended = clas.attend(-96);
		isAttended = clas.attend(-18);
		isAttended = clas.attend(-46);
		isAttended = clas.attend(-21);
		isAttended = clas.attend(-79);
		
		/*
		10 7
		26 94 -95 34 67 -97 17 52 1 86 
		 */
		
		numOfStudents = 10;
		onTimeStudentsLimit = 7;
		clas = new AngryProfessorClass(numOfStudents, onTimeStudentsLimit);
		isAttended = clas.attend(26); 
		 isAttended = clas.attend(94); 
		 isAttended = clas.attend(-95); 
		 isAttended = clas.attend(34); 
		 isAttended = clas.attend(67); 
		 isAttended = clas.attend(-97); 
		 isAttended = clas.attend(17); 
		 isAttended = clas.attend(52); 
		 isAttended = clas.attend(1); 
		 isAttended = clas.attend(86); 
		
		assertTrue(clas.isCanceled());
	}
	
	 public static void main(String[] args) throws FileNotFoundException {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
			try(Scanner in = new Scanner(new FileInputStream(new File(new ClasspathResourceFinder().findResource("hacker/rank/problems/testcases/angry_professor_input2.txt").toURI())));){
				
		        int testCaseCount = in.nextInt();
		        for(int i = 0; i < testCaseCount; i++){
		            int numOfStudents = in.nextInt();
		            int onTimeStudentsLimit = in.nextInt();
		            AngryProfessorClass clas = new AngryProfessorClass(numOfStudents, onTimeStudentsLimit);
		            for(int j = 0; j < numOfStudents; j++){
		            	int attendValue = in.nextInt();
		            	clas.attend(attendValue);
		            }
		            
		        }
			}
	    }
	    
}
