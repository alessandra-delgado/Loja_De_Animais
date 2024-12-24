package src.Classes_Loja;

import java.io.*;
import java.util.ArrayList;

public class File {
    /**
     * The base path of the files
     */
    private static final String path = "Loja_De_Animais/src/Files/";

    /**
     * Writes the given ArrayList to the fileName file in binary format.
     * @param list The ArrayList to write on the file
     * @param fileName The name of the file that will be written
     * @param <T> The type of the elements of the given ArrayList
     */
    public static <T> void binWrite(ArrayList<T> list, String fileName) {
        fileName = path + fileName;

        try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName))) {
            file.writeObject(list);
            file.flush();

            System.out.println("Dados guardados no ficheiro: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao guardar os dados do ficheiro " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Reads the given binary fileName file
     * @param fileName The name of the file to load
     * @return An ArrayList with the information in the file
     * @param <T> The type of the elements of the returned ArrayList
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

    public static <Info> void displayInfo(ArrayList<Info> list) {
        if (list.isEmpty()) {
            System.out.println("Nenhuma informação encontrada");
        } else {
            for (Info info : list) {
                System.out.println(info);
            }
        }
    }
}



