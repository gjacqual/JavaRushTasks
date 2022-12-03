package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());

        if (Files.isDirectory(sourceDirectory) && Files.isDirectory(targetDirectory))
            try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
                for (Path path : files) {
                    if (Files.isRegularFile(path)) {
                        Path filename = path.getFileName();
                        Path targetFilePath = targetDirectory.resolve(filename);
                        Files.copy(path, targetFilePath);
                    }
                }
            }
        }
}

