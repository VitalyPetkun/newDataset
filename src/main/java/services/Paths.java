package services;

public enum Paths {

    CONFIG_PROPERTIES_PATHS("src\\test\\resources\\"),
    DATASET("C:\\Users\\User\\Desktop\\dataset"),
    NEW_DATASET("C:\\Users\\User\\Desktop\\newDataset");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
