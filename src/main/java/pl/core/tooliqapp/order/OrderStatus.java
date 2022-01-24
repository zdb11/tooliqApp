package pl.core.tooliqapp.order;

public enum OrderStatus {
    NEW("Nowy"),
    IN_PROGRESS("W trakcie"),
    COMPLETE("Zrealizowany");

    private final String translate;

    OrderStatus(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}