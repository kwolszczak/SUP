package pl.kwolszczak.java3_1;

public class Main {

    public static void main(String[] args) {

        var calc = new Calculator<Integer>();
        var calcDouble = new Calculator<Double>();

        Integer one = calc.performOperation(2, 3, new Executable<Integer>() {
            @Override
            public Integer execute(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.printf("a+b = %9d%n", one);

        int two = calc.performOperation(2, 3, new Executable<Integer>() {
            @Override
            public Integer execute(Integer a, Integer b) {
                return a - b;
            }
        });
        System.out.printf("a-b = %9d%n", two);


        double three = calcDouble.performOperation(2.0, 3.0, (m, n) -> m * n);
        System.out.printf("a*b = %9.1f%n", three);


        Double four = calcDouble.performOperation(2.0, 3.0, (m, n) -> m / n);
        System.out.printf("a/b = %9.3f%n", four);
    }
}
