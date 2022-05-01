package Test;
import java.io.FileWriter;
public class genCodeTest4{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x = 10;
        switch(x) {
            case 5:
			System.out.println("SWITCH Label Block number: 1 at line number 6\n");
			fileWriter.append("SWITCH Label Block number: 1 at line number 6\n");

                System.out.println("This is a 5");
            case 40:
			System.out.println("SWITCH Label Block number: 2 at line number 8\n");
			fileWriter.append("SWITCH Label Block number: 2 at line number 8\n");

                System.out.println("69");
        }
        switch(6) {
            case 7:
			System.out.println("SWITCH Label Block number: 3 at line number 12\n");
			fileWriter.append("SWITCH Label Block number: 3 at line number 12\n");

                System.out.println("This is a 6");
            case 9:
			System.out.println("SWITCH Label Block number: 4 at line number 14\n");
			fileWriter.append("SWITCH Label Block number: 4 at line number 14\n");

                System.out.println("This is a 9");
            default:
			System.out.println("SWITCH Label Block number: 5 at line number 16\n");
			fileWriter.append("SWITCH Label Block number: 5 at line number 16\n");

                System.out.println("default case");
        }
    	fileWriter.close();
	}
}