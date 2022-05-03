package Test;
public class Test1 {
    public static void main(String[] args) throws Exception{
        int x=1;
        int y=2;
        if (x>0)
            if(x==2)
                System.out.println("IF Block");
            else
                if (y==2)
                    System.out.println("IF Block");
        if (x==1) {
            if (y==1)
                System.out.println("IF Block");
            else
                System.out.println("ELSE Block");
        }
        else {
            if (x>=0)
                System.out.println("IF Block");
            System.out.println("ELSE Block");
        }
    }
}