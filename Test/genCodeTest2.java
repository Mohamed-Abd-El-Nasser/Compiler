package Test;
import java.io.FileWriter;

public class genCodeTest2 {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/output2.txt");
        int x=1;
        for(int i = 0 ; i<5;i++){
			System.out.println("For Block number: 1 at line number 8\n");
			fileWriter.append("For Block number: 1 at line number 8\n");


            for(int j = 0 ; j<5;j++){
			System.out.println("For Block number: 2 at line number 10\n");
			fileWriter.append("For Block number: 2 at line number 10\n");

                for(int k = 0 ; k<5;k++){
			System.out.println("For Block number: 3 at line number 11\n");
			fileWriter.append("For Block number: 3 at line number 11\n");

                    for(int l = 0 ; l<6;l++){
			System.out.println("For Block number: 4 at line number 12\n");
			fileWriter.append("For Block number: 4 at line number 12\n");

                        System.out.println("for loop block");
                        if(x==1){
			System.out.println("IF Block number: 1 at line number 14\n");
			fileWriter.append("IF Block number: 1 at line number 14\n");

                            System.out.println("If Block ");
                        }else {
			System.out.println("ELSE Block number: 1 at line number 16\n");
			fileWriter.append("ELSE Block number: 1 at line number 16\n");

                            System.out.println("Else Block ");
                        }
                    
		break;}
                
		break;}
            
		break;}

        
		break;}
        for(int j = 0 ; j<5;j++){
            
			System.out.println("For Block number: 5 at line number 24\n");
			fileWriter.append("For Block number: 5 at line number 24\n");
for(int t = 0 ; t<5;t++){
                
			System.out.println("For Block number: 6 at line number 25\n");
			fileWriter.append("For Block number: 6 at line number 25\n");
if(x>0){
                    
			System.out.println("IF Block number: 2 at line number 26\n");
			fileWriter.append("IF Block number: 2 at line number 26\n");
System.out.println("nested operations");
		}
		break;
		}
		break;
		}
        if (x==0){
            
			System.out.println("IF Block number: 3 at line number 28\n");
			fileWriter.append("IF Block number: 3 at line number 28\n");
System.out.println("If Block ");
		}
        if (x==1) {
			System.out.println("IF Block number: 4 at line number 30\n");
			fileWriter.append("IF Block number: 4 at line number 30\n");

            System.out.println("If Block");

        }
        else {
			System.out.println("ELSE Block number: 2 at line number 34\n");
			fileWriter.append("ELSE Block number: 2 at line number 34\n");

            if (x>=0){
                
			System.out.println("IF Block number: 5 at line number 35\n");
			fileWriter.append("IF Block number: 5 at line number 35\n");
System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
        fileWriter.close();
    }
}
