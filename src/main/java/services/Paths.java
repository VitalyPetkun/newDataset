package services;

public enum Paths {

    CONFIG_PROPERTIES_PATHS("src\\test\\resources\\"),
    DATASET("\\src\\test\\resources\\dataset\\"),
    NEW_DATASET("\\src\\test\\resources\\newDataset\\");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
