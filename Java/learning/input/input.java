import java.util.Scanner;
import java.io.*;

public class input{


    public static void main(String[] args) throws IOException{

        // This code will take your name and write it to a file
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.next();

        FileOutputStream output = new FileOutputStream("yourFile.txt");

        String yourMessage = name; // Written message



        // creating file and closing fileOutputStream object
        output.write(yourMessage.getBytes());
        output.close();
        


        
    }




}