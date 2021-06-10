package helpers;

public enum ContentType {
    JSON("application/json"),
    HTML("text/html"),
    TEXT("text/plain"),
    NULL(""),
    XML("application/xml");

    private final String type;

    private ContentType(String contentType) {
        this.type = contentType;
    }

    public String getContentType() {
        return this.type;
    }
}
