package Test;
import java.io.FileWriter;

public class Test1 {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/output1.txt");
        int x=1;
        if (x>=0)
            if(x==2)
            System.out.println("If Block");
        if (x==1) {
            System.out.println("If Block");
        }
        else {
            if (x>=0)
                System.out.println("If Block");
            System.out.println("ELSE Block");
        }
        fileWriter.close();
    }
}
