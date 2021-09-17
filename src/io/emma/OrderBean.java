package io.emma;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBean {

    private final Integer orderId;
    private final String orderDate;
    private final String region;
    private final String rep1;
    private final String rep2;
    private final String item;
    private final String units;
    private final String unitCost;
    private final String total;


    public OrderBean(Integer orderId, String orderDate, String region, String rep1, String rep2, String item, String units, String unitCost, String total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.region = region;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.item = item;
        this.units = units;
        this.unitCost = unitCost;
        this.total = total;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRegion() {
        return region;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getItem() {
        return item;
    }

    public String getUnits() {
        return units;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public String getTotal() {
        return total;
    }
}