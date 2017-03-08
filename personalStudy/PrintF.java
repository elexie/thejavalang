package personalStudy;
/**
 * This clss is used to practice the Java
 * printF() function
 * @author Elexie
 *
 */
//http://alvinalexander.com/programming/printf-format-cheat-sheet
//http://www.homeandlearn.co.uk/java/java_formatted_strings.html
public class PrintF {

	public static void main(String[] args) {
		/*	
		%d	decimal (integer) number (base 10)
		%e	exponential floating-point number
		%f	floating-point number
		%o	octal number (base 8)
		%s	a string of characters
		%x	number in hexadecimal (base 16)
		%%	print a percent sign
		%n 	new line
		\%	print a percent sign
	*/
		/*
		 * A printF command is composed of two parts:
		 *  (1) a string that contains format specifiers, 
		 *  and (2) a comma separated list of content to 
		 *  replace the format specifiers.
		 */
	//basic printf statements
	String name="Ishmael";
	System.out.printf("Call me %s%n",name);
	
	char c='A';
	System.out.printf("%c a wise man once said%n",c);
	
	float f=(float)(Math.pow(10,10));
	System.out.printf("10^10 is %f%n",f);

	int i=64;
	System.out.printf("Most modern computers have a %d-bit processor%n",i);
	
	//using multiple format specifiers
	/**
	 * printf reads the format specifiers and the arguments 
	 * consecutively. If there are more arguments than speficiers,
	 * the JVM will return a java..util.MissingFormatArgumentException
	 */
	System.out.printf("%n=====Using multiple format specifiers=====%n%n");
	double totalDead=61*Math.pow(10,6);
	String war="World War 2";
	int start=1939;
	int end=1945;
	System.out.printf("A total of %f people died in %s%n",totalDead,war);
	System.out.printf("%s began in %d and ended in %d%n",war,start,end);
	/*
	 * System.out.printf("%s began in %d and ended in %d %d %s %f",war,start,end);
	 * ^MissingFormatException 
	 */
	
	//Formatting with spaces
	/**
	 * %-15s tells the jvm to left justify the text
	 * %15s tells the jvm to right justify the text
	 * 
	 * The numeric value (15 in this case) determines
	 * the amount of spacing
	 */
	System.out.println("\n=====Formatting with spaces=====\n");
	System.out.printf("%-15s%15s%n","Country","GDP(in US Millions)");
	Object[][] top5=
	{
		{"USA",15076},
		{"China",11300},
		{"Japan",4444},
		{"India",4420},
		{"Germany",3114}
	};
	for(int x=0;x<top5.length;x++){
		System.out.printf("%-15s%15s\n",top5[x][0],top5[x][1]);
	}
	
	//Integer Formatting
	/**
	 * %4d: print an int containing 4 digits.
	 * if the integer contains less than 4 
	 * digits, the compiler add extra spaces
	 * 
	 * %05d: given an int i=1234, prints an int 
	 * with 1 leading zero since there are 4
	 * digits in the integer
	 * 
	 * %08d: given an int i=1234, prints an int
	 * with 4 leading zeros since there are 4
	 * digits in the integer
	 * 
	 * %010d: given an int i=1234, prints an int
	 * with 6 leading zeros since there are 4
	 * digits in the integer
	 * 
	 * %10d: given an int i=1234, prints an int
	 * with 6 trailing white spaces since there 
	 * are 4 digits in the integer
	 */
	System.out.printf("%n=====Integer Formatting=====%n");
	i=1234;
	System.out.printf("%n%4d",i);
	System.out.printf("%n%08d",i);
	System.out.printf("%n%010d",i);
	System.out.printf("%n%10d",i);

	//misc
	/*
	 * \t tab
	 * \n new line
	 */
	System.out.printf("\n\n=====Miscellaneous=====");
	System.out.println("\nHello\t\tworld");
	}

}
