import java.io.File;
import java.util.Scanner;

public class ReadFile {

    int[][] intMatrix = null;

    public int[][] ArrayMaker(String filePath){
        try {
            int RowCount = 0;
            //  Read File
            System.out.print("filePath is : " + filePath);
            Scanner input = new Scanner(System.in);
            File file = new File(filePath);
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println("new line is: \t\t" + line);
                //  Convert String to integer array for each row
                int[] numArray = new int[line.length()];
                for (int i = 0; i < line.length(); i++){
                    numArray[i] = line.charAt(i) - '0';
                }
                intMatrix[RowCount] = numArray;
                RowCount = RowCount + 1;
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return intMatrix;
    }
}