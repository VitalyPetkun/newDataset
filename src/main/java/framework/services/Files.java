package framework.services;

public enum Files {

    FRAMEWORK_CONFIG("config.properties");

    private String file;

    Files(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
