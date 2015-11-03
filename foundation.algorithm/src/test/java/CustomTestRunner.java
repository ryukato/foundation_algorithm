import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Reference: http://meri-stuff.blogspot.kr/2014/08/junit-dynamic-tests-generation.html
 *
 */
@RunWith(Parameterized.class)
public class CustomTestRunner {
	private final TestCase testcase;
	
	/**
	 * All the specified parameters are injected by JUnit, more specifically Parameterized instance of JUnit.
	 * @param testcase
	 * @param testCaseName
	 */
	public CustomTestRunner(TestCase testcase, String testCaseName){
		this.testcase = testcase;
	}
	
	/**
	 * Actual the test method, which is running test case. 
	 * And this method is iterated as many as number of TestCases returned by generateParameters method.
	 * Additionally, each iteration is identified with test case name of given each TestCase instance.
	 */
	@Test
	public void runAllTestCases() {
		System.out.println(this.testcase.getTestCaseName());
		runTestCase(this.testcase);
	}
	
	private void runTestCase(TestCase testCase){
		TestCaseRunner.run(testCase);
	}
	
	private static class TestCaseRunner{
		private static void run(TestCase testCase){
			System.out.println("TestCaseRunner run test Case: "+ testCase.getTestCaseName());
		}
	}

	/**
	 * The argument-"name="Name: {1}"" is for the name of each test iteration. 
	 * And "Name: {1}" means that the name of each iteration is given by the second element in the Object array
	 * , which is returned by this method.
	 * 
	 * @return
	 */
	@Parameters(name = "TestCase: {1}")
	public static Iterable<Object[]> loadTestCases() {
		String path = getTestCasePath();

		//TestLoading
		Collection<TestCase> testCases = TestCaseLoader.load(path);
		
		//Build test method parameter with testCases
		List<Object[]> parameters = buildParameters(testCases);
		return parameters;
	}

	/**
	 * This method is to read in the path where test cases are. Maybe we can take the test case path a sort of maven option or something else.
	 * To run this with Eclipse, then go to RunAs -> RunConfiguration -> Environment, then add the "testCasePath" variable.
	 * @return
	 */
	private static String getTestCasePath() {
		String path = System.getenv("testCasePath");
		if(path == null || path.isEmpty()){
			path = System.getProperty("testCasePath");
		}
		return path;
	}
	
	private static List<Object[]> buildParameters(Collection<TestCase> testCases) {
		List<Object[]> parameters = new ArrayList<>();
		for(TestCase testCase:testCases){
			parameters.add(new Object[]{testCase, testCase.getTestCaseName()});
		}
		return parameters;
	}

	/**
	 * This Object is to simulate TestCaseLoader of STAF.
	 */
	private static class TestCaseLoader{
		private static List<TestCase> load(String path){
			System.out.println("TestCase scan path: "+ path);
			validatePath(path);
			List<TestCase> testCases = scanTestCases(path);
			return testCases;
		}

		private static List<TestCase> scanTestCases(String path) {
			List<TestCase> testCases = new ArrayList<>();
			testCases.add(new TestCase("tc1"));
			testCases.add(new TestCase("tc2"));
			return testCases;
		}

		private static void validatePath(String path) {
			// TODO do some path validation
		}
	}
	
	/**
	 * This Object is to simulate TestCase of STAF.
	 */
	private static class TestCase {
		private final String testCaseName;

		public TestCase(String testCaseName) {
			super();
			this.testCaseName = testCaseName;
		}

		public String getTestCaseName() {
			return testCaseName;
		}

	}
}
