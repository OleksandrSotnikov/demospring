package com.example.demospring.repositories;

import lombok.Data;

@Data
public class BrandQuery {
    private boolean includeBikes = false;

    public BrandQuery() {
    }

    public BrandQuery(boolean includeBikes) {
        this.includeBikes = includeBikes;
    }
}
