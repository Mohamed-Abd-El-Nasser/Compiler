package Test;

public class Test2 {
    public static void main(String[] args) {
        int x=1;
        for(int i = 0 ; i<5;i++){

            for(int j = 0 ; j<5;j++){
                for(int k = 0 ; k<5;k++){
                    for(int l = 0 ; l<5;l++){
                        System.out.println("for loop block");
                        if(x==1){
                            System.out.println("If Block ");
                        }else {
                            System.out.println("Else Block ");
                        }
                    }
                }
            }

        }
        for(int j = 0 ; j<5;j++)
            for(int t = 0 ; t<5;t++)
                if(x>0)
                    System.out.println("nested operations");
        if (x==0)
            System.out.println("If Block ");
        if (x==1) {
            System.out.println("If Block");

        }
        else {
            if (x>=0)
                System.out.println("If Block");
            System.out.println("ELSE Block");
        }
    }
}
