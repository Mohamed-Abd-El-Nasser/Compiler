package Test;

public class outputTest2 {
    public static void main(String[] args) {
        int x=1;
        for(int i = 0 ; i<5;i++){
			System.out.println("For Block number: 1 at line number 6");

            for(int j = 0 ; j<5;j++){
			System.out.println("For Block number: 2 at line number 8");
                for(int k = 0 ; k<5;k++){
			System.out.println("For Block number: 3 at line number 9");
                    for(int l = 0 ; l<5;l++){
			System.out.println("For Block number: 4 at line number 10");
                        System.out.println("for loop block");
                        if(x==1){
			System.out.println("IF Block number: 1 at line number 12");
                            System.out.println("If Block ");
                        }else {
		System.out.println("ELSE Block number: 1 at line number 14");
                            System.out.println("Else Block ");
                        }
                    }
                }
            }

        }
        for(int j = 0 ; j<5;j++){
            System.out.println("For Block number: 5 at line number 22");
			for(int t = 0 ; t<5;t++){
                System.out.println("For Block number: 6 at line number 23");
			if(x>0){
                    System.out.println("IF Block number: 2 at line number 24");
			System.out.println("nested operations");
		}
		}
		}
        if (x==0){
            System.out.println("IF Block number: 3 at line number 26");
			System.out.println("If Block ");
		}
        if (x==1) {
			System.out.println("IF Block number: 4 at line number 28");
            System.out.println("If Block");

        }
        else {
		System.out.println("ELSE Block number: 2 at line number 32");
            if (x>=0){
                System.out.println("IF Block number: 5 at line number 33");
			System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    }
}
