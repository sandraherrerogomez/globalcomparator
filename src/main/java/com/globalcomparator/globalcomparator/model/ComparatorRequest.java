package com.globalcomparator.globalcomparator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ComparatorRequest {
    private String city1;
    private String city2;
    private String country1;
    private String country2;
    private double amountCity1;
    private double amountCity2;
}
