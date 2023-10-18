package pl.kwolszczak.java3_1;

@FunctionalInterface
public interface Executable<T> {

    T execute(T a, T b);
}
