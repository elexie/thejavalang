package classesAndObjects;

import java.util.Scanner;

/**
 * An office login simulation to demonstrate how Local Classes work
 * 
 * @author Elexie
 *
 */
public class LocalClasses {
	private Object login[][] = { { "Anette", 123 }, { "Alex", 345 },
			{ "Robery", 567 }, { "David", 789 }, { "Jeremy", 321 },
			{ "Stephanie", 453 }, { "Christopher", 765 } };

	public static void main(String[] args) {
		LocalClasses lc = new LocalClasses();

		System.out.println("Welcome to Local Class Systems Inc. \u263A");
		Scanner s = new Scanner(System.in);
		int x = -1; // for validating the username
		int y = -1;// for validatint the password
		String line = "";
		String userName = "";

		while (y != 1) {
			System.out.println("username:");
			line = s.nextLine().trim();
			x = validateUserName(line);
			// valid username
			if (x == 1) {
				userName = line;
				System.out.println("password: ");
				line = s.nextLine();
				y = lc.validatePassWord(userName, line);
				// valid password
				if (y == 1) {
					System.out.println("welcome.");
					s.close();
				}
				// invalid password
				else {
					System.out.println("invalid password.try again.\n");
					while (y != 1) {
						System.out.println("password: ");
						line = s.nextLine().trim();
						y = lc.validatePassWord(userName, line);
						if (y == 1) {
							System.out.println("welcome");
						}
					}
				}
			}
			// invalid username
			else {
				System.out.println("invalid username.\n");
			}

		}
		s.close();
	}

	/**
	 * prints the name of the parameter via a method from the local class
	 * 
	 * @param name
	 */
	static int validateUserName(String name) {
		/**
		 * a local class that validates the user name
		 * 
		 * @author Elexie
		 *
		 */
		// StaticLocalClass sc = new StaticLocalClass(); illegal
		/**
		 * ^ illegal because the class has not been delcared
		 */
		final int validName = 1; // static local classes may only access
									// enclosing class variables that are final
		final int invalidName = -1;

		class StaticLocalClass {
			// String s=users[0]="hi"; generates an error
			/**
			 * ^remember that a local class defined within a static method
			 * behaves like a static nested class, and thus does not have access
			 * to members of the enclosing class
			 */
			/**
			 * 
			 * @param name
			 * @return 1 if the name is found, -1 otherwise
			 */

			LocalClasses lc = new LocalClasses();// an object of the
													// enclosing class is
													// required
													// since the method is
													// static

			int findUserName(String name) {
				int length = lc.login.length;

				Object getUsers[][] = lc.login;
				for (int x = 0; x < length; x++) {
					if (name.equalsIgnoreCase("" + getUsers[x][0])) {
						return validName; // legal because validName was
											// declared final
					}
				}
				return invalidName;// legal because validName was declared final
			}
		}
		StaticLocalClass sc = new StaticLocalClass();
		return sc.findUserName(name);
	}

	int validatePassWord(String name, String password) {
		/**
		 * a local class that validates the user's password
		 * 
		 * @author Elexie
		 *
		 */
		final int valid = 1;
		final int invalid = -1;
		class NonStaticLocalClass {
			// String aName=users[0]; //legal, unlike the class defined within
			// the static method
			/**
			 * ^remember that a local class defined within a non-static method
			 * behaves like an inner class, and thus has access to members of
			 * the enclosing class
			 */

			// LocalClasses lc = new LocalClasses();
			/**
			 * ^ no enclosing class object needed. A non-static nested class has
			 * complete access to all the members of its enclosing class
			 */

			/**
			 * 
			 * @param password
			 * @return 1 if the password is valid, 0 otherwise
			 */
			int findPassword(String password) {
				int length = login.length;
				for (int x = 0; x < length; x++) {
					if (name.equalsIgnoreCase("" + login[x][0])
							&& Integer.valueOf(password).equals(login[x][1])) {
						return valid;
					}
				}
				return invalid;
			}
		}
		NonStaticLocalClass nc = new NonStaticLocalClass();
		return nc.findPassword(password);
	}

}
