package pl.kwolszczak.selenium5_2.data;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DataArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {

    return Stream.of(
            Arguments.of("https://www.sii.pl","Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"),
            Arguments.of("https://onet.pl","Onet – Jesteś na bieżąco")
    );
    }
}
