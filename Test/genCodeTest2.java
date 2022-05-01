package Test;
import java.io.FileWriter;
public class genCodeTest2{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        for(int i = 0 ; i<5;i++){
			System.out.println("For Block number: 1 at line number 5\n");
			fileWriter.append("For Block number: 1 at line number 5\n");


            for(int j = 0 ; j<5;j++){
			System.out.println("For Block number: 2 at line number 7\n");
			fileWriter.append("For Block number: 2 at line number 7\n");

                for(int k = 0 ; k<5;k++){
			System.out.println("For Block number: 3 at line number 8\n");
			fileWriter.append("For Block number: 3 at line number 8\n");

                    for(int l = 0 ; l<6;l++){
			System.out.println("For Block number: 4 at line number 9\n");
			fileWriter.append("For Block number: 4 at line number 9\n");

                        System.out.println("for loop block");
                        if(x==1){
			System.out.println("IF Block number: 1 at line number 11\n");
			fileWriter.append("IF Block number: 1 at line number 11\n");

                            System.out.println("If Block ");
                        }else {
			System.out.println("ELSE Block number: 1 at line number 13\n");
			fileWriter.append("ELSE Block number: 1 at line number 13\n");

                            System.out.println("Else Block ");
                        }
                    
		break;}
                
		break;}
            
		break;}

        
		break;}
        for(int j = 0 ; j<5;j++){
            
			System.out.println("For Block number: 5 at line number 21\n");
			fileWriter.append("For Block number: 5 at line number 21\n");
for(int t = 0 ; t<5;t++){
                
			System.out.println("For Block number: 6 at line number 22\n");
			fileWriter.append("For Block number: 6 at line number 22\n");
if(x>0){
                    
			System.out.println("IF Block number: 2 at line number 23\n");
			fileWriter.append("IF Block number: 2 at line number 23\n");
System.out.println("nested operations");
		}
		break;
		}
		break;
		}
        if (x==0){
            
			System.out.println("IF Block number: 3 at line number 25\n");
			fileWriter.append("IF Block number: 3 at line number 25\n");
System.out.println("If Block ");
		}
        if (x==1) {
			System.out.println("IF Block number: 4 at line number 27\n");
			fileWriter.append("IF Block number: 4 at line number 27\n");

            System.out.println("If Block");

        }
        else {
			System.out.println("ELSE Block number: 2 at line number 31\n");
			fileWriter.append("ELSE Block number: 2 at line number 31\n");

            if (x>=0){
                
			System.out.println("IF Block number: 5 at line number 32\n");
			fileWriter.append("IF Block number: 5 at line number 32\n");
System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    	fileWriter.close();
	}
}