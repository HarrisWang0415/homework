public class TestRunnableLambda {

	private void TestRunnable() {
		//Anonymous Runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous Runnable");
			}
		};

		//Lambda Runnable
		Runnable r2 = () -> System.out.println("Lambda Runnable");

		r1.run();
		r2.run();
	}

	public static void main(String[] args) {
		TestRunnableLambda test = new TestRunnableLambda();
		test.TestRunnable();
	}
}