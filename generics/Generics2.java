package generics;
/**
 * Generics, Inheritance, and Subtypes
 * Type Inference
 * Wildcards
 * @author Elexie
 *
 */
public class Generics2 {

	public static void main(String[] args) 
	{
	/**
	 * Generics, Inheritance, and Subtypes
	 */
	Generics2 generics2=new Generics2();
	String s="myString";
	Collection c=new Collection();
	Collection<Object> objCollection=new Collection();
	Collection<String> strCollection=new Collection();
	Collection<Number> numrCollection=new Collection();
	
	c.printCollection(new Collection<String>());
	
	
	/**
	 * Type Inference
	 */
	}
	
	/**
	 * This class is used
	 * to illustrate Generics, Inference,
	 * and Subtypes
	 * @author Elexie
	 *
	 * @param <E>
	 */
	public static class Collection<E>{
		
		public void printCollection(Collection<Number> o){
			System.out.println(o.getClass());
		}
		
	}
	
	/**
	 * This class is used to illustrate
	 * Type Inference
	 */
	
	

}
