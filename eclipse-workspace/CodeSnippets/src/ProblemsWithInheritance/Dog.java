package ProblemsWithInheritance;

public class Dog extends Feeline implements MansBestFriend {

	@Override
	public void makeSound() {
		System.out.println("Wof Wof");
	}

	@Override
	public void loveHuman() {
		System.out.println("Fetch Newspaper");
		
	}

}
