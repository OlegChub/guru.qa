package homework.lesson7;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArgumentsSourceProvider implements ArgumentsProvider {
    private List<String> credentials = Arrays.asList("standard_user", "secret_sauce");

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(credentials, "T-Shirt", 2),
                Arguments.of(credentials, "Backpack", 1)
        );
    }
}
