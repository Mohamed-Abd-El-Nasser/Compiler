package Test;
public class Test1 {
    public static void main(String[] args) throws Exception{
        int x=1;
        int y=2;
        if (x>0) {
            if (x == 2)
                System.out.println("IF Block");
        }
        else
                if (y==2)
                    System.out.println("IF Block");
        switch(x) {
            case 5:
                System.out.println("This is a 5");
                break;
            case 1:
                System.out.println("This is a 10");
                break;
        }
        for(int i = 0 ; i<5;i++) {
            for (int j = 0; j < 5; j++)
                if (x > 0)
                    System.out.println("If operations");
                else {
                    System.out.println("Else block");
                }
        }
        int z = 0;
        while (z < 5) {
            if(y==5)
                System.out.println("While loop");
            z++;
        }
    }
}