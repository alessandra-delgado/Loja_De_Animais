package src.Enum;

public enum AnimalType {
    LAND,
    AERIAL,
    AQUATIC;

    @Override
    public String toString() {
        return switch (this) {
            case AQUATIC -> "Aquático";
            case AERIAL -> "Aéreo";
            case LAND -> "Terrestre";
        };
    }
}
