import java.util.Arrays;

public class inOrder{




    public static void main(String[] args){

        int[][] numbers = {{1,2,3,4}, {9,5,8,74}, {78, 100,500,2315}, {0, 2,3,5}};

        int sum = 0;
        

        for (int i=0; i<numbers.length; i++){

            // System.out.println(Arrays.toString(numbers[i]));
            // System.out.println();

        for (int j=0; j<numbers[i].length; j++){

            int x = numbers[i][j];
            System.out.print(x+" ");

        }
         

    }
    System.out.print("\nThe total: " +sum);

}
        




}