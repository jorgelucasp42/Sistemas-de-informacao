/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacao;

/**
 *
 * @author jorge
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryUserManager {

    private RedBlackTree<String, String> users;

    public LibraryUserManager() {
        users = new RedBlackTree<>();
    }

    public void insertUser(String username, String fullName) {
        users.put(username, fullName);
    }

    public void removeUser(String username) {
        users.delete(username);
    }

    public String searchUser(String username) {
        return users.get(username);
    }

    public void printUsers() {
        users.inOrderTraversal((username, isRed) -> System.out.println(username + (isRed ? " (RED)" : " (BLACK)")));
    }

    public void printLeafUsers() {
        users.printLeafUsers();
    }

    public String getRootUser() {
        String rootKey = users.getRootKey();
        return rootKey; // rootKey já é uma String, então não precisa do toString()
    }

    public int countBlackNodes() {
        return users.countBlackNodes();
    }

    public void processCommandsFromFile(String filePath) {
        File file = new File(filePath);
        try ( Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processCommand(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (Exception e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    private void processCommand(String commandLine) {
        String[] parts = commandLine.split("\\s+");
        if (parts.length < 2) {
            return;
        }

        String command = parts[0];
        String username = parts[1];
        String fullName = null;

        // Isso verifica se existe um espaço após o primeiro espaço antes de chamar substring.
        int firstSpaceIndex = commandLine.indexOf(' ');
        int secondSpaceIndex = commandLine.indexOf(' ', firstSpaceIndex + 1);

        if (firstSpaceIndex != -1 && secondSpaceIndex != -1 && secondSpaceIndex < commandLine.length()) {
            fullName = commandLine.substring(secondSpaceIndex).trim();
        }

        switch (command.toLowerCase()) {
            case "insert":
                if (fullName != null) {
                    insertUser(username, fullName);
                }
                break;
            case "delete":
                removeUser(username);
                break;
            case "search":
                String user = searchUser(username);
                if (user != null) {
                    System.out.println("User found: " + user);
                } else {
                    System.out.println("User not found.");
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }

    public static void main(String[] args) {

        // Caminho codificado para o arquivo de comandos
        String filePath = "C:\\Users\\jorge\\OneDrive\\Documentos\\NetBeansProjects\\JorgeSilva_ATV05-Arvores\\src\\main\\java\\Entrada\\commands.txt";

        LibraryUserManager manager = new LibraryUserManager();
        manager.processCommandsFromFile(filePath);

        // Impressão de resultados após inserções e remoções.
        System.out.println("Users in the leaf nodes:");
        manager.printLeafUsers();

        System.out.println("Root user: " + manager.getRootUser());
        System.out.println("Black nodes from root to leftmost leaf: " + manager.countBlackNodes());
    }

}
