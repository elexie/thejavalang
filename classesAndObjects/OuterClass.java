package classesAndObjects;

/**
 * This class demonstrates the difference between Static Nested Classes and
 * Non-Static Nested Classes (or inner classes)
 * 
 * @author Elexie
 *
 */
public class OuterClass {
	private String name = "elexie";
	private static String staticMember = "outer Class static member";

	public String getName() {
		return this.name;
	}

	public static void main(String[] args) {
		System.out.println("\n=====StaticNestedClass=====\n");

		OuterClass.StaticNestedClass staticNestedObj = new OuterClass.StaticNestedClass();
		staticNestedObj.printName();
		staticNestedObj.printStaticField();
		staticNestedObj.shadowing(staticMember);

		System.out.println("\n=====NonStaticNestedClass=====\n");
		OuterClass outerObj = new OuterClass();
		OuterClass.NonStaticNestedClass nonStaticObj = outerObj.new NonStaticNestedClass();
		nonStaticObj.printName();
		nonStaticObj.printStaticField();
		nonStaticObj.shadowing(staticMember);

	}

	public static class StaticNestedClass {

		OuterClass outerObj = new OuterClass();
		static String staticMember = "Static Nested Classes can declare static variables"
				+ "but non-static nested classes may not";

		// 1) access to enclosing members
		/**
		 * static nested classes have no access to members of the enclosing
		 * class
		 */
		public void printName() {
			// getName();:this line of code is illegal
			System.out.println("\n1)"+outerObj.getName());

			/**
			 * ^staticnested classes can only access the members of the
			 * enclosing class via an object reference of the enclosing class
			 */

		}

		// 2) declaring static members
		/**
		 * static nested classes may freely declare static fields (members)
		 */
		public void printStaticField() {
			System.out.println("\n2)"+staticMember);
		}

		// 3) shadowing
		/**
		 * shadowing works the same in non-static nested class as it does in
		 * outer classes. distant variables (such as fields) are be shadowed by
		 * more local variables (such as parameters)
		 * 
		 * @param staticMember
		 */
		public void shadowing(String staticMember) {
			System.out.println("\n3)param: " + staticMember);
			System.out
					.println("static member from class: " + this.staticMember);
		}
	}

	public class NonStaticNestedClass {
		static final String staticMember = "Non-Static Nested Classes cannot "
				+ "\ndeclare static variables, unless the variable"
				+ "\nis declared \'final\' ";

		// 1) access to enclosing members
		/**
		 * non-static nested classes have complete access to members of the
		 * enclosing class, including private members
		 */
		public void printName() {
			System.out.println("\n1)"+name);
		}

		// 2) declaring static members
		/**
		 * static nested classes may not declare static fields (members)
		 */
		public void printStaticField() {
			System.out.println("\n2)"+staticMember);
		}

		// 3) shadowing
		/**
		 * shadowing works the same in non-static nested class as it does in
		 * outer classes. distant variables (such as fields) are be shadowed by
		 * more local variables (such as parameters)
		 * 
		 * @param staticMember
		 */
		public void shadowing(String staticMember) {
			System.out.println("\n3)param: " + staticMember);
			System.out
					.println("static member from class: " + this.staticMember);
		}
	}
}
