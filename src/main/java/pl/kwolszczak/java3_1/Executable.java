package pl.kwolszczak.java3_1;

@FunctionalInterface
public interface Executable<T extends Number> {

    T execute(T a, T b);
}
