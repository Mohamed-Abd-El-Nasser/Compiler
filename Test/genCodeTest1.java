package Test;
import java.io.FileWriter;
public class genCodeTest1{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        if (x>=0){
            
			System.out.println("1\n");
			fileWriter.append("1\n");
if(x==2){
            
			System.out.println("2\n");
			fileWriter.append("2\n");
System.out.println("If Block");
		}
		}
        if (x==1) {
			System.out.println("3\n");
			fileWriter.append("3\n");

            System.out.println("If Block");
        }
        else {
			System.out.println("4\n");
			fileWriter.append("4\n");

            if (x>=0){
                
			System.out.println("5\n");
			fileWriter.append("5\n");
System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    	fileWriter.close();
	}
}