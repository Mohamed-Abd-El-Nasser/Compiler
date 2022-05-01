package Test;

import java.io.FileWriter;

public class genCodeTest3 {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("Test/executionOutput.txt");
        int i = 0;
        while (i < 5) {
            System.out.println("1\n");
            fileWriter.append("1\n");

            System.out.println(i);
            for (int j = 0; j < 5; j++) {

                System.out.println("2\n");
                fileWriter.append("2\n");
                System.out.println("test");
                break;
            }

            i++;

            break;
        }
        while (i < 5) {

            System.out.println("3\n");
            fileWriter.append("3\n");
            if (i < 5) {

                System.out.println("4\n");
                fileWriter.append("4\n");
                System.out.println(i);
            } else {
                System.out.println("5\n");
                fileWriter.append("5\n");

                if (i < 1) {

                    System.out.println("6\n");
                    fileWriter.append("6\n");
                    System.out.println(i);
                }
            }
            break;
        }
        fileWriter.close();
    }
}