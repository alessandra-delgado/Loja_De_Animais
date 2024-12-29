package src.ClassesLoja;

import src.ClassesMenu.ProductMenu;
import src.Exceptions.ProductNotFoundException;
import src.Exceptions.ProductStockExceededException;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Purchase implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int last_id = 0;
    private int id;
    private double total;
    private ArrayList<Product> products;
    private LocalDateTime purchase_time;

    public Purchase() {
        this.id = ++last_id;
        this.total = 0.0;
        products = new ArrayList<>();
        purchase_time = LocalDateTime.now();
    }

    public static int getLast() {
        return Purchase.last_id;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    public LocalDateTime getPurchase_time() {
        return purchase_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setLast(int last_id) {
        Purchase.last_id = last_id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setPurchase_time(LocalDateTime purchase_time) {
        this.purchase_time = purchase_time;
    }

    public void addProduct(Product p) throws ProductStockExceededException {
        p.decrementQuantity();
        this.total += p.getPrice();
        this.products.add(p);
    }

    public void removeProduct(Product p) {
        this.total -= p.getPrice();
        this.products.get(id).incrementQuantity();
        this.products.remove(p);
    }

    public void removeProduct(int id) {
        this.total -= this.products.get(id).getPrice();
        this.products.get(id).incrementQuantity();
        this.products.remove(id);
    }

    public void removeAllProducts() {
        for (Product p : this.products) {
            p.incrementQuantity();
            // Given that remove() removes the first instance of given object in an ArrayList,
            // removing each product for each iteration would not work if repeated products
            // are contained in the list
        }
        this.products.clear();
        this.total = 0.0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase p)) return false;
        return this.id == p.id && this.products.equals(p.products) && this.total == p.total && this.purchase_time.equals(p.purchase_time); // does id comparison make sense?
    }

    public Object clone() {
        Purchase p = new Purchase();
        p.id = this.id; //?
        p.total = this.total;
        p.purchase_time = this.purchase_time;
        p.products = (ArrayList<Product>) this.products.clone();
        return p;
    }

    public String toString() {
        return "[ID: " + this.id + " , Produtos: " + this.products.toString() + ", Total: " + this.total + " ]";
    }

    public void printInvoice(Client c) {
        int char_space = 48; // Espaço padrão
        int name_length = 0;

        // Armazenar a quantidade para cada produto no HashMap
        HashMap<Integer, Integer> idAndQuantity = new HashMap<>();
        for (Product p : this.products) {
            idAndQuantity.put(p.getId(), idAndQuantity.getOrDefault(p.getId(), 0) + 1);
        }

        // Cabeçalho da fatura
        System.out.println("====================================================");
        System.out.printf("|| %-46s ||%n", "PURO PET                       LOJA DE ANIMAIS");
        System.out.printf("|| %-46s ||%n", "");
        System.out.printf("|| %-46s ||%n", "**** LOJA DE ANIMAIS ****");
        System.out.printf("|| %-46s ||%n", "Puro Pet, Lda.");
        System.out.printf("|| %-46s ||%n", "C:\\Users\\PuroPet\\Faturas");
        System.out.printf("|| %-46s ||%n", "6200-XXX Covilha");
        System.out.println("|| ---------------------------------------------- ||");
        System.out.printf("|| %-46s ||%n", "Fatura Simplificada");

        // Data formatada
        System.out.printf("||  Data: %-39s ||%n", "currentDate"); //todo: add date

        System.out.println("|| ---------------------------------------------- ||");

        // NIF (preenchido com exemplo ou dinamicamente se necessário)
        System.out.printf("||  NIF: %-40s ||%n", c.getNif());

        System.out.println("|| ---------------------------------------------- ||");
        System.out.printf("||  %-30s %-7s %-6s ||%n", "Produto", "Quant", "Valor");
        System.out.println("|| ---------------------------------------------- ||");

        // Corpo da fatura: produtos, quantidades e valores
        idAndQuantity.forEach((id, quantity) -> {
            try {
                Product product = ProductMenu.findProductById(id);
                String productName = product.getName();
                double productPrice = product.getPrice();

                // Truncar ou ajustar nomes muito longos para caber no espaço
                if (productName.length() > 30) {
                    productName = productName.substring(0, 27) + "...";
                }

                // Exibir cada linha formatada
                System.out.printf("||  %-30s %-7d %-6.2f ||%n", productName, quantity, productPrice * quantity);
            } catch (ProductNotFoundException e) {
                System.out.printf("||  %-30s %-7s %-6s ||%n", "Produto não encontrado", "-", "-");
            }
        });
        System.out.println("|| ---------------------------------------------- ||");
        System.out.printf("|| %-30s %-7s %-6.2f€ ||%n", "TOTAL", "", this.total);
        System.out.println("|| ---------------------------------------------- ||");
        System.out.printf("|| %-46s ||%n", "* Obrigado Pela Visita. Volte Sempre. *");
        System.out.printf("|| %-46s ||%n", "Este documento nao constitui documento");
        System.out.printf("|| %-46s ||%n", "de transporte, nos termos do");
        System.out.printf("|| %-46s ||%n", "Decreto-Lei n.º 147/2003");
        System.out.println("====================================================");
    }
}