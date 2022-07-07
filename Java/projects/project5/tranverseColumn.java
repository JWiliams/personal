public class tranverseColumn{


    public static void main(String[] args){


        int[][] numbers= {{1,4,7,10}, {2,5,8,11}, {3,6,9,12}};


        for (int o=0; o<numbers[0].length+1; o++){
            int[] row = numbers[o];
            for (int i=0; i<numbers.length; i++){
                System.out.println(numbers[i][o]);

            }

            System.out.print("Dis row - ");
            for (int n=0; n<numbers[o].length;n++){
                
                System.out.print(row[n] + " ");

            }

            
            
            System.out.println();
            System.out.println();
    

        }




    }



    

}