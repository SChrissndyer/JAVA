package org.example.day60;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FileSystemWithAttributesDemo {

    public static void main(String[] args) {
        // Get the default FileSystem
        FileSystem fileSystem = FileSystems.getDefault();

        // Create a Path object using the FileSystem
        Path filePath = fileSystem.getPath("example.txt");

        try {
            // 1. Create the file if it doesn't exist
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
                System.out.println("File created: " + filePath);
            } else {
                System.out.println("File already exists: " + filePath);
            }

            // 2. Retrieve Basic File Attributes
            BasicFileAttributes basicAttrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("\nBasic File Attributes:");
            System.out.println("Creation Time: " + basicAttrs.creationTime());
            System.out.println("Last Modified Time: " + basicAttrs.lastModifiedTime());
            System.out.println("Size: " + basicAttrs.size() + " bytes");
            System.out.println("Is Directory: " + basicAttrs.isDirectory());
            System.out.println("Is Regular File: " + basicAttrs.isRegularFile());
            // 3. Modify the Last Modified Time
            FileTime newLastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
            Files.setLastModifiedTime(filePath, newLastModifiedTime);
            System.out.println("\nUpdated Last Modified Time: " + Files.getLastModifiedTime(filePath));

            // 4. Retrieve and modify POSIX file permissions (only on POSIX-compliant systems)
            if (fileSystem.supportedFileAttributeViews().contains("posix")) {
                PosixFileAttributes posixAttrs = Files.readAttributes(filePath, PosixFileAttributes.class);
                Set<PosixFilePermission> permissions = posixAttrs.permissions();

                System.out.println("\nPOSIX File Permissions:");
                for (PosixFilePermission permission : permissions) {
                    System.out.println(permission);
                }

                // Modify the file permissions (e.g., add owner write permission)
                permissions.add(PosixFilePermission.OWNER_WRITE);
                Files.setPosixFilePermissions(filePath, permissions);
                System.out.println("\nUpdated POSIX File Permissions:");
                for (PosixFilePermission permission : Files.getPosixFilePermissions(filePath)) {
                    System.out.println(permission);
                }
            } else {
                System.out.println("\nPOSIX file permissions not supported on this system.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Clean up by deleting the file
            try {
                Files.deleteIfExists(filePath);
                System.out.println("\nFile deleted: " + filePath);
            } catch (IOException e) {
                System.err.println("Error deleting the file: " + e.getMessage());
            }
        }
    }
}
