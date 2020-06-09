package com.example.bfastutente.Model;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusModel {

    private String tv_status;

    public OrderStatusModel(String tv_status) {
        this.tv_status = tv_status;
    }

    public String getTv_status() {
        return tv_status;
    }

    public void setTv_status(String tv_status) {
        this.tv_status = tv_status;
    }


    public static List<OrderStatusModel> getStoreDetail() {
        List<OrderStatusModel> status = new ArrayList<OrderStatusModel>();
        status.add(new OrderStatusModel("Ordine Inviato"));
        status.add(new OrderStatusModel("Ordine accettato"));
        status.add(new OrderStatusModel("Ordine Preparato"));
        status.add(new OrderStatusModel("Ordine Consegnato"));
        return status;
    }

}
