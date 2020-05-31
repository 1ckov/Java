package ClassesThatNest;

import java.io.Serializable;

public class SimpleNesting {

	private int k = 12;

	private class A { // You can have multiple nested classes within each other.
		public class B {
			protected class C {
				class G { // Visibility doesn't play a role it can be from package to private.
					private int kPrivate = k; // they can also use private attributes from the classes surrounding them;
				}

			}
		}
	}

	class D { // Also multiple in the same class.
	}

	class F implements Serializable { // They can implement Anything.

		/**
		 * 
		 */
		private static final long serialVersionUID = -7680141171121755057L;

	}

	interface I<T> extends Comparable<T> { // Interfaces are also an option.

	}

	class Extender extends D { // They can extend classes from the same class.

	}

	enum E { // Enumerations are also an option.
		K1, K2;
	}

}
