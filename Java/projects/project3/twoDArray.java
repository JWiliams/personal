import java.util.Arrays;

public class twoDArray{



    public static void main(String[] args){

        int[][] numbers = {{1,2,3,4}, {9,5,8,74}, {78, 100,500,2315}, {0, 2,3,5}};

        int sum = 0;
        

        for (int i=0; i<numbers.length; i++){

            System.out.println(numbers[i]);
            
            System.out.println();


            for (int j=0; j< numbers[i].length;j++){

                int number = numbers[i][j];

                System.out.print(numbers[i][j]+" ");
                sum = sum + number;
                

            }

            


    }
    System.out.print("\nThe total: " +sum);

}
        




}