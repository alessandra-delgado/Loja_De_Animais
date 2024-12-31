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

    public boolean isAnimalReal() {
        return switch (this) {
            case ANIMAL_REAL_LAND, ANIMAL_REAL_AERIAL, ANIMAL_REAL_AQUATIC -> true;
            case ANIMAL_IMAGINARY_LAND, ANIMAL_IMAGINARY_AERIAL, ANIMAL_IMAGINARY_AQUATIC -> false;
            default -> false;
        };
    }

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
        return switch (this) {
            case ANIMAL_REAL_LAND -> "Animal/Real/Land.dat" ;
            case ANIMAL_REAL_AERIAL -> "Animal/Real/Aerial.dat";
            case ANIMAL_REAL_AQUATIC -> "Animal/Real/Aquatic.dat";
            case ANIMAL_IMAGINARY_LAND -> "Animal/Imaginary/Land.dat";
            case ANIMAL_IMAGINARY_AERIAL -> "Animal/Imaginary/Aerial.dat";
            case ANIMAL_IMAGINARY_AQUATIC -> "Animal/Imaginary/Aquatic.dat";
            case COSMETIC -> "Cosmetics/Cosmetics.dat";
            case FOOD -> "Food/Food.dat";
            case HABITAT -> "Habitat/Habitat.dat";
            case HYGIENE -> "Hygiene/Hygiene.dat";
            case MEDICINE -> "Medicine/Medicine.dat";
            default -> throw new ProviderNotFoundException("Categoria de produto não encontrada" + this.name());
        };
    }
}
