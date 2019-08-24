package com.boo.exercise02.rule.junit5;

import lombok.val;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * you can still use JUnit 4 rules in JUnit 5 tests.
 * But use with caution, API status = EXPERIMENTAL
 * make sure tests are executed with 'mvn test'
 */
@EnableRuleMigrationSupport
class JUnit5TemporaryFolderTestMigrationSupport {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    void givenFieldWithSharedTempDirectoryPath_whenWriteToFile_thenContentIsCorrect() throws IOException {
        File numbers = temporaryFolder.newFile("numbers");
        val lines = asList("1", "2", "3");
        Files.write(numbers.toPath(), lines);

        assertAll(
                () -> assertTrue(Files.exists(numbers.toPath())),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers.toPath()))
        );
    }
}
