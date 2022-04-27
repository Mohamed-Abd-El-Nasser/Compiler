package Test;
import java.io.FileWriter;

public class Test4 {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter = new FileWriter("Test/output4.txt");
        int x = 10;
        switch(x) {
            case 5:
                System.out.println("This is a 5");
            case 40:
                System.out.println("69");
        }
        switch(6) {
            case 7:
                System.out.println("This is a 6");
            case 9:
                System.out.println("This is a 9");
            default:
                System.out.println("default case");
        }
        fileWriter.close();
    }
}
