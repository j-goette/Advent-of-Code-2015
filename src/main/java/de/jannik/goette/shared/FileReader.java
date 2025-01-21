package de.jannik.goette.shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private static final String RESOURCE_FILE_PATH = "src/main/resources/one/input.txt";

    public String readFile() {
        try {
            return Files.readString(Path.of(RESOURCE_FILE_PATH).toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
