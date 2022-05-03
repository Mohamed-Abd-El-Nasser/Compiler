package Test;
public class Test4 {
    public static void main(String[] args) throws Exception{
        int x = 10;
        switch(x) {
            case 5:
                System.out.println("This is a 5");
                break;
            case 10:
                System.out.println("This is a 10");
                break;
        }
        switch(6) {
            case 6:
                System.out.println("This is a 6");
                break;
            case 9:
                System.out.println("This is a 9");
                break;
            default:
                System.out.println("default case");
        }
    }
}