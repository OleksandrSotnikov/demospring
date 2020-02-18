package com.example.demospring.repositories;

import lombok.Data;

@Data
public class BikeQuery {
    private Integer engineCapacityFrom;
    private Integer engineCapacityTo;
    private Integer hpFrom;
    private Integer hpTo;

    public BikeQuery() {
    }

    public BikeQuery(Integer engineCapacityFrom, Integer engineCapacityTo) {
        this.engineCapacityFrom = engineCapacityFrom;
        this.engineCapacityTo = engineCapacityTo;
    }


}
