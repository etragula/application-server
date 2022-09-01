package org.example.servers.enums;

public enum HtmlAttributes {

    BACK_TO_FILE_UPLOAD_BUTTON(
            "<form>\n" +
                "<input type=\"button\" value=\"Вернуться к загрузке\" onclick=\"history.back()\">\n" +
            "</form> <br/>"
    );

    private final String value;

    HtmlAttributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
