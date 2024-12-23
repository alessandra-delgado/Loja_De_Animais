package src.Files;
import java.io.*;
import java.util.ArrayList;
import src.Classes_Loja.Product;

public class files {
    //Salvar Informação
    public static <Info> void saveInfo(ArrayList<Info> list, String fileName) {
        try (ObjectOutputStream info = new ObjectOutputStream(new FileOutputStream(fileName))){
            info.writeObject(list);
            info.flush();
            System.out.println("Dados salvos no ficheiro: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados: " + e.getMessage());
        }

    }

    // Carregar
    public static <Info> ArrayList<Info> loadInfo(String fileName) {
        ArrayList<Info> list = new ArrayList<>();
        try (ObjectInputStream info = new ObjectInputStream(new FileInputStream(fileName))){
            list = (ArrayList<Info>) info.readObject();
            System.out.println("Dados carregados no ficheiro: " + fileName);
        }catch (IOException | ClassNotFoundException e) {
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



