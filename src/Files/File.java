package src.Files;

import java.io.*;
import java.util.ArrayList;

public class File {
    private static String path = "Loja_De_Animais/src/Files_Products/";

    public static <Info> void saveInfo(ArrayList<Info> list, String fileName) {
        fileName = path + fileName;

        try (ObjectOutputStream info = new ObjectOutputStream(new FileOutputStream(fileName))){
            info.writeObject(list);
            info.flush();
            System.out.println("Dados salvos no ficheiro: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados: " + e.getMessage());
        }
    }

    // Carregar
    public static <T> ArrayList<T> loadInfo(String fileName) {
        fileName = path + fileName;
        ArrayList<T> list = new ArrayList<>();
        try (ObjectInputStream info = new ObjectInputStream(new FileInputStream(fileName))){
            list = (ArrayList<T>) info.readObject();
        }catch (IOException e) {
            //System.out.println("Erro ao carregar dados: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao ler os dados em" + fileName + ":" + e.getMessage());
        }
        return list;
    }
    public static <Info> void displayInfo(ArrayList<Info> list){
        if (list.isEmpty()){
            System.out.println("Nenhuma informação encontrada");
        }else{
            for (Info info : list){
                System.out.println(info);
            }
        }
    }
}



