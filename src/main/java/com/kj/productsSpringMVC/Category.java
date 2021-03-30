package com.kj.productsSpringMVC;

public enum Category {
    FOOD("spozywcze"),
    HOME("gospodarstwo"),
    OTHER("inne");

    private final String description;

    Category(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
