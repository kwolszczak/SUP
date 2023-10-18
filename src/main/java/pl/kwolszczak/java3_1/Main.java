package pl.kwolszczak.java3_1;

public class Main {

    public static void main(String[] args) {

        var calc = new Calculator<Integer>();

        // add
        calc.performOperation(2, 3, new Executable<Integer>() {
            @Override
            public Integer execute(Integer a, Integer b) {
                int result = a+b ;
                System.out.printf("a+b = %9d%n",result);
                return result;
            }
        });

        // subtract
        calc.performOperation(2, 3, new Executable<Integer>() {
            @Override
            public Integer execute(Integer a, Integer b) {
                int result = a-b ;
                System.out.printf("a-b = %9d%n",result);
                return result;
            }
        });

       var calcDouble = new Calculator<Double>();

        // multiply , divide
        calcDouble.performOperation(2.0,3.0 , (m,n)->{
            double result = m * n ;
            System.out.printf("a*b = %9.1f%n",result);
            return result;
        });

        // divide
        calcDouble.performOperation(2.0,3.0 , (m,n)->{
            double result = m / n ;
            System.out.printf("a/b = %9.3f%n",result);
            return result;
        });
    }
}
