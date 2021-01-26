package com.sovliv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sovliv.model.Data;
import com.sovliv.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        var format = new SimpleDateFormat("dd.MM.yy HH:mm");
        var mapper = new ObjectMapper();
        var result = new ArrayList<Long>();

        try {
            var data = mapper.readValue(new File("./src/main/resources/json/tickets.json"), Data.class);

            var arrivalDate = data.getTickets().stream()
                    .map(Ticket::getArrival_date)
                    .collect(Collectors.toList());

            var arriveTime = data.getTickets().stream()
                    .map(Ticket::getArrival_time)
                    .collect(Collectors.toList());

            var departureDate = data.getTickets().stream()
                    .map(Ticket::getDeparture_date)
                    .collect(Collectors.toList());

            var departureTime = data.getTickets().stream()
                    .map(Ticket::getDeparture_time)
                    .collect(Collectors.toList());

            for (int i = 0; i < arrivalDate.size(); i++) {
                var departure = departureDate.get(i) + " " + departureTime.get(i);
                var arrive = arrivalDate.get(i) + " " + arriveTime.get(i);

                try {

                    var departureParse = format.parse(departure);
                    var arriveParse = format.parse(arrive);

                    var diff = arriveParse.getTime() - departureParse.getTime();
                    var minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

                    result.add(minutes);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            var average = result.stream()
                    .mapToInt(Long::intValue)
                    .average();

            System.out.println("average is - " + average.toString());

            //percentile

            Collections.sort(result);

            var index = (int) Math.ceil(90 / 100.0 * result.size());
            var percentile = result.get(index - 1);

            System.out.println("percentile is - " + percentile.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
