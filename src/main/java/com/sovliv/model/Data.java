package com.sovliv.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Data{" +
                "tickets=" + tickets +
                '}';
    }
}
