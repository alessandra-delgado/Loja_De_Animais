package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import src.ClassesLoja.*;
import src.ClassesMenu.MainMenu;
import src.Enum.AnimalType;
import src.Enum.ProductType;

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
        Animal Roedores = new Animal(
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
        realLandAnimals.add(Roedores);
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
        ArrayList<Product> cosmeticos = Main.products.get(ProductType.COSMETIC);

        Product perfumeCao = new Product("Perfume para Cães", 20.99, 20);
        Product cremeParaPelosCao = new Product("Creme para Pelos de Cães", 18.50, 50);
        Product loçãoHidratanteCao = new Product("Loção Hidratante para Cães", 22.99, 30);
        Product sprayBrilhoCao = new Product("Spray Brilho para Pelos de Cães", 15.99, 40);

        Product perfumeGato = new Product("Perfume para Gatos", 19.99, 15);
        Product cremeParaPelosGato = new Product("Creme para Pelos de Gatos", 17.50, 30);
        Product loçãoHidratanteGato = new Product("Loção Hidratante para Gatos", 21.99, 25);
        Product sprayBrilhoGato = new Product("Spray Brilho para Pelos de Gatos", 14.99, 35);

        Product perfumePassaro = new Product("Perfume para Pássaros", 17.99, 10);
        Product cremeParaPenasPassaro = new Product("Creme para Penas de Pássaros", 16.50, 20);
        Product sprayBrilhoPassaro = new Product("Spray Brilho para Penas de Pássaros", 14.50, 30);
        Product loçãoHidratantePassaro = new Product("Loção Hidratante para Pássaros", 18.99, 15);

        Product perfumeRoedores = new Product("Perfume para Roedores", 18.99, 10);
        Product cremeParaPelagemRoedores = new Product("Creme para Pelagem de Roedores", 17.00, 20);
        Product sprayBrilhoRoedores = new Product("Spray Brilho para Pelagem de Roedores", 14.99, 25);
        Product loçãoHidratanteRoedores = new Product("Loção Hidratante para Roedores", 16.50, 15);

        Product perfumePeixe = new Product("Perfume para Peixes", 24.99, 5);
        Product sprayBrilhoPeixe = new Product("Spray Brilho para Peixes", 22.99, 7);
        Product loçãoHidratantePeixe = new Product("Loção Hidratante para Peixes", 19.99, 8);
        Product condicionadorAquaPeixe = new Product("Condicionador de Água para Peixes", 25.99, 10);

        cosmeticos.add(perfumeCao);
        cosmeticos.add(cremeParaPelosCao);
        cosmeticos.add(loçãoHidratanteCao);
        cosmeticos.add(sprayBrilhoCao);

        cosmeticos.add(perfumeGato);
        cosmeticos.add(cremeParaPelosGato);
        cosmeticos.add(loçãoHidratanteGato);
        cosmeticos.add(sprayBrilhoGato);

        cosmeticos.add(perfumePassaro);
        cosmeticos.add(cremeParaPenasPassaro);
        cosmeticos.add(sprayBrilhoPassaro);
        cosmeticos.add(loçãoHidratantePassaro);

        cosmeticos.add(perfumeRoedores);
        cosmeticos.add(cremeParaPelagemRoedores);
        cosmeticos.add(sprayBrilhoRoedores);
        cosmeticos.add(loçãoHidratanteRoedores);

        cosmeticos.add(perfumePeixe);
        cosmeticos.add(sprayBrilhoPeixe);
        cosmeticos.add(loçãoHidratantePeixe);
        cosmeticos.add(condicionadorAquaPeixe);


        // food field
        ArrayList<Product> comida = Main.products.get(ProductType.FOOD);

        Product racaoCao = new Product("Ração para Cães Adultos", 29.99, 100);
        Product petiscoCao = new Product("Petisco para Cães (Biscoitos)", 7.99, 150);
        Product racaoFilhoteCao = new Product("Ração para Filhotes de Cães", 34.99, 80);
        Product comidaEnlatadaCao = new Product("Comida Enlatada para Cães", 12.99, 60);
        Product suplementoAlimentarCao = new Product("Suplemento Alimentar para Cães", 19.99, 40);

        Product racaoGato = new Product("Ração para Gatos Adultos", 27.99, 100);
        Product petiscoGato = new Product("Petisco para Gatos", 8.99, 120);
        Product racaoFilhoteGato = new Product("Ração para Filhotes de Gatos", 32.99, 90);
        Product comidaEnlatadaGato = new Product("Comida Enlatada para Gatos", 11.99, 80);
        Product suplementoAlimentarGato = new Product("Suplemento Alimentar para Gatos", 15.99, 45);

        Product racaoPassaro = new Product("Ração para Pássaros (Sementes Misturadas)", 14.99, 200);
        Product petiscoPassaro = new Product("Petisco para Pássaros (Frutas e Sementes)", 9.99, 150);
        Product suplementoAlimentarPassaro = new Product("Suplemento Alimentar para Pássaros", 19.99, 100);
        Product comidaEnlatadaPassaro = new Product("Comida Enlatada para Pássaros", 12.99, 80);
        Product farinhaPassaro = new Product("Farinha para Pássaros", 7.99, 50);

        Product racaoRoedores = new Product("Ração para Roedores", 19.99, 90);
        Product fenoRoedores = new Product("Feno para Roedores", 14.99, 100);
        Product petiscoRoedores = new Product("Petisco para Roedores (Vegetais Secos)", 8.99, 150);
        Product suplementoAlimentarRoedores = new Product("Suplemento Alimentar para Roedores", 13.99, 80);
        Product comidaEnlatadaRoedores = new Product("Comida Enlatada para Roedores", 10.99, 70);

        Product racaoPeixe = new Product("Ração para Peixes (Flocos)", 10.99, 200);
        Product racaoGranuladoPeixe = new Product("Ração Granulada para Peixes", 12.99, 180);
        Product suplementoAlimentarPeixe = new Product("Suplemento Alimentar para Peixes", 15.99, 120);
        Product comidaCongeladaPeixe = new Product("Comida Congelada para Peixes (Artemia, Daphnia)", 18.99, 50);
        Product comidaVivaPeixe = new Product("Comida Viva para Peixes (Vermes e Larvas)", 22.99, 30);

        comida.add(racaoCao);
        comida.add(petiscoCao);
        comida.add(racaoFilhoteCao);
        comida.add(comidaEnlatadaCao);
        comida.add(suplementoAlimentarCao);

        comida.add(racaoGato);
        comida.add(petiscoGato);
        comida.add(racaoFilhoteGato);
        comida.add(comidaEnlatadaGato);
        comida.add(suplementoAlimentarGato);

        comida.add(racaoPassaro);
        comida.add(petiscoPassaro);
        comida.add(suplementoAlimentarPassaro);
        comida.add(comidaEnlatadaPassaro);
        comida.add(farinhaPassaro);

        comida.add(racaoRoedores);
        comida.add(fenoRoedores);
        comida.add(petiscoRoedores);
        comida.add(suplementoAlimentarRoedores);
        comida.add(comidaEnlatadaRoedores);

        comida.add(racaoPeixe);
        comida.add(racaoGranuladoPeixe);
        comida.add(suplementoAlimentarPeixe);
        comida.add(comidaCongeladaPeixe);
        comida.add(comidaVivaPeixe);


        // habitat field
        Product aquarioVidro = new Product("Aquário de Vidro", 199.99, 20);
        Product aquarioAcrilico = new Product("Aquário de Acrílico", 149.99, 30);
        Product kitAquarioCompleto = new Product("Kit de Aquário Completo (filtro e luz)", 299.99, 15);
        Product aquarioPlantado = new Product("Aquário Plantado", 249.99, 10);
        Product estufaBetta = new Product("Estufa Decorativa para Betta", 89.99, 25);
        Product tanqueAguaSalgada = new Product("Tanque para Água Salgada", 499.99, 5);
        Product lagoArtificial = new Product("Lago Artificial", 999.99, 3);

        Product gaiolaPequena = new Product("Gaiola Pequena para Pássaros", 89.99, 50);
        Product gaiolaGrande = new Product("Gaiola Grande com Poleiros", 199.99, 20);
        Product aviairo = new Product("Aviário Espaçoso", 499.99, 8);
        Product cupulaSuspensa = new Product("Cúpula Suspensa Decorativa", 149.99, 15);
        Product casaNinho = new Product("Casa-Ninho para Reprodução", 29.99, 40);
        Product gaiolaBrinquedos = new Product("Gaiola com Brinquedos Integrados", 129.99, 25);

        Product camaGato = new Product("Cama para Gatos", 49.99, 40);
        Product arranhadorPlataforma = new Product("Arranhador com Plataforma", 89.99, 25);
        Product torreEscalada = new Product("Torre de Escalada para Gatos", 159.99, 15);
        Product tocaGato = new Product("Toca Fechada para Gatos", 69.99, 30);
        Product redeParede = new Product("Rede Suspensa para Gatos", 39.99, 20);
        Product caixaTransporteGato = new Product("Caixa de Transporte para Gatos", 79.99, 35);

        Product casaCachorro = new Product("Casa de Cachorro", 129.99, 20);
        Product camaCachorro = new Product("Cama para Cães", 59.99, 40);
        Product cabanaCachorro = new Product("Cabana Decorativa para Cães", 89.99, 15);
        Product cercadoCachorro = new Product("Cercado Modular para Cães", 199.99, 10);
        Product caixaTransporteCachorro = new Product("Caixa de Transporte para Cães", 99.99, 25);
        Product parqueCachorro = new Product("Parque de Recreação para Cães", 249.99, 8);

        Product gaiolaRoedores = new Product("Gaiola para Roedores", 99.99, 30);
        Product cercadoRoedores = new Product("Cercado Modular para Roedores", 139.99, 20);
        Product tocaRoedores = new Product("Toca de Madeira para Roedores", 79.99, 15);
        Product casaRoedores = new Product("Casa de Plástico para Roedores", 89.99, 25);
        Product viveiroRoedores = new Product("Viveiro Externo para Roedores", 299.99, 5);

        ArrayList<Product> habitats = Main.products.get(ProductType.HABITAT);
        habitats.add(aquarioVidro);
        habitats.add(aquarioAcrilico);
        habitats.add(kitAquarioCompleto);
        habitats.add(aquarioPlantado);
        habitats.add(estufaBetta);
        habitats.add(tanqueAguaSalgada);
        habitats.add(lagoArtificial);

        habitats.add(gaiolaPequena);
        habitats.add(gaiolaGrande);
        habitats.add(aviairo);
        habitats.add(cupulaSuspensa);
        habitats.add(casaNinho);
        habitats.add(gaiolaBrinquedos);

        habitats.add(camaGato);
        habitats.add(arranhadorPlataforma);
        habitats.add(torreEscalada);
        habitats.add(tocaGato);
        habitats.add(redeParede);
        habitats.add(caixaTransporteGato);

        habitats.add(casaCachorro);
        habitats.add(camaCachorro);
        habitats.add(cabanaCachorro);
        habitats.add(cercadoCachorro);
        habitats.add(caixaTransporteCachorro);
        habitats.add(parqueCachorro);

        habitats.add(gaiolaRoedores);
        habitats.add(cercadoRoedores);
        habitats.add(tocaRoedores);
        habitats.add(casaRoedores);
        habitats.add(viveiroRoedores);

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
        Product sprayBanhoPassaro = new Product("Spray de Banho para Pássaros", 14.50, 50);
        Product poAntiparasitario = new Product("Pó Antiparasitário", 18.99, 40);
        Product saisBanhoPassaro = new Product("Sais para Banho de Pássaros", 10.99, 70);
        Product areiaBanhoSeco = new Product("Areia para Banho Seco", 8.99, 30);
        Product desinfetanteGaiola = new Product("Desinfetante para Gaiolas", 15.50, 40);
        Product escovaGaiola = new Product("Escova para Gaiolas", 9.50, 25);
        Product removedorResiduos = new Product("Removedor de Resíduos", 11.99, 20);
        Product poleiroPedraPomes = new Product("Poleiro de Pedra-Pomes", 13.99, 50);
        Product cortadorUnhasPassaro = new Product("Cortador de Unhas para Pássaros", 16.99, 15);

        Product shampooRoedores = new Product("Shampoo para Roedores", 13.99, 70);
        Product condicionadorRoedores = new Product("Condicionador para Roedores", 15.50, 20);
        Product luvasEscovarRoedores = new Product("Luvas para Escovar Roedores", 11.99, 15);
        Product escovaRoedores = new Product("Escova para Roedores", 9.50, 20);

        Product luvasLimpezaAquario = new Product("Luvas para Limpeza de Aquário", 14.99, 60);
        Product escovaAquario = new Product("Escova para Limpeza de Aquário", 9.99, 50);
        Product removedorAlga = new Product("Removedor de Algas", 15.99, 40);
        Product purificadorAgua = new Product("Purificador de Água para Aquários", 18.99, 70);
        Product condicionadorAgua = new Product("Condicionador de Água", 13.50, 90);
        Product limpadorVidro = new Product("Limpador de Vidro Magnético", 19.99, 35);

        ArrayList<Product> produtosHigiene = Main.products.get(ProductType.HYGIENE);

        produtosHigiene.add(luvasLimpezaAquario);
        produtosHigiene.add(escovaAquario);
        produtosHigiene.add(removedorAlga);
        produtosHigiene.add(purificadorAgua);
        produtosHigiene.add(condicionadorAgua);
        produtosHigiene.add(limpadorVidro);

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
        produtosHigiene.add(shampooPassaro);
        produtosHigiene.add(sprayBanhoPassaro);
        produtosHigiene.add(poAntiparasitario);
        produtosHigiene.add(saisBanhoPassaro);
        produtosHigiene.add(areiaBanhoSeco);
        produtosHigiene.add(desinfetanteGaiola);
        produtosHigiene.add(escovaGaiola);
        produtosHigiene.add(removedorResiduos);
        produtosHigiene.add(poleiroPedraPomes);
        produtosHigiene.add(cortadorUnhasPassaro);

        produtosHigiene.add(shampooRoedores);
        produtosHigiene.add(condicionadorRoedores);
        produtosHigiene.add(luvasEscovarRoedores);
        produtosHigiene.add(escovaRoedores);

        // medicine field
        Product antipulgasCao = new Product("Antipulgas NexGard", 89.99, 50);
        Product vermifugoCao = new Product("Vermífugo Drontal para Cães", 49.99, 40);
        Product antibioticoCao = new Product("Antibiótico para Infecções (prescrição)", 79.99, 30);
        Product antiInflamatorioCao = new Product("Anti-inflamatório para Cães", 59.99, 25);
        Product shampooMedicinalCao = new Product("Shampoo Medicinal para Cães", 39.99, 35);
        Product suplementoCao = new Product("Suplemento Vitamínico para Cães", 29.99, 40);

        Product antipulgasGato = new Product("Antipulgas Bravecto para Gatos", 89.99, 40);
        Product vermifugoGato = new Product("Vermífugo Profender", 49.99, 30);
        Product antiHistaminicoGato = new Product("Anti-histamínico para Gatos", 39.99, 20);
        Product antibioticoGato = new Product("Antibiótico para Infecções (prescrição)", 69.99, 15);
        Product shampooMedicinalGato = new Product("Shampoo Medicinal para Gatos", 29.99, 25);
        Product suplementoGato = new Product("Suplemento de Taurina para Gatos", 19.99, 35);

        Product antiparasitarioPassaro = new Product("Antiparasitário Ivomec", 29.99, 50);
        Product antibioticoPassaro = new Product("Antibiótico Oral para Pássaros", 49.99, 25);
        Product suplementoPassaro = new Product("Suplemento de Vitaminas para Pássaros", 19.99, 40);
        Product antifungicoPassaro = new Product("Antifúngico para Pássaros", 39.99, 30);
        Product probioticoPassaro = new Product("Probiótico para Flora Intestinal", 25.99, 35);
        Product cicatrizanteBicoPatasPassaro = new Product("Cicatrizante para Bico e Patas", 15.99, 20);

        Product antiparasitarioRoedores = new Product("Antiparasitário Stronghold para Roedores", 39.99, 30);
        Product antibioticoRoedores = new Product("Antibiótico Oral para Roedores", 59.99, 20);
        Product suplementoVitaminasRoedores = new Product("Suplemento de Vitaminas para Roedores", 24.99, 25);
        Product antifungicoRoedores = new Product("Antifúngico para Infecções de Pele", 34.99, 15);
        Product antiInflamatorioRoedores = new Product("Anti-inflamatório para Roedores", 49.99, 10);
        Product suplementoCalcioRoedores = new Product("Suplemento de Cálcio para Roedores", 19.99, 20);

        Product antibioticoPeixe = new Product("Antibiótico para Peixes (KanaPlex)", 34.99, 50);
        Product antifungicoPeixe = new Product("Antifúngico para Peixes (Methylene Blue)", 29.99, 40);
        Product antiparasitarioPeixe = new Product("Antiparasitário para Peixes (Malachite Green)", 19.99, 60);
        Product salAquario = new Product("Sal de Aquário (para infecções)", 14.99, 100);
        Product acondicionadorAgua = new Product("Acondicionador de Água (Neutralizador de Cloro)", 12.99, 75);
        Product vitaminaPeixe = new Product("Vitamina Líquida para Peixes", 18.99, 50);

        ArrayList<Product> medicamentos = Main.products.get(ProductType.MEDICINE);
        medicamentos.add(antipulgasCao);
        medicamentos.add(vermifugoCao);
        medicamentos.add(antibioticoCao);
        medicamentos.add(antiInflamatorioCao);
        medicamentos.add(shampooMedicinalCao);
        medicamentos.add(suplementoCao);

        medicamentos.add(antipulgasGato);
        medicamentos.add(vermifugoGato);
        medicamentos.add(antiHistaminicoGato);
        medicamentos.add(antibioticoGato);
        medicamentos.add(shampooMedicinalGato);
        medicamentos.add(suplementoGato);

        medicamentos.add(antiparasitarioPassaro);
        medicamentos.add(antibioticoPassaro);
        medicamentos.add(suplementoPassaro);
        medicamentos.add(antifungicoPassaro);
        medicamentos.add(probioticoPassaro);
        medicamentos.add(cicatrizanteBicoPatasPassaro);

        medicamentos.add(antiparasitarioRoedores);
        medicamentos.add(antibioticoRoedores);
        medicamentos.add(suplementoVitaminasRoedores);
        medicamentos.add(antifungicoRoedores);
        medicamentos.add(antiInflamatorioRoedores);
        medicamentos.add(suplementoCalcioRoedores);

        medicamentos.add(antibioticoPeixe);
        medicamentos.add(antifungicoPeixe);
        medicamentos.add(antiparasitarioPeixe);
        medicamentos.add(salAquario);
        medicamentos.add(acondicionadorAgua);
        medicamentos.add(vitaminaPeixe);

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
        employees.add(new Employee(new Person("Carlos Mendes", 'M', LocalDate.of(1985, 4, 10), 912345678, 123456789), 2500.00, "Especialista em animais"));
        employees.add(new Employee(new Person("Maria Oliveira", 'F', LocalDate.of(1990, 6, 15), 923456789, 987654321), 3000.00, "Gerente"));
        employees.add(new Employee(new Person("Pedro Santos", 'M', LocalDate.of(1982, 2, 20), 934567890, 456789123), 2200.00, "Atendedor de clientes"));
        employees.add(new Employee(new Person("Ana Costa", 'F', LocalDate.of(1988, 8, 30), 945678901, 321654987), 2800.00, "Atendedor de clientes"));
        employees.add(new Employee(new Person("Jorge Almeida", 'M', LocalDate.of(1995, 1, 5), 956789012, 654321789), 3200.00, "Atendedor de clientes"));
        employees.add(new Employee(new Person("Sofia Ferreira", 'F', LocalDate.of(1993, 11, 12), 967890123, 789123456), 2700.00, "Coordenadora"));

        // **Cosméticos para Cães**
        perfumeCao.setCategory(ProductType.COSMETIC);
        cremeParaPelosCao.setCategory(ProductType.COSMETIC);
        loçãoHidratanteCao.setCategory(ProductType.COSMETIC);
        sprayBrilhoCao.setCategory(ProductType.COSMETIC);

// **Cosméticos para Gatos**
        perfumeGato.setCategory(ProductType.COSMETIC);
        cremeParaPelosGato.setCategory(ProductType.COSMETIC);
        loçãoHidratanteGato.setCategory(ProductType.COSMETIC);
        sprayBrilhoGato.setCategory(ProductType.COSMETIC);

// **Cosméticos para Pássaros**
        perfumePassaro.setCategory(ProductType.COSMETIC);
        cremeParaPenasPassaro.setCategory(ProductType.COSMETIC);
        sprayBrilhoPassaro.setCategory(ProductType.COSMETIC);
        loçãoHidratantePassaro.setCategory(ProductType.COSMETIC);

// **Cosméticos para Roedores**
        perfumeRoedores.setCategory(ProductType.COSMETIC);
        cremeParaPelagemRoedores.setCategory(ProductType.COSMETIC);
        sprayBrilhoRoedores.setCategory(ProductType.COSMETIC);
        loçãoHidratanteRoedores.setCategory(ProductType.COSMETIC);

// **Cosméticos para Peixes**
        perfumePeixe.setCategory(ProductType.COSMETIC);
        sprayBrilhoPeixe.setCategory(ProductType.COSMETIC);
        loçãoHidratantePeixe.setCategory(ProductType.COSMETIC);
        condicionadorAquaPeixe.setCategory(ProductType.COSMETIC);

        // **Rações e Alimentos para Cães**
        racaoCao.setCategory(ProductType.FOOD);
        petiscoCao.setCategory(ProductType.FOOD);
        racaoFilhoteCao.setCategory(ProductType.FOOD);
        comidaEnlatadaCao.setCategory(ProductType.FOOD);
        suplementoAlimentarCao.setCategory(ProductType.FOOD);

// **Rações e Alimentos para Gatos**
        racaoGato.setCategory(ProductType.FOOD);
        petiscoGato.setCategory(ProductType.FOOD);
        racaoFilhoteGato.setCategory(ProductType.FOOD);
        comidaEnlatadaGato.setCategory(ProductType.FOOD);
        suplementoAlimentarGato.setCategory(ProductType.FOOD);

// **Rações e Alimentos para Pássaros**
        racaoPassaro.setCategory(ProductType.FOOD);
        petiscoPassaro.setCategory(ProductType.FOOD);
        suplementoAlimentarPassaro.setCategory(ProductType.FOOD);
        comidaEnlatadaPassaro.setCategory(ProductType.FOOD);
        farinhaPassaro.setCategory(ProductType.FOOD);

// **Rações e Alimentos para Roedores**
        racaoRoedores.setCategory(ProductType.FOOD);
        fenoRoedores.setCategory(ProductType.FOOD);
        petiscoRoedores.setCategory(ProductType.FOOD);
        suplementoAlimentarRoedores.setCategory(ProductType.FOOD);
        comidaEnlatadaRoedores.setCategory(ProductType.FOOD);

// **Rações e Alimentos para Peixes**
        racaoPeixe.setCategory(ProductType.FOOD);
        racaoGranuladoPeixe.setCategory(ProductType.FOOD);
        suplementoAlimentarPeixe.setCategory(ProductType.FOOD);
        comidaCongeladaPeixe.setCategory(ProductType.FOOD);
        comidaVivaPeixe.setCategory(ProductType.FOOD);

        aquarioVidro.setCategory(ProductType.HABITAT);
        aquarioAcrilico.setCategory(ProductType.HABITAT);
        kitAquarioCompleto.setCategory(ProductType.HABITAT);
        aquarioPlantado.setCategory(ProductType.HABITAT);
        estufaBetta.setCategory(ProductType.HABITAT);
        tanqueAguaSalgada.setCategory(ProductType.HABITAT);
        lagoArtificial.setCategory(ProductType.HABITAT);

        gaiolaPequena.setCategory(ProductType.HABITAT);
        gaiolaGrande.setCategory(ProductType.HABITAT);
        aviairo.setCategory(ProductType.HABITAT);
        cupulaSuspensa.setCategory(ProductType.HABITAT);
        casaNinho.setCategory(ProductType.HABITAT);
        gaiolaBrinquedos.setCategory(ProductType.HABITAT);

        camaGato.setCategory(ProductType.HABITAT);
        arranhadorPlataforma.setCategory(ProductType.HABITAT);
        torreEscalada.setCategory(ProductType.HABITAT);
        tocaGato.setCategory(ProductType.HABITAT);
        redeParede.setCategory(ProductType.HABITAT);
        caixaTransporteGato.setCategory(ProductType.HABITAT);

        casaCachorro.setCategory(ProductType.HABITAT);
        camaCachorro.setCategory(ProductType.HABITAT);
        cabanaCachorro.setCategory(ProductType.HABITAT);
        cercadoCachorro.setCategory(ProductType.HABITAT);
        caixaTransporteCachorro.setCategory(ProductType.HABITAT);
        parqueCachorro.setCategory(ProductType.HABITAT);

        gaiolaRoedores.setCategory(ProductType.HABITAT);
        cercadoRoedores.setCategory(ProductType.HABITAT);
        tocaRoedores.setCategory(ProductType.HABITAT);
        casaRoedores.setCategory(ProductType.HABITAT);
        viveiroRoedores.setCategory(ProductType.HABITAT);

        shampooCao.setCategory(ProductType.HYGIENE);
        condicionadorCao.setCategory(ProductType.HYGIENE);
        luvasEscovarCao.setCategory(ProductType.HYGIENE);
        escovaCao.setCategory(ProductType.HYGIENE);
        escovaDentesCao.setCategory(ProductType.HYGIENE);
        pastaDentesCao.setCategory(ProductType.HYGIENE);

        shampooGato.setCategory(ProductType.HYGIENE);
        condicionadorGato.setCategory(ProductType.HYGIENE);
        luvasEscovarGato.setCategory(ProductType.HYGIENE);
        escovaGato.setCategory(ProductType.HYGIENE);
        escovaDentesGato.setCategory(ProductType.HYGIENE);
        pastaDentesGato.setCategory(ProductType.HYGIENE);

        shampooPassaro.setCategory(ProductType.HYGIENE);
        sprayBanhoPassaro.setCategory(ProductType.HYGIENE);
        poAntiparasitario.setCategory(ProductType.HYGIENE);
        saisBanhoPassaro.setCategory(ProductType.HYGIENE);
        areiaBanhoSeco.setCategory(ProductType.HYGIENE);
        desinfetanteGaiola.setCategory(ProductType.HYGIENE);
        escovaGaiola.setCategory(ProductType.HYGIENE);
        removedorResiduos.setCategory(ProductType.HYGIENE);
        poleiroPedraPomes.setCategory(ProductType.HYGIENE);
        cortadorUnhasPassaro.setCategory(ProductType.HYGIENE);

        shampooRoedores.setCategory(ProductType.HYGIENE);
        condicionadorRoedores.setCategory(ProductType.HYGIENE);
        luvasEscovarRoedores.setCategory(ProductType.HYGIENE);
        escovaRoedores.setCategory(ProductType.HYGIENE);

        luvasLimpezaAquario.setCategory(ProductType.HYGIENE);
        escovaAquario.setCategory(ProductType.HYGIENE);
        removedorAlga.setCategory(ProductType.HYGIENE);
        purificadorAgua.setCategory(ProductType.HYGIENE);
        condicionadorAgua.setCategory(ProductType.HYGIENE);
        limpadorVidro.setCategory(ProductType.HYGIENE);

        antipulgasCao.setCategory(ProductType.MEDICINE);
        vermifugoCao.setCategory(ProductType.MEDICINE);
        antibioticoCao.setCategory(ProductType.MEDICINE);
        antiInflamatorioCao.setCategory(ProductType.MEDICINE);
        shampooMedicinalCao.setCategory(ProductType.MEDICINE);
        suplementoCao.setCategory(ProductType.MEDICINE);

        antipulgasGato.setCategory(ProductType.MEDICINE);
        vermifugoGato.setCategory(ProductType.MEDICINE);
        antiHistaminicoGato.setCategory(ProductType.MEDICINE);
        antibioticoGato.setCategory(ProductType.MEDICINE);
        shampooMedicinalGato.setCategory(ProductType.MEDICINE);
        suplementoGato.setCategory(ProductType.MEDICINE);

        antiparasitarioPassaro.setCategory(ProductType.MEDICINE);
        antibioticoPassaro.setCategory(ProductType.MEDICINE);
        suplementoPassaro.setCategory(ProductType.MEDICINE);
        antifungicoPassaro.setCategory(ProductType.MEDICINE);
        probioticoPassaro.setCategory(ProductType.MEDICINE);
        cicatrizanteBicoPatasPassaro.setCategory(ProductType.MEDICINE);

        antiparasitarioRoedores.setCategory(ProductType.MEDICINE);
        antibioticoRoedores.setCategory(ProductType.MEDICINE);
        suplementoVitaminasRoedores.setCategory(ProductType.MEDICINE);
        antifungicoRoedores.setCategory(ProductType.MEDICINE);
        antiInflamatorioRoedores.setCategory(ProductType.MEDICINE);
        suplementoCalcioRoedores.setCategory(ProductType.MEDICINE);

        antibioticoPeixe.setCategory(ProductType.MEDICINE);
        antifungicoPeixe.setCategory(ProductType.MEDICINE);
        antiparasitarioPeixe.setCategory(ProductType.MEDICINE);
        salAquario.setCategory(ProductType.MEDICINE);
        acondicionadorAgua.setCategory(ProductType.MEDICINE);
        vitaminaPeixe.setCategory(ProductType.MEDICINE);


        // Guardar todos os produtos
        saveData();
    }
}