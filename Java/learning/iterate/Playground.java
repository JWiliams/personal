import java.util.ArrayList;
import java.util.Arrays;

class Playground {

  public ArrayList<String> makeB(ArrayList<String> input) {

        int i = 0;
        while (i < input.size()) {
          String addr = "b";
          String addE = input.get(i);
          String nWord = addE + addr;
          input.set(i, nWord);
          i++;
        }
        return input;
  }

	public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<String>();

    words.add("Gorilla");
    words.add("Salamander");
    words.add("JJ");

    Playground animals = new Playground(); // If I did not want to create a object here...I can just make the method "makeB()" static. :)
    words = animals.makeB(words);
    System.out.println(words);
    
  }

}