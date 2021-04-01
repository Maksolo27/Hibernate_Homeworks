package com.itvdn.javastarter.test.simple_dao.entity;

public class Orders {

    private long id;
    private Car c;
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getC() {
        return c;
    }

    public void setC(Car c) {
        this.c = c;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
