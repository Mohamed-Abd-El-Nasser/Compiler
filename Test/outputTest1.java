package Test;

public class outputTest1 {
    public static void main(String[] args) {
        int x=1;
        if (x>=0){
            System.out.println("IF Block number: 1 at line number 6");
			System.out.println("If Block");
		}
        if (x==1) {
			System.out.println("IF Block number: 2 at line number 8");
            System.out.println("If Block");
        }
        else {
		System.out.println("ELSE Block number: 1 at line number 11");
            if (x>=0){
                System.out.println("IF Block number: 3 at line number 12");
			System.out.println("If Block");
		}
            System.out.println("ELSE Block");
        }
    }
}
