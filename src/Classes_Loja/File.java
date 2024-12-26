package src.Classes_Loja;

import java.io.*;
import java.util.ArrayList;

public class File {
    /**
     * The base path of the files
     */
    private static final String path = "Loja_De_Animais/files/";

    /**
     * Writes the given ArrayList to the fileName file in binary format.
     *
     * @param list     The ArrayList to write on the file
     * @param fileName The name of the file that will be written
     * @param <T>      The type of the elements of the given ArrayList
     */
    public static <T> void binWrite(ArrayList<T> list, String fileName) {
        fileName = path + fileName;

        try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // System.out.print("Writing " + fileName); // debug
            file.writeObject(list);
            file.flush();

            System.out.println("Dados guardados no ficheiro: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao guardar os dados do ficheiro " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Reads the given binary fileName file
     *
     * @param fileName The name of the file to load
     * @param <T>      The type of the elements of the returned ArrayList
     * @return An ArrayList with the information in the file
     */
    public static <T> ArrayList<T> binRead(String fileName) {
        fileName = path + fileName;

        ArrayList<T> list = new ArrayList<>();

        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (ArrayList<T>) file.readObject();
        } catch (IOException e) {
            // Ignore if the error is that the file is null
            if (e.getMessage() != null) {
                System.out.println("Erro ao ler os dados do ficheiro " + fileName + ": " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao ler os dados em do ficheiro " + fileName + ": " + e.getMessage());
        }
        return list;
    }

    public static void binWriteInt(int value, String fileName) {
        fileName = path + fileName;

        try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // System.out.print("Writing " + fileName); // debug
            file.writeInt(value);
            file.flush();

            System.out.println("Dados guardados no ficheiro: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao guardar os dados do ficheiro " + fileName + ": " + e.getMessage());
        }
    }

    public static int binReadInt(String fileName) {
        fileName = path + fileName;

        int value = 0;

        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(fileName))) {
            value = file.readInt();
        } catch (IOException e) {
            // Ignore if the error is that the file is null
            if (e.getMessage() != null) {
                System.out.println("Erro ao ler os dados do ficheiro " + fileName + ": " + e.getMessage());
            }
        }
        return value;
    }
}



