package Test;
import java.io.FileWriter;
public class genCodeTest3{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int i = 0;
        while (i < 5) {
			System.out.println("While Block number: 1 at line number 5\n");
			fileWriter.append("While Block number: 1 at line number 5\n");

            System.out.println(i);
            for(int j = 0;j<5;j++){
                
			System.out.println("For Block number: 1 at line number 7\n");
			fileWriter.append("For Block number: 1 at line number 7\n");
System.out.println("test");
		break;
		}

            i++;
        
		break;}
        while (i < 5){
            
			System.out.println("While Block number: 2 at line number 12\n");
			fileWriter.append("While Block number: 2 at line number 12\n");
if(i<5){
              
			System.out.println("IF Block number: 1 at line number 13\n");
			fileWriter.append("IF Block number: 1 at line number 13\n");
System.out.println(i);
		}
            else {
			System.out.println("ELSE Block number: 1 at line number 15\n");
			fileWriter.append("ELSE Block number: 1 at line number 15\n");

                if (i < 1){
                    
			System.out.println("IF Block number: 2 at line number 16\n");
			fileWriter.append("IF Block number: 2 at line number 16\n");
System.out.println(i);
		}
            }
		break;
		}
    	fileWriter.close();
	}
}