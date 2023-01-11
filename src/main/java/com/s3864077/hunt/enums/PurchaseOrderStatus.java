package com.s3864077.hunt.enums;

public enum PurchaseOrderStatus {
    DRAFT("Draft"),
    CONFIRMED("Confirmed"),
    PARTIALLY_AVAILABLE("Partially Available"),
    AVAILABLE("Available"),
    DONE("Done");

    private String value;

    PurchaseOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PurchaseOrderStatus fromValue(String value) {
        for (PurchaseOrderStatus status : values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid purchase order status: " + value);
    }
}

