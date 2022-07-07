// Import statement:
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class PrimeDirective {
  // Add your methods here:
  public boolean isPrime(int number){
    
    if (number<2){
      return false;
    } else if (number==2){
      return true;
    }
  
    for (int i=2; i<number; i++){
      if (number % i == 0) {
        return false;
      }
      
    }return true;
  }

  // only prime method

  public ArrayList<Integer> onlyPrimes(int[] numberss){

    
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int numbeer: numberss){
      int x = 2;
        if (numbeer<2){
      continue;
    } else if (numbeer % x == 0){
      primes.add(numbeer);
    }

    List pprimes = Arrays.asList(primes);
    return pprimes;
    }
  }
  
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
    System.out.println(pd.isPrime(7));
    System.out.println(pd.onlyPrimes(numbers));

  }  

}
