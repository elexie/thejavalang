package classesAndObjects;
interface Executable{
//	void execute();
	int execute2(int a);
}

interface StringExecutable{
//	void execute();
	int execute2(int a);
}

class Runner{
	public void run(Executable e){
		System.out.println("Executing code block...");
		int value=e.execute2(12);
		System.out.println("Return value is: "+value);
	}
}
public class Lambdas {

	public static void main(String[] args) {
		Runner runner=new Runner();
		runner.run(new Executable(){
			public int execute2(int a){
				System.out.println("Hello there");
				return 7+a;
			}
	
		});
		
	System.out.println("======================");
	runner.run((int a)-> 7+a);
	runner.run(a-> {
		System.out.println("\nrunner.run 2");
		return 7+a;
		});
	}

}
