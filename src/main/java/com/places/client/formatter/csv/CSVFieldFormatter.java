package com.places.client.formatter.csv;

abstract class CSVFieldFormatter {

    public static final String EMPTY_FIELD = "";

    public abstract Object toField();

    public String format() {
        try {
            Object obj = toField();
            if (obj != null) {
                return String.valueOf(obj);
            } else {
                return EMPTY_FIELD;
            }
        } catch (Exception e) {
            return EMPTY_FIELD;
        }
    }
}
