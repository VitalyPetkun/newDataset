package framework.services;

public enum ConfigVariables {

    BROWSER_NAME("browserName"),
    WAITING_TIME("waitingTime"),
    SLEEP_TIME("sleepTime");

    private String variables;

    private ConfigVariables(String variables) {
        this.variables = variables;
    }

    public String getVariables() {
        return variables;
    }
}
