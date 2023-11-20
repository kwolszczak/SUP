package pl.kwolszczak.selenium7_2.utils;

public class AppEnvException extends RuntimeException{
    public AppEnvException( ) {
        super("Wrong app env settings ");
    }
}
