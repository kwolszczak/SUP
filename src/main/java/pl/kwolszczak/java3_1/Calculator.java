package pl.kwolszczak.java3_1;

public class Calculator <T extends Number>{

    public T performOperation(T a, T b, Executable<T> operation){
        return operation.execute(a,b);
    }
}
