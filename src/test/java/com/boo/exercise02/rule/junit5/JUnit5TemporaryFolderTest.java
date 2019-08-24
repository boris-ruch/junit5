package com.boo.exercise02.rule.junit5;


import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;


class JUnit5TemporaryFolderTest {

    @TempDir
    Path sharedTempDir;

    @Test
    void givenFieldWithSharedTempDirectoryPath_whenWriteToFile_thenContentIsCorrect() throws IOException {
        Path numbers = sharedTempDir.resolve("numbers.txt");
        val lines = asList("1", "2", "3");
        Files.write(numbers, lines);

        assertAll("verify file content",
                () -> assertTrue(Files.exists(numbers)),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers))
        );
    }
}
