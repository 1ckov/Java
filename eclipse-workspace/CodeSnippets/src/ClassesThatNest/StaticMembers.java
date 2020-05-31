package ClassesThatNest;

public class StaticMembers {
	public static class InnerClass{
		@Override
		public String toString() {
			return "I am on the inside";
		}
	}
	public String toString() {
		return "I am on the outside";
	}
	
	public static void main(String[] args) {
		StaticMembers outer = new StaticMembers();
		StaticMembers.InnerClass inner = new StaticMembers.InnerClass();
		System.out.println(outer);
		System.out.println(inner);
	}
}

