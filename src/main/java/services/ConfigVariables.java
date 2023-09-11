package services;

public enum ConfigVariables {
    MODEL_FOR_TESTING_URL("modelForTestingUrl");

    private String variable;

    ConfigVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
