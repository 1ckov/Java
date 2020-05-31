package ProblemsWithInheritance;

public interface MansBestFriend {
	
	public void loveHuman();
	
	public default void ownerComesHome() {
		System.out.println("Wiggle tale");
	}

}
