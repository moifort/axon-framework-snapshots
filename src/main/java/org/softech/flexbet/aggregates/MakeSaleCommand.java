/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softech.flexbet.aggregates;

import org.axonframework.commandhandling.*;

import java.sql.*;

/**
 *
 * @author Abongwa
 */
public class MakeSaleCommand {
    @TargetAggregateIdentifier
    private String id;

    private String agent_id;
    private String product_id;
    private double product_price;
    private Timestamp sale_date_time;

    public MakeSaleCommand(String id, String agent_id, String product_id, double product_price, Timestamp sale_date_time) {
        this.id = id;
        this.agent_id = agent_id;
        this.product_id = product_id;
        this.product_price = product_price;
        this.sale_date_time = sale_date_time;
    }

    public String getId() {
        return id;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public Timestamp getSale_date_time() {
        return sale_date_time;
    }
}
