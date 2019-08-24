package com.boo.exercise02.rule.junit4;

import lombok.val;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class JUnit4TemporaryFolderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void givenFieldWithSharedTempDirectoryPath_whenWriteToFile_thenContentIsCorrect() throws IOException {
        File numbers = temporaryFolder.newFile("numbers");
        val lines = asList("1", "2", "3");
        Files.write(numbers.toPath(), lines);

        assertTrue(Files.exists(numbers.toPath()));
        assertEquals(lines, Files.readAllLines(numbers.toPath()));
    }
}