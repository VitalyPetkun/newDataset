package framework.services;

public enum Paths {

    FRAMEWORK_RESOURCES_PATH("src\\main\\java\\framework\\resources\\");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
