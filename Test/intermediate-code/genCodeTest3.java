package Test;
import java.io.FileWriter;
public class genCodeTest3{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int i = 0;
        int x = 4 ;
        while (i < 5) {
			System.out.println("1\n");
			fileWriter.append("1\n");

            System.out.println(i);
            for(int j = 0;j<5;j++){
                
			System.out.println("2\n");
			fileWriter.append("2\n");
System.out.println("test");
		break;
		}

            i++;
        
		break;}
        while (x< 5){
            
			System.out.println("4\n");
			fileWriter.append("4\n");
if(x<5){
              
			System.out.println("5\n");
			fileWriter.append("5\n");
System.out.println(i);
		}
            else {
			System.out.println("6\n");
			fileWriter.append("6\n");

                if (x< 5){
                    
			System.out.println("7\n");
			fileWriter.append("7\n");
System.out.println(i);
		}
            }
		break;
		}
    	fileWriter.close();
	}
}