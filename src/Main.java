package src;

import src.ClassesMenu.MainMenu;
import src.ClassesLoja.*;
import src.Enum.AnimalType;
import src.Enum.ProductType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<ProductType, ArrayList<Product>> products;
    public static ArrayList<Client> clients;
    public static ArrayList<Employee> employees;

    public static void main(String[] args) {
        init();

        // Shows main menu
        System.out.println("Bem-vindo à Puro Pet, uma loja de animais um tanto complexa.");
        MainMenu.show();
        System.out.println("Volte sempre!");
    }

    public static void init() {
        // Initializes the product by type
        products = new HashMap<>();
        for(ProductType type : ProductType.values())
            if(type != ProductType.NONE)
                products.put(type, File.binRead(type.getFilePath()));

        // Clients
        clients = File.binRead("Client/Client.dat");
        // Employees
        employees = File.binRead("Employee/Employee.dat");

        // Set Product ID
        Product.setLast(File.binReadInt("Product/LastId.dat"));
        // Set Purchase ID
        Purchase.setLast(File.binReadInt("Purchase/LastId.dat"));

    }

    public static void saveData() {
        // All products (animals included)
        for(ProductType type : ProductType.values()) {
            if (type != ProductType.NONE)
                File.binWrite(Main.products.get(type), type.getFilePath());
        }

        // Clients and employees
        File.binWrite(clients, "Client/Client.dat");
        File.binWrite(employees, "Employee/Employee.dat");

        // Last IDs
        File.binWriteInt(Purchase.getLast(), "Purchase/LastId.dat");
        File.binWriteInt(Product.getLast(), "Product/LastId.dat");

    }

    public static void listProducts(ProductType type) {
        for (Product p : Main.products.get(type)) {
            System.out.println(p);
        }
    }

    public static void presetData() {
        //todo: create objects

        // products --------------------------------
        // IMAGINARIOS
        Animal unicorn = new Animal(
                100, 'F', "Equus unicornis",
                "\\.\n" +
                        " \\\\      .\n" +
                        "  \\\\ _,.+;)_\n" +
                        "  .\\\\;~%:88%%.\n" +
                        " (( a   `)9,8;%.\n" +
                        " /`   _) ' `9%%%?\n" +
                        "(' .-' j    '8%%'\n" +
                        " `\"+   |    .88%)+._____..,,_   ,+%$%.\n" +
                        "       :.   d%9`             `-%*'\"'~%$.\n" +
                        "    ___(   (%C                 `.   68%%9\n" +
                        "  .\"        \\7                  ;  C8%%)`\n" +
                        "  : .\"-.__,'.____________..,`   L.  \\86' ,\n" +
                        "  : L    : :            `  .'\\.   '.  %$9%)\n" +
                        "  ;  -.  : |             \\  \\  \"-._ `. `~\"\n" +
                        "   `. !  : |              )  >     \". ?\n" +
                        "     `'  : |            .' .'       : |\n" +
                        "         ; !          .' .'         : |\n" +
                        "        ,' ;         ' .'           ; (\n" +
                        "       .  (         j  (            `  \\\n" +
                        "       \"\"\"'          \"\"'             `\"\" mh", // Simples arte ASCII de unicórnio
                AnimalType.LAND
        );

        Animal helloKitty = new Animal(
                5, 'F', "Felinus cuterus",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣶⢶⣶⣄⠀⣠⣴⣾⠿⠿⣷⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢀⣠⣤⣤⣄⣀⡀⠀⠀⠀⠀⢀⣀⣀⣀⣠⣾⠋⠀⠀⠈⠹⣿⡟⠉⠀⠀⠀⠘⣿⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⣾⠟⠉⠉⠉⠛⠻⢿⣶⠿⠿⠟⠛⠛⠛⣿⠇⠀⢠⣶⣶⣶⣿⣷⣦⣤⣀⣠⣤⣿⣷⣄⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠀⠀⢸⣿⣼⡿⠁⠀⠀⠙⣿⣯⡁⠀⠈⢿⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢹⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣄⠀⠀⢙⣿⣷⡀⠀⠀⢠⣿⣿⣿⡆⠀⣾⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠈⢿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠛⠛⠋⠙⠻⠷⠾⣿⡟⠛⠋⠀⣴⡟⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠷⡶⠿⠛⣿⡄⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣹⣷⣤⣤⣤⡄\n" +
                        "⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⡀⠀⠀⠀⠘⠋⢹⣿⠀⠀⠀⠀\n" +
                        "⠀⣀⣀⣤⣿⣧⣤⡄⠀⠀⠀⢀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⡷⠀⠀⠀⠀⢠⣼⣿⣤⣤⡤⠀\n" +
                        "⠈⠛⠉⠉⠹⣿⠀⠀⠀⠀⠀⠸⣿⡿⠀⠀⠀⠀⠀⢀⣠⡤⣤⡀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⢀⣾⠏⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⣀⣤⣿⣷⠞⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠷⠤⠼⣃⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣿⡿⢶⣤⣄⠀⠀\n" +
                        "⠀⠀⠀⠉⠁⠀⠹⣷⣤⡴⠆⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⣤⣼⡟⣻⡇⠀⠀⠀⠀⠀⠀⣀⣴⡿⠋⠀⠀⠀⠉⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⣠⡾⠟⠛⠿⣶⣤⣤⣤⣄⣰⣿⣍⣀⡀⠀⠈⠙⠳⠿⢷⣦⣀⣠⣤⣶⣿⣟⠉⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠘⠋⠀⠀⠀⣰⡟⠉⠀⠀⠙⣿⣅⣉⣿⣁⣀⣠⣶⡀⠀⠀⠈⣿⡏⠁⠀⠀⠹⣷⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠠⣿⠀⠀⠀⠀⠀⣿⣧⡽⠉⠛⢉⣉⣘⣷⣄⣰⣿⣿⠇⠀⠀⠀⠀⣿⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⡄⠀⠀⠀⠀⣻⡷⡄⣞⣳⠘⢦⣇⡈⠙⡿⢿⡇⠀⠀⠀⠀⢠⣿⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⣴⡟⠉⢿⣦⣄⣠⣴⡿⠛⣡⣌⣿⢳⡞⠧⣿⣀⡙⠚⢿⣦⣄⣤⣴⠟⠙⢿⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢰⡿⠀⠀⠀⠈⠉⠉⢹⣧⠈⠳⠞⡉⢻⡷⢦⠸⢭⣧⣤⡿⠋⠉⠉⠀⠀⠀⠈⣿⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⣇⠀⠀⠀⠀⠀⠀⠈⣿⣆⠀⢾⣹⠆⠙⢫⣶⣾⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠘⣿⡀⠀⠀⠀⠀⠀⠀⠘⢿⣶⣤⣤⣴⣾⡿⠻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢰⡿⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠹⣷⣄⠀⠀⠀⠀⠀⢀⣼⣿⣿⡿⠿⠿⣷⣶⣿⣷⡀⠀⠀⠀⠀⠀⢀⣴⡿⠁⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢷⣦⣤⣤⣴⡿⠋⠁⠀⠀⠀⠀⠀⠀⠈⠙⢿⣦⣤⣀⣤⣴⡿⠛⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                AnimalType.LAND
        );

        Animal cinnamoroll = new Animal(
                3, 'M', "Canis adorabilis",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢎⠱⠊⡱⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠤⠒⠒⠒⠒⠤⢄⣑⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢀⡤⠒⠝⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠲⢄⡀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⢰⣢⠐⡄⠀⠉⠑⠒⠒⠒⣄\n" +
                        "⠀⠀⠀⣀⠴⠋⠀⠀⠀⡎⠀⠘⠿⠀⠀⢠⣀⢄⡢⠉⣔⣲⢸⠀⠀⠀⠀⠀⠀⢘\n" +
                        "⡠⠒⠉⠀⠀⠀⠀⠀⡰⢅⠫⠭⠝⠀⠀⠀⠀⠀⠀⢀⣀⣤⡋⠙⠢⢄⣀⣀⡠⠊\n" +
                        "⢇⠀⠀⠀⠀⠀⢀⠜⠁⠀⠉⡕⠒⠒⠒⠒⠒⠛⠉⠹⡄⣀⠘⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠑⠂⠤⠔⠒⠁⠀⠀⡎⠱⡃⠀⠀⡄⠀⠄⠀⠀⠠⠟⠉⡷⠁⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠤⠤⠴⣄⡸⠤⣄⠴⠤⠴⠄⠼⠀⠀⠀⠀⠀⠀⠀⠀",
                AnimalType.LAND
        );

        ArrayList<Product> animalImaginaryLand = Main.products.get(ProductType.ANIMAL_IMAGINARY_LAND);
        animalImaginaryLand.add(unicorn);
        animalImaginaryLand.add(helloKitty);
        animalImaginaryLand.add(cinnamoroll);

        Animal kraken = new Animal(
                500, 'M', "Giganticus oceanicus",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣶⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⣠⡤⣤⣄⣾⣿⣿⣿⣿⣿⣿⣷⣠⣀⣄⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠙⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣬⡿⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢀⣼⠟⢿⣿⣿⣿⣿⣿⣿⡿⠘⣷⣄⠀⠀⠀⠀⠀\n" +
                        "⣰⠛⠛⣿⢠⣿⠋⠀⠀⢹⠻⣿⣿⡿⢻⠁⠀⠈⢿⣦⠀⠀⠀⠀\n" +
                        "⢈⣵⡾⠋⣿⣯⠀⠀⢀⣼⣷⣿⣿⣶⣷⡀⠀⠀⢸⣿⣀⣀⠀⠀\n" +
                        "⢾⣿⣀⠀⠘⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⠿⣿⡁⠀⠀⠀\n" +
                        "⠈⠙⠛⠿⠿⠿⢿⣿⡿⣿⣿⡿⢿⣿⣿⣿⣷⣄⠀⠘⢷⣆⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢠⣿⠏⠀⣿⡏⠀⣼⣿⠛⢿⣿⣿⣆⠀⠀⣿⡇⡀\n" +
                        "⠀⠀⠀⠀⢀⣾⡟⠀⠀⣿⣇⠀⢿⣿⡀⠈⣿⡌⠻⠷⠾⠿⣻⠁\n" +
                        "⠀⠀⣠⣶⠟⠫⣤⠀⠀⢸⣿⠀⣸⣿⢇⡤⢼⣧⠀⠀⠀⢀⣿⠀\n" +
                        "⠀⣾⡏⠀⡀⣠⡟⠀⠀⢀⣿⣾⠟⠁⣿⡄⠀⠻⣷⣤⣤⡾⠋⠀\n" +
                        "⠀⠙⠷⠾⠁⠻⣧⣀⣤⣾⣿⠋⠀⠀⢸⣧⠀⠀⠀⠉⠁⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠈⠉⠉⠹⣿⣄⠀⠀⣸⡿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠿⠟⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀",
                AnimalType.AQUATIC
        );

        Animal blueDragon = new Animal(
                2, 'M', "Glaucus atlanticus imaginarius",
                "                    -,,,__\n" +
                        "                     \\    ``~~--,,__                /   /\n" +
                        "                     /              ``~~--,,_     //--//\n" +
                        "          _,,,,-----,\\              ,,,,---- >   (c  c)\\\n" +
                        "      ,;''            `\\,,,,----''''   ,,-'''---/   /_ ;___        -,_\n" +
                        "     ( ''---,;====;,----/             (-,,_____/  /'/ `;   '''''----\\ `:.\n" +
                        "     (                 '               `      (oo)/   ;~~~~~~~~~~~~~/--~\n" +
                        "      `;_           ;    \\            ;   \\   `  ' ,,'\n" +
                        "         ```-----...|     )___________|    )-----'''\n" +
                        "                     \\   /             \\   \\\\\n" +
                        "                     /  /,              `\\   \\\\\n" +
                        "                   ,'---\\ \\              ,---`,;,",
                AnimalType.AQUATIC
        );

        ArrayList<Product> animalImaginaryAquatic = Main.products.get(ProductType.ANIMAL_IMAGINARY_AQUATIC);
        animalImaginaryAquatic.add(kraken);
        animalImaginaryAquatic.add(blueDragon);

        Animal griffin = new Animal(
                300, 'M', "Griffinus magnus",
                "        _____,    _..-=-=-=-=-====--,\n" +
                        "     _.'a   /  .-',___,..=--=--==-'`\n" +
                        "    ( _     \\ /  //___/-=---=----'\n" +
                        "     ` `\\    /  //---/--==----=-'\n" +
                        "  ,-.    | / \\_//-_.'==-==---='\n" +
                        " (.-.`\\  | |'../-'=-=-=-=--'\n" +
                        "  (' `\\`\\| //_|-\\.`;-~````~,        _\n" +
                        "       \\ | \\_,_,_\\.'        \\     .'_`\\\n" +
                        "        `\\            ,    , \\    || `\\\\\n" +
                        "          \\    /   _.--\\    \\ '._.'/  / |\n" +
                        "          /  /`---'   \\ \\   |`'---'   \\/\n" +
                        "         / /'          \\ ;-. \\\n" +
                        "      __/ /           __) \\ ) `|\n" +
                        "    ((='--;)         (,___/(,_/",
                AnimalType.AERIAL
        );
        Animal phoenix = new Animal(
                1000, 'F', "Aves immortalis",
                " .\\\\            //.\n" +
                        ". \\ \\          / /.\n" +
                        ".\\  ,\\     /` /,.-\n" +
                        " -.   \\  /'/ /  .\n" +
                        " ` -   `-'  \\  -\n" +
                        "   '.       /.\\`\n" +
                        "      -    .-\n" +
                        "      :`//.'\n" +
                        "      .`.'\n" +
                        "      .'",
                AnimalType.AERIAL
        );
        Animal sphinx = new Animal(
                800, 'F', "Mysticus enigmaticus",
                "          /                    ___:__:__:__:__:_\\. /\n" +
                        "         /_.    _-_           _:_:_:__:__:__:__:_\\/./\n" +
                        "        /:_ _ /'. .'\\ ___    :__:_:_:__:__:__:__:_\\/ .\n" +
                        "       /__:_ /(|`/ !)\\  /:__:__:___:_:__:__:__:__:_\\/./\n" +
                        "      /____ |  \\ = /  |/ / /\\:___:__:_:__:__:__:__:_\\/\n" +
                        "             `  ---  ./ / / /\\\n" +
                        "            /--- -----\\/ / / /\n" +
                        "           /---  ----- `/ / /\n" +
                        "         _/--- __ _/  ' `/ /\n" +
                        "       /     /XXX/     ! `/\n" +
                        "      |_|_|_|XXX|_|_|_'|_/",
                AnimalType.AERIAL
        );
        Animal batman = new Animal(
                35, 'M', "Chiroptera sapiens",
                "        __.--'\\     \\.__./     /'--.__\n" +
                        "    _.-'       '.__.'    '.__.'       '-._\n" +
                        "  .'                                      '.\n" +
                        " /                                          \\\n" +
                        "|                                            |\n" +
                        "|                                            |\n" +
                        " \\         .---.              .---.         /\n" +
                        "  '._    .'     '.''.    .''.'     '.    _.'\n" +
                        "     '-./            \\  /            \\.-'\n" +
                        "                      ''",
                AnimalType.AERIAL
        );

        ArrayList<Product> imaginaryAerialAnimals = Main.products.get(ProductType.ANIMAL_IMAGINARY_AERIAL);
        imaginaryAerialAnimals.add(griffin);
        imaginaryAerialAnimals.add(phoenix);
        imaginaryAerialAnimals.add(sphinx);
        imaginaryAerialAnimals.add(batman);

        Animal gato = new Animal(
                2, 'F', "Felis catus",
                "            __..--''``---....___   _..._    __\n" +
                        "           /// //_.-'    .-/\";  `        ``<._  ``.''_ `. / // /\n" +
                        "          ///_.-' _..--.'_    \\                    `( ) ) // //\n" +
                        "         / (_..-' // (< _     ;_..__               ; `' / ///\n" +
                        "         / // // //  `-._,_)' // / ``--...____..-' /// / //  ",
                AnimalType.LAND
        );
        Animal cachorro = new Animal(
                3, 'M', "Canis lupus familiaris",
                "          /^ ^\\\n" +
                        "         / 0 0 \\\n" +
                        "         V\\ Y /V\n" +
                        "          / - \\\n" +
                        "         /    |\n" +
                        "        V__) ||",
                AnimalType.LAND
        );
        Animal coelho = new Animal(
                1, 'F', "Oryctolagus cuniculus",
                "             ,\\\n" +
                        "             \\\\\\,_\n" +
                        "              \\` ,\\\n" +
                        "         __,.-\" =__)\n" +
                        "       .\"        )\n" +
                        "    ,_/   ,    \\/\\_\n" +
                        "    \\_|    )_-\\ \\_-`\n" +
                        "       `-----` `--`",
                AnimalType.LAND
        );
        Animal leão = new Animal(
                5, 'M', "Panthera leo",
                "         ,%%%%%%%,\n" +
                        "       ,%%/\\%%%%/\\%,\n" +
                        "      ,%%%\\c \"\" J/%%,\n" +
                        "      %%%%/ d  b \\%%%\n" +
                        "      %%%%    _  |%%%\n" +
                        "      `%%%%(=_Y_=)%%'\n" +
                        "       `%%%%`\\7/%%%'\n" +
                        "         `%%%%%%%'",
                AnimalType.LAND
        );
        Animal hamster = new Animal(
                1, 'M', "Cricetinae",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⡠⠀⢄⡀⠀⣀⠀⠀⢀⣀⡴⠉⠀⠃⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢇⠀⠀⣿⣾⣯⣍⣽⣿⣿⣿⡤⢀⠇⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠑⢼⣿⣿⣿⣿⣿⣿⣿⣿⣷⣷⣤⡀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢸⣿⣿⣟⣻⣿⣿⣿⣭⣿⣿⣿⣿⡟⠢⡀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢸⡏⢻⣿⢿⣿⣿⣿⡿⣿⡟⣿⠟⠀⠀⣿⣦⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢸⠛⠮⠝⢋⠙⣻⣊⢁⠈⠚⢃⣀⣴⣾⣿⣿⣷⡀\n" +
                        "⠀⠀⠀⠀⠀⣾⣶⣤⡠⠀⠉⠀⠈⢀⢀⣾⣿⣿⣿⣿⣿⣿⠿⣧\n" +
                        "⠀⠀⠀⠀⠀⠿⡟⠛⠻⠷⣶⠀⣶⠟⠋⠛⣿⠗⠈⠈⠉⢠⣪⣿\n" +
                        "⠀⠀⠀⠀⠀⠸⡈⠙⣄⡀⢸⢸⡿⣄⡦⠋⠁⠀⠀⠀⡠⣺⣿⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠙⢢⡤⠙⠛⡏⣅⣠⠶⠖⠒⠒⠈⠁⠐⢾⣿⡏\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠈⡄⠀⠀⠸⣿⡷⠀⠀⠀⠀⠀⢀⢠⣿⣿⠃\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠘⠦⣀⠀⣿⣷⣦⠄⠀⠀⠀⢝⣿⣿⡟⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⣤⣤⣄⣊⡉⠟⠿⢿⡷⠗⠚⣲⠽⠿⠟⠁⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀",
                AnimalType.LAND
        );
        Animal galinha = new Animal(
                1, 'F', "Gallus gallus domesticus",
                "         __//\n" +
                        "      cf /.__.\\\n" +
                        "         \\ \\/ /\n" +
                        "      '__/    \\\n" +
                        "       \\-      )\n" +
                        "        \\_____/\n" +
                        "    ____|_|____\n" +
                        "         \" \"",
                AnimalType.LAND
        );

        ArrayList<Product> realLandAnimals = Main.products.get(ProductType.ANIMAL_REAL_LAND);
        realLandAnimals.add(gato);
        realLandAnimals.add(cachorro);
        realLandAnimals.add(coelho);
        realLandAnimals.add(leão);
        realLandAnimals.add(hamster);
        realLandAnimals.add(galinha);

        Animal peixeDourado = new Animal(
                1, 'F', "Carassius auratus",
                "               O  o\n" +
                        "          _\\_   o\n" +
                        ">('>   \\\\/  o\\ .\n" +
                        "       //\\___=\n" +
                        "          ''",
                AnimalType.AQUATIC
        );
        Animal betta = new Animal(
                1, 'M', "Betta splendens",
                "      /\\\n" +
                        "    _/./\n" +
                        " ,-'    `-:..-'/\n" +
                        ": o )      _  (\n" +
                        "\"`-....,--; `-.\\\n" +
                        "    `'",
                AnimalType.AQUATIC
        );
        Animal guppy = new Animal(
                1, 'F', "Poecilia reticulata",
                "|\\   \\\\\\\\__     o\n" +
                        "| \\_/    o \\    o \n" +
                        "> _   (( <_  oo  \n" +
                        "| / \\__+___/      \n" +
                        "|/     |/",
                AnimalType.AQUATIC
        );
        Animal estrelaDoMar = new Animal(
                10, 'F', "Asteroidea", null,
                AnimalType.AQUATIC
        );
        Animal ouriçoDoMar = new Animal(
                5, 'M', "Echinoidea",
                null,
                AnimalType.AQUATIC
        );
        Animal tartaruga = new Animal(
                80, 'F', "Chelonioidea",
                "     _..---.--.\n" +
                        "   .'\\ __|/O.__)\n" +
                        "  /__.' _/ .-'_\\\n" +
                        " (____.'.-_\\____) \n" +
                        "  (_/ _)__(_ \\_)\\_\n" +
                        "   (_..)--(.._)'--'",
                AnimalType.AQUATIC
        );
        Animal cavaloMarinho = new Animal(
                2, 'M', "Hippocampus",
                "           :=()\n" +
                        "             /|\n" +
                        "            { )<|\n" +
                        "             \\|\n" +
                        "           /` |\n" +
                        "           \\__/",
                AnimalType.AQUATIC
        );
        Animal trilobita = new Animal(
                300, 'M', "Trilobita",
                "        ..\\\\\\\\\n" +
                        "     ..\\\\\\\\  ,\\\n" +
                        "--===)))))))   )\n" +
                        "     ''////  `/\n" +
                        "        ''////",
                AnimalType.AQUATIC
        );

        ArrayList<Product> animaisAquaticos = Main.products.get(ProductType.ANIMAL_REAL_AQUATIC);
        animaisAquaticos.add(peixeDourado);
        animaisAquaticos.add(betta);
        animaisAquaticos.add(guppy);
        animaisAquaticos.add(estrelaDoMar);
        animaisAquaticos.add(ouriçoDoMar);
        animaisAquaticos.add(tartaruga);
        animaisAquaticos.add(cavaloMarinho);
        animaisAquaticos.add(trilobita);

        Animal águia = new Animal(
                15, 'M', "Aquila chrysaetos",
                "                           /\n" +
                        "               \\             / /\n" +
                        "                \\\\\\' ,      / //\n" +
                        "                 \\\\\\//,   _/ //,\n" +
                        "                  \\_-//' /  //<,\n" +
                        "                    \\ ///  >  \\\\\\`__/_\n" +
                        "                    /,)-^>> _\\` \\\\\\\n" +
                        "                    (/   \\\\ //\\\\\n" +
                        "                        // _//\\\\\\\\\n" +
                        "                      ((` ((",
                AnimalType.AERIAL
        );
        Animal coruja = new Animal(
                7, 'F', "Strigiformes",
                "\n" +
                        "                  /^----^\\\n" +
                        "                  | 0  0 |\n" +
                        "    Whoo!!        |  \\/  |\n" +
                        "                  /       \\\n" +
                        "      Whoo!!     |     |;;;|\n" +
                        "                 |     |;;;|          \n" +
                        "                 |      \\;;|           \n" +
                        "                  \\       \\|          \n" +
                        " ------------------(((--(((-------",
                AnimalType.AERIAL
        );
        Animal cacatua = new Animal(
                3, 'M', "Nymphicus hollandicus",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⡾⠤⠤⠤⠤⠄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠋⡡⠖⠒⠒⢄⣤⠒⠛⠳⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠁⡸⠀⣠⡀⢀⠀⡇⠀⠀⠀⠀⠙⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⢧⡀⣯⣿⣿⡄⣇⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⠀⠀⢹⠈⠙⠁⢠⣾⣿⣷⣦⡀⠀⢸⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⡀⢀⠣⣄⣀⡀⠝⢿⣿⠿⢣⡠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡰⠃⢠⣽⠶⢤⠀⣀⡀⢿⣄⠀⠀⠀⠀⣠⠴⣶⣤⣀⣠⣤⣖⣒⡀⢀⡠⠂\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡔⠉⠀⠐⠉⢀⠀⠀⡇⠁⠀⠀⠙⣗⠒⣒⡭⠴⠊⡻⣽⠛⠻⣖⣋⣀⡈⠉⠁⣲\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢎⣄⠔⠀⠀⢠⠎⠀⢠⣇⠀⠀⠀⠀⠸⣭⣅⢀⠔⠔⢧⠈⢥⠤⠼⠄⡀⠐⢶⠊⠁\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣮⣼⣋⠔⢁⠔⠁⡠⢀⡎⢹⠀⠀⠀⠀⠀⡇⠀⡉⠀⣄⣠⠧⡜⠢⡀⠠⡤⠤⠤⠇⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⢋⠟⣻⡞⢁⡠⢊⣤⠞⠀⣼⠀⣀⣤⠀⣸⠑⢊⠉⠛⠇⠈⠄⢈⠂⠳⠤⠼⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⣲⠟⡡⠚⡊⢁⡽⣛⣾⡿⠋⠀⠀⠉⠞⠋⣽⠜⠉⠲⠚⢆⠴⠤⠒⠴⠂⠉⠉⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⢀⣀⠤⠴⠒⣊⡹⣭⣿⡷⠋⠀⣠⠟⣛⣿⠟⠉⠀⠀⠀⣀⣀⠤⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⢘⡧⠔⠒⠊⠉⢀⣠⣽⣋⣠⣖⣩⡶⠛⠛⠢⣄⣀⡤⠖⠻⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢾⣅⣀⡤⠤⢒⣋⢥⣲⠿⣋⣵⠟⠉⠀⠀⠀⣤⣤⣽⣣⣰⣦⣿⣷⣒⣤⣶⣴⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠿⠤⡤⠤⠞⢋⡩⠴⠚⠉⠀⠀⠀⠀⠀⠀⠁⠉⠙⡟⣗⡪⠿⣿⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠗⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⠓⠾⠓⠒⠚⠲⠞⠆⠲⠖⠂⠀⠗⠛⠓⠛⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                AnimalType.AERIAL
        );
        Animal morcego = new Animal(
                4, 'M', "Chiroptera",
                "   /\\                 /\\\n" +
                        "  / \\'._   (\\_/)   _.'/ \\\n" +
                        " /_.''._'--('.')--'_.''._\\\n" +
                        " | \\_ / `;=/ \" \\=;` \\ _/ |\n" +
                        "  \\/ `\\__|`\\___/`|__/`  \\/\n" +
                        "   `      \\(/|\\)/       `\n" +
                        "           \" ` \"",
                AnimalType.AERIAL
        );

        ArrayList<Product> animaisAereos = Main.products.get(ProductType.ANIMAL_REAL_AERIAL);
        animaisAereos.add(águia);
        animaisAereos.add(coruja);
        animaisAereos.add(cacatua);
        animaisAereos.add(morcego);

        // cosmetic field


        // food field
        

        // habitat field


        // hygiene field
        Product shampooCao = new Product("Shampoo para Cães", 15.99, 100);
        Product condicionadorCao = new Product("Condicionador para Cães", 18.50, 50);
        Product luvasEscovarCao = new Product("Luvas para Escovar Cães", 12.99, 40);
        Product escovaCao = new Product("Escova para Cães", 10.50, 60);
        Product escovaDentesCao = new Product("Escova de Dentes para Cães", 8.99, 50);
        Product pastaDentesCao = new Product("Pasta de Dentes para Cães", 9.99, 45);

        Product shampooGato = new Product("Shampoo para Gatos", 14.99, 80);
        Product condicionadorGato = new Product("Condicionador para Gatos", 17.50, 40);
        Product luvasEscovarGato = new Product("Luvas para Escovar Gatos", 12.99, 30);
        Product escovaGato = new Product("Escova para Gatos", 10.50, 50);
        Product escovaDentesGato = new Product("Escova de Dentes para Gatos", 8.99, 40);
        Product pastaDentesGato = new Product("Pasta de Dentes para Gatos", 9.99, 35);

        Product shampooPassaro = new Product("Shampoo para Pássaros", 12.99, 60);
        Product condicionadorPassaro = new Product("Condicionador para Pássaros", 16.00, 30);
        Product luvasEscovarPassaro = new Product("Luvas para Escovar Pássaros", 11.99, 20);
        Product escovaPassaro = new Product("Escova para Pássaros", 9.50, 25);

        Product shampooCoelho = new Product("Shampoo para Coelhos", 13.99, 70);
        Product condicionadorCoelho = new Product("Condicionador para Coelhos", 15.50, 20);
        Product luvasEscovarCoelho = new Product("Luvas para Escovar Coelhos", 11.99, 15);
        Product escovaCoelho = new Product("Escova para Coelhos", 9.50, 20);

        ArrayList<Product> produtosHigiene = Main.products.get(ProductType.HYGIENE);
        produtosHigiene.add(shampooCao);
        produtosHigiene.add(condicionadorCao);
        produtosHigiene.add(luvasEscovarCao);
        produtosHigiene.add(escovaCao);
        produtosHigiene.add(escovaDentesCao);
        produtosHigiene.add(pastaDentesCao);

        produtosHigiene.add(shampooGato);
        produtosHigiene.add(condicionadorGato);
        produtosHigiene.add(luvasEscovarGato);
        produtosHigiene.add(escovaGato);
        produtosHigiene.add(escovaDentesGato);
        produtosHigiene.add(pastaDentesGato);

        produtosHigiene.add(shampooPassaro);
        produtosHigiene.add(condicionadorPassaro);
        produtosHigiene.add(luvasEscovarPassaro);
        produtosHigiene.add(escovaPassaro);

        produtosHigiene.add(shampooCoelho);
        produtosHigiene.add(condicionadorCoelho);
        produtosHigiene.add(luvasEscovarCoelho);
        produtosHigiene.add(escovaCoelho);

        // medicine field


        // clients ---------------------------------
        clients.add(new Client(new Person("Ana Silva", 'F', LocalDate.of(1990, 5, 20), 912345678, 123456789)));
        clients.add(new Client(new Person("Bruno Costa", 'M', LocalDate.of(1985, 3, 15), 923456789, 987654321)));
        clients.add(new Client(new Person("Clara Mendes", 'F', LocalDate.of(1992, 8, 10), 934567890, 456789123)));
        clients.add(new Client(new Person("David Pereira", 'M', LocalDate.of(1988, 12, 25), 945678901, 321654987)));
        clients.add(new Client(new Person("Eva Santos", 'F', LocalDate.of(1995, 7, 30), 956789012, 654321789)));
        clients.add(new Client(new Person("Fábio Almeida", 'M', LocalDate.of(1980, 1, 5), 967890123, 789123456)));
        clients.add(new Client(new Person("Gabriela Rocha", 'F', LocalDate.of(1993, 4, 22), 978901234, 159753468)));
        clients.add(new Client(new Person("Hugo Martins", 'M', LocalDate.of(1987, 9, 17), 989012345, 753159846)));
        clients.add(new Client(new Person("Isabel Ferreira", 'F', LocalDate.of(1991, 11, 12), 991234567, 852456963)));
        clients.add(new Client(new Person("João Carvalho", 'M', LocalDate.of(1986, 2, 28), 902345678, 963258741)));

        // employees -------------------------------
        employees.add(new Employee(new Person("Carlos Mendes", 'M', LocalDate.of(1985, 4, 10), 912345678, 123456789), 2500.00, "Desenvolvedor"));
        employees.add(new Employee(new Person("Maria Oliveira", 'F', LocalDate.of(1990, 6, 15), 923456789, 987654321), 3000.00, "Gerente"));
        employees.add(new Employee(new Person("Pedro Santos", 'M', LocalDate.of(1982, 2, 20), 934567890, 456789123), 2200.00, "Analista"));
        employees.add(new Employee(new Person("Ana Costa", 'F', LocalDate.of(1988, 8, 30), 945678901, 321654987), 2800.00, "Designer"));
        employees.add(new Employee(new Person("Jorge Almeida", 'M', LocalDate.of(1995, 1, 5), 956789012, 654321789), 3200.00, "Engenheiro"));
        employees.add(new Employee(new Person("Sofia Ferreira", 'F', LocalDate.of(1993, 11, 12), 967890123, 789123456), 2700.00, "Coordenadora"));

        // Guardar todos os produtos
        saveData();
    }
}