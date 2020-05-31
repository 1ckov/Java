package ProblemsWithInheritance;

public class B extends A{
	
	
	public int k = 32;
	
	public void printB() {
		System.out.println("k = " + k);
	}
	
	
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		b.printA();
		b.printB();
		C c = new C();
		c.printB(b);
	}
}


