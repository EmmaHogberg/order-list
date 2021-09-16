package io.emma;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBean {

    private final Integer orderId;
    private final Date orderDate;
    private final String region;
    private final String rep1;
    private final String rep2;
    private final String item;
    private final BigDecimal units;
    private final BigDecimal unitCost;
    private final BigDecimal total;


    public OrderBean(Integer orderId, Date orderDate, String region, String rep1, String rep2, String item, BigDecimal units, BigDecimal unitCost, BigDecimal total) {
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

    public Date getOrderDate() {
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

    public BigDecimal getUnits() {
        return units;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public BigDecimal getTotal() {
        return total;
    }
}