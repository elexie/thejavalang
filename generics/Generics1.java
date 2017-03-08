package generics;
/**
 * This class covers 5 primary
 * concepts involving Generics:
 * Generic Types
 * Raw Types
 * Generic methods
 * Bounded Type Parameters
 * Generic methods and bounded type parameters
 * @author Elexie Munyeneh
 *
 */
public class Generics1 {

	public static void main(String[] args) {
	

	Generics1 generics=new Generics1();
	
	/**
	 * Generic Types 
	 * Raw Types
	 */
	//A Box that stores an Integer object
	Box<Integer> integerBox=new Box<>();
	integerBox.set(5);
	
	//A Box that stores a Book object
	Book myBook=new Book("The Art of Programming","Donald Knuth");
	Box<Book> bookBox=new Box<>();
	bookBox.set(myBook);

	//A Box that stores a Byte object
	Box<Byte> byteBox=new Box<>();
	byte aByte=-127;
	byteBox.set(aByte);
	
	/**
	 * Generic Methods
	 * Bounded Type Parameters
	 */
	
	NumberOperations no=new NumberOperations();
	Byte[] byteArray={1,2,3};
	Short[] shortArray={3,4,56,};
	Integer[] intArray={0,1,2,3,4,5};
	Long[] longArray={190L,290L,203L};
	Float[] floatArray={99999999f};
	Double[] doubleArray={0.5,1.5,2.5,3.5,4.5,5.5};
		
	System.out.println(no.findAverage(byteArray));
	System.out.println(no.findAverage(shortArray));
	System.out.println(no.findAverage(intArray));
	System.out.println(no.findAverage(doubleArray));

	}
	
	
	/**
	 * This class was created to illustrate
	 * that a Generic in Java can also be a
	 * user-defined class.
	 * @author Elexie
	 *
	 */
	private static class Book{
	private String author;
	private String title;
	public Book(String author, String title){
		this.author=author;
		this.title=title;
	}
	
		public void setAuthor(String author){this.author=author;}
		public void setTitle(String title){this.title=title;}
		public String getAuthor(){return this.author;}
		public String getTitle(){return this.title;}
	}
	
	
	/**
	 * A class that stores 
	 * generic elements of type T.
	 * 
	 * @author Elexie Munyeneh
	 *
	 * @param <T>
	 * any non primitive
	 * data type, or of a class defined
	 * by the user
	 */
	private static class Box<T>{
		private T t;
		
		public void set(T t){this.t=t;}
		public T get(){return this.t;}
		public void print(T t){System.out.println(t);}
		
	}
	
	/**
	 * For
	 * Generic Methods
	 * Bounded Type Parameters
	 * 
	 * @author Elexie Munyeneh
	 *
	 */
	public static class NumberOperations{
		
		/**
		 * a generic method which restricts its 
		 * parameters to only java.lang.Number 
		 * class objects
		 * @param numbers
		 * @return
		 */
		public <A extends Number> double findAverage(A[] numbers){
			
			double average=0;
			for(A a: numbers){
			average+=a.doubleValue();
			}
			return (average)/(numbers.length);
		}
		
		/**
		 * 
		 * @return
		 */
		public <A extends Number> double findSum(A[] numbers){
			double sum=0;
			for(A a: numbers){
			sum+=a.doubleValue();
			}
			return sum;
		}
		
		/**
		 * 
		 * @param numbers
		 * @return
		 */
		public <N extends Number>double findQuotient(N[] numbers){
			double quotient=0;
			for(N a: numbers){
			quotient+=a.doubleValue();
			}
			return quotient;
		}
		
		/**
		 * a method with a bounded parameter
		 * that only allows Integer Objects or
		 * ints as parameters.
		 * Not practical, but illustrates 
		 * the concept
		 * @param digit
		 * @return
		 */
		public <I extends Integer> int decreaseInteger(I digit){
			return digit-1;
		}
		
		/**
		 * this method returns the number of elements
		 * in the array that are less than 'element'
		 * @param array
		 * @param element
		 * @return
		 */
		public static <B extends Number & Comparable<B>> int countGreater(B[] array, B element){
			int count=0;
			for(B b: array){
				if(b.compareTo(element)>1){
					++count;
				}
			}
			return count;
		}
		
		
	}


}
