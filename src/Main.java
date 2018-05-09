import com.sun.xml.internal.xsom.XSWildcard;
import edu.princeton.cs.algs4.UF;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){


        ArrayList arrList;
        ArrayList distArrList = new ArrayList();
        int matrixWidth;
        ReadFile fileGetter = new ReadFile();
//        arrList = fileGetter.ArrayMaker("/Users/shymacbook/Documents/BC/cs401_algo/hw02/cs401_UF_drainage/File-1.txt");
        arrList = fileGetter.ArrayMaker("../cs401_UF_drainage/File-1.txt");
        //  Get width of square matrix array representation
        matrixWidth = (int)Math.sqrt(arrList.size());
        int arrSize = arrList.size();

        //  make a Distinct array list for the unions
        for (int x = 0; x < arrSize; x++){
            distArrList.add(x+1);
        }

        System.out.println("row size is: " + matrixWidth);
        System.out.println("array is: " + arrList);
        System.out.println("distinct arr list is: " + distArrList);

        int top = 0;
        int bottom = arrSize + 1;
        int setSize = arrList.size() + 2;

        UF soil = new UF(setSize);

        //  Union 'top' with top row of matrix
        for (int i = 0; i < matrixWidth; i++){
            soil.union(top, (Integer) distArrList.get(i));
        }
        //  Union 'bottom' with bottom row of matrix
        for (int j = (arrSize - 1); j > (arrSize - 1 - matrixWidth); j--){
            soil.union(bottom, (Integer) distArrList.get(j));
        }

        //  Union the rest of the 1's inside the soil matrix
        //      iterate up to (size - 1) to ignore the final bottom right cell
        for (int k = 0; k < arrSize -1; k++){
            //  if right edge
            if(((k+1) % matrixWidth) == 0){
                // TODO: ask Fatma why this unionDOWN() function failed here?
//                unionDown(arrList, distArrList, k, soil);
                //      Union DOWN--------------------------------extracting this into function FAILED
                if (arrList.get(k).equals(arrList.get(k + matrixWidth))){
                    //  union the corresponding elements in array 2
                    soil.union((int)distArrList.get(k), (int)distArrList.get(k + matrixWidth));
                }

            }
            //  if bottom
            else if (k > (arrSize - (matrixWidth + 1)))
            {
                //      Uniont RIGHT--------------------------------extracting this into function FAILED
                if (arrList.get(k).equals(arrList.get(k + 1))) {
                    //  union the corresponding elements in array 2
                    soil.union((int) distArrList.get(k), (int) distArrList.get(k + 1));
                }
            }
            //  if neither
            else{
                //      Uniont RIGHT--------------------------------extracting this into function FAILED
                if (arrList.get(k).equals(arrList.get(k + 1))){
                    //  union the corresponding elements in array 2
                    soil.union((int)distArrList.get(k), (int)distArrList.get(k + 1));
                }
                //      Uniont RIGHT--------------------------------extracting this into function FAILED
            }


        }


        System.out.println("\nchecking for connection now...");

        //  Check if top is connected with bottom
        if (soil.connected(top, bottom)){
            System.out.println("\nAllows water to drain");
        }
        else {
            System.out.println("\nDon’t allow water to drain");
        }



    }

    // TODO: ask Fatma why these unionDown() and unionRight() functions failed?
    //  Define UNION with RIGHT method--------------------------------extracting this into function FAILED
    public void unionRight(ArrayList arr1, ArrayList arr2, int index, UF set){
        //  if elements match in array 1
        if (arr1.get(index).equals(arr1.get(index + 1))){
            //  union the corresponding elements in array 2
            set.union((int)arr2.get(index), (int)arr2.get(index + 1));
        }
    }
    //  Define UNION with BELOW method--------------------------------extracting this into function FAILED
    public void unionDown(ArrayList arr1, ArrayList arr2, int index, UF set, int cols){
        //  if elements match in array 1
        if (arr1.get(index).equals(arr1.get(index + cols))){
            //  union the corresponding elements in array 2
            set.union((int)arr2.get(index), (int)arr2.get(index + cols));
        }
    }


}
