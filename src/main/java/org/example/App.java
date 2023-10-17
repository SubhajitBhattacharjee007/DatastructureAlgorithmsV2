package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class App {
    private static final String INPUT_FOLDER = "/home/subhajit/Documents/Dummy/";
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        File[] files = new File(INPUT_FOLDER).listFiles();
        accumulateFolders(files);
    }

    private static void accumulateFolders(File[] files) {
        File[] file = Arrays.stream(files).filter(File::isDirectory).toArray(File[]::new);
        showFiles(file);
    }

    private static void showFiles(File[] files) {
        Arrays.stream(files).forEach(f -> {
            if (f.isDirectory()) {
                showFiles(f.listFiles());
            } else {
                readFile(f);
            }
        });
    }

    private static void readFile(File file) {
        Stream<String> lines;
        try {
            lines = Files.lines(Path.of(file.getAbsolutePath()));
            lines.forEach(logger::info);
            lines.close();
        } catch (IOException e) {
            logger.info("We caught exception!" + e.getMessage());
        }
    }
}
