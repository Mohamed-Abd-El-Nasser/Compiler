package Test;
public class Test3 {
    public static void main(String[] args) throws Exception{
        int i = 0;
        int x = 4 ;
        while (i < 5) {
            System.out.println(i);
            for(int j = 0;j<5;j++)
                System.out.println("test");

            i++;
        }
        while (x< 5)
            if(x<5)
              System.out.println(i);
            else {
                if (x< 5)
                    System.out.println(i);
            }
    }
}