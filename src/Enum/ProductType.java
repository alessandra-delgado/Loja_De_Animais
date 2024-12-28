package src.Enum;

import java.nio.file.ProviderNotFoundException;

public enum ProductType {
    ANIMAL_REAL_LAND,
    ANIMAL_REAL_AERIAL,
    ANIMAL_REAL_AQUATIC,
    ANIMAL_IMAGINARY_LAND,
    ANIMAL_IMAGINARY_AERIAL,
    ANIMAL_IMAGINARY_AQUATIC,
    COSMETIC,
    FOOD,
    HABITAT,
    HYGIENE,
    MEDICINE,
    NONE;

    @Override
    public String toString() {
        return switch (this) {
            case ANIMAL_REAL_LAND -> "Animal Real Terrestre";
            case ANIMAL_REAL_AERIAL -> "Animal Real Aéreo";
            case ANIMAL_REAL_AQUATIC -> "Animal Real Aquático";
            case ANIMAL_IMAGINARY_LAND -> "Animal Imaginário Terrestre";
            case ANIMAL_IMAGINARY_AERIAL -> "Animal Imaginário Aéreo";
            case ANIMAL_IMAGINARY_AQUATIC -> "Animal Imaginário Aquático";
            case COSMETIC -> "Cosmético";
            case FOOD -> "Comida";
            case HABITAT -> "Habitat";
            case HYGIENE -> "Higiene";
            case MEDICINE -> "Medicina";
            case NONE -> "Sem categoria";
        };
    }
    public String getFilePath(){
     switch (this){
         case COSMETIC:
             return "Cosmetics/Cosmetics.dat";
         case FOOD:
             return "Food/Food.dat";
         case HABITAT:
             return "Habitat/Habitat.dat";
         case HYGIENE:
             return "Hygiene/Hygiene.dat";
         case MEDICINE:
             return "Medicine/Medicine.dat";
         default:
             throw new ProviderNotFoundException("Categoria de produto não encontrada");
     }
    }
}
