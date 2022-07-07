import java.util.Scanner;
import java.io.*;




public class anotherInput{


    public static void main(String[] args)throws IOException{

        String fileName = "welcome.txt";
        FileOutputStream file = new FileOutputStream(fileName);

        String message = "Welcome";

        file.write(message.getBytes());
        file.close();







    }




}