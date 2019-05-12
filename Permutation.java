/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;


class Permutation {

 String All[]=new String[100];
 int cpt=0;
     void combinationUtil(String arr[], String data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            All[cpt]="";
            for (int j=0; j<r; j++)
                //System.out.print(data[j]+" ");
            {
            All[cpt]=All[cpt]+data[j]+"#";
            }
            cpt++;
            //System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    void printCombination(String arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        String data[]=new String[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

}


