package Test;
import java.io.FileWriter;
public class genCodeTest4{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x = 10;
        switch(x) {
            case 5:
			System.out.println("1\n");
			fileWriter.append("1\n");

                System.out.println("This is a 5");
            case 40:
			System.out.println("2\n");
			fileWriter.append("2\n");

                System.out.println("69");
        }
        switch(6) {
            case 7:
			System.out.println("3\n");
			fileWriter.append("3\n");

                System.out.println("This is a 6");
            case 9:
			System.out.println("4\n");
			fileWriter.append("4\n");

                System.out.println("This is a 9");
            default:
			System.out.println("5\n");
			fileWriter.append("5\n");

                System.out.println("default case");
        }
    	fileWriter.close();
	}
}