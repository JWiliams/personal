public class Calculator {
  // Simple Calculator app

  public Calculator(){
    
  }

  public int add(int num1, int num2){
    return num1 + num2;
  }

  public int subtract(int num1, int num2){
    return num1 - num2;
  }

  public int multiply(int num1, int num2){
    return num1 * num2;
  }

  public int divide(int num1, int num2){
    return num1 / num2;
  }

  public int modulo(int num1, int num2){
    return num1 % num2;
  }
  public static void main(String[] args) {
    Calculator myCalculator = new Calculator();
    System.out.println(myCalculator.add(5, 7));
    System.out.println(myCalculator.subtract(45, 11));

  }
}