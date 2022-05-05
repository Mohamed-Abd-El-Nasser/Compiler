package Test;import java.io.FileWriter;
public class genCodeTest2{
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int x=1;
        for(int i = 0 ; i<5;i++){
			System.out.println("1\n");
			fileWriter.append("1\n");


            for(int j = 0 ; j<5;j++){
			System.out.println("2\n");
			fileWriter.append("2\n");

                for(int k = 0 ; k<5;k++){
			System.out.println("3\n");
			fileWriter.append("3\n");

                    for(int l = 0 ; l<6;l++){
			System.out.println("4\n");
			fileWriter.append("4\n");

                        System.out.println("for loop block");
                        if(x==1){
			System.out.println("5\n");
			fileWriter.append("5\n");

                            System.out.println("If Block ");
                        }else {
			System.out.println("6\n");
			fileWriter.append("6\n");

                            System.out.println("Else Block ");
                        }
                    
		break;}
                
		break;}
            
		break;}

        
		break;}
        for(int j = 0 ; j<5;j++){
            
			System.out.println("7\n");
			fileWriter.append("7\n");
for(int t = 0 ; t<5;t++){
                
			System.out.println("8\n");
			fileWriter.append("8\n");
if(x>0){
                    
			System.out.println("9\n");
			fileWriter.append("9\n");
System.out.println("nested operations");
		}
		break;
		}
		break;
		}
        if (x==0){
            
			System.out.println("10\n");
			fileWriter.append("10\n");
System.out.println("If Block ");
		}
        if (x==1) {
			System.out.println("11\n");
			fileWriter.append("11\n");

            System.out.println("If Block");

        }
        else {
			System.out.println("12\n");
			fileWriter.append("12\n");

            if (x>=0){
                
			System.out.println("13\n");
			fileWriter.append("13\n");
System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    	fileWriter.close();
	}
}