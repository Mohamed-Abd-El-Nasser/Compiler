package Test;
import java.io.FileWriter;
public class genCodeTest1{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        int y=2;
        if (x>0){
            
			System.out.println("1\n");
			fileWriter.append("1\n");
if(x==2){
                
			System.out.println("2\n");
			fileWriter.append("2\n");
System.out.println("IF Block");
		}
            else
                if (y==2){
                    
			System.out.println("4\n");
			fileWriter.append("4\n");
System.out.println("IF Block");
		}
		}
        if (x==1) {
			System.out.println("5\n");
			fileWriter.append("5\n");

            if (y==1){
                
			System.out.println("6\n");
			fileWriter.append("6\n");
System.out.println("IF Block");
		}
            else{
                
			System.out.println("7\n");
			fileWriter.append("7\n");
System.out.println("ELSE Block");
		}
        }
        else {
			System.out.println("8\n");
			fileWriter.append("8\n");

            if (x>=0){
                
			System.out.println("9\n");
			fileWriter.append("9\n");
System.out.println("IF Block");
		}
            System.out.println("ELSE Block");
        }
    	fileWriter.close();
	}
}