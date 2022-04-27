package Test;

public class outputTest3 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
			System.out.println("While Block number: 1 at line number 6");
            System.out.println(i);
            for(int j = 0;j<5;j++){
                System.out.println("For Block number: 1 at line number 8");
			System.out.println("test");
		}

            i++;
        }
        while (i < 5){
            System.out.println("While Block number: 2 at line number 13");
			if(i<5){
              System.out.println("IF Block number: 1 at line number 14");
			System.out.println(i);
		}
            else {
		System.out.println("ELSE Block number: 1 at line number 16");
                if (i < 1){
                    System.out.println("IF Block number: 2 at line number 17");
			System.out.println(i);
		}
            }
		}
    }
}
