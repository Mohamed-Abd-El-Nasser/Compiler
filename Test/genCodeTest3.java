package Test;
import java.io.FileWriter;

public class genCodeTest3 {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/output3.txt");
        int i = 0;
        while (i < 5) {
			System.out.println("While Block number: 1 at line number 8\n");
			fileWriter.append("While Block number: 1 at line number 8\n");

            System.out.println(i);
            for(int j = 0;j<5;j++){
                
			System.out.println("For Block number: 1 at line number 10\n");
			fileWriter.append("For Block number: 1 at line number 10\n");
System.out.println("test");
		}

            i++;
        }
        while (i < 5){
            
			System.out.println("While Block number: 2 at line number 15\n");
			fileWriter.append("While Block number: 2 at line number 15\n");
if(i<5){
              
			System.out.println("IF Block number: 1 at line number 16\n");
			fileWriter.append("IF Block number: 1 at line number 16\n");
System.out.println(i);
		}
            else {
			System.out.println("ELSE Block number: 1 at line number 18\n");
			fileWriter.append("ELSE Block number: 1 at line number 18\n");

                if (i < 1){
                    
			System.out.println("IF Block number: 2 at line number 19\n");
			fileWriter.append("IF Block number: 2 at line number 19\n");
System.out.println(i);
		}
            }
		}
        fileWriter.close();
    }
}
