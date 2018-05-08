
public class Main {

    public static void main(String[] args){
        int[][] matrixFromFile;
        int matrixWidth;
        ReadFile fileGetter = new ReadFile();
        matrixFromFile = fileGetter.ArrayMaker("/Users/shymacbook/Documents/BC/cs401_algo/hw02/cs401_UF_drainage/File-1.txt");

        matrixWidth = matrixFromFile[0].length;
        System.out.println("row size is: " + matrixWidth);

        for (int i = 0; i < matrixWidth; i++){
            for (int j = 0; j < matrixWidth; j++){
                System.out.print(matrixFromFile[i][j]);
            }
            System.out.println("");
        }

    }
}
