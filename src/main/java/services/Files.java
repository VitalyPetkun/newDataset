package services;

public enum Files {

    CONFIG_PROPERTIES("config.properties"),
    IMAGE("&Изображение");

    private String file;

    Files(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
