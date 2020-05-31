package ClassesThatNest;

public class PrivateAcces {
	private static int x = 5;
	public static class Inner{
		private static int y = 7;
		private static void inside() {
			y += x;
			System.out.println(y);
			outside2();
			System.out.println(y);
		}
	}
	public static void outside1() {
		Inner.inside();
	}
	public static void outside2() {
		Inner.y = 17;
	}
	
	public static void main(String[] args) {
		PrivateAcces.outside1();
		PrivateAcces.outside1();
	}

}
