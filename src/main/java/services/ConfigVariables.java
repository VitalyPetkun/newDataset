package services;

public enum ConfigVariables {
    MODEL_FOR_TESTING_URL("modelForTestingUrl"),
    IMAGES_NUMBER("imagesNumber"),
    IMAGE_FORMAT("imageFormat");

    private String variable;

    ConfigVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
