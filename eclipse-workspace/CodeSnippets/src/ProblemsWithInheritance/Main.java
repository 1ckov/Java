package ProblemsWithInheritance;

public class Main {
	
	public static void main(String[] args) {
		Object dogO = new Dog();
		Animal dogA = new Dog();
		Feeline dogA2 = new Dog();
		MansBestFriend dogI = new Dog();
		Dog dogD = new Dog();
		Cat cat = new Cat();
		
		Animal[] animals = new Animal[6];
		animals[0] = cat;
		animals[1] = dogA; // no Problems cause dogA has a static type Animal which is a superclass of dog
		animals[2] = dogA2; // same except its
		animals[3] = (Dog)dogO; // it needs a cast cause its static type is object and it doesn't know the method makeSound otherwise it works properly
		animals[4] = dogD; // its a dog Statically and dynamically
		animals[5] = (Dog)dogI; // thru a cast it can also be turned into dog
		for(Animal a : animals) {
			a.makeSound();
		}
		
		MansBestFriend[] mbf = new MansBestFriend[5];
		mbf[0] = dogI; //not a problem
		mbf[1] = (Dog) dogA; //needs a cast cause it doesnt impliment the interface
		mbf[2] = (Dog) dogA2;//needs a cast cause it doesnt impliment the interface
		mbf[3] = (Dog) dogO;//needs a cast cause it doesnt impliment the interface
		mbf[4] = dogD; ///also not a problem cause it implements the interface, meaning knows about its methods;
		
		for(MansBestFriend b : mbf) {
			b.loveHuman();
			b.ownerComesHome();
		}
		
	}
	
	
}
