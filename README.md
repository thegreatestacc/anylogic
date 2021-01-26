# anylogic

при запуске через cmd получаю следующую ошибку, ругается на библиотеку jackson.databind, хотя в dependency она есть и в папке m2 соответственно находится.
удалял полностью библиотеку из m2, но не помогло, так же ребилдил проект.
не знаю почему в Main класс не получается импортировать Data и Ticket.
через среду разработки программа работает корректно

Main.java:3: error: package com.fasterxml.jackson.databind does not exist
import com.fasterxml.jackson.databind.ObjectMapper;
                                     ^
Main.java:4: error: package com.sovliv.model does not exist
import com.sovliv.model.Data;
                       ^
Main.java:5: error: package com.sovliv.model does not exist
import com.sovliv.model.Ticket;
                       ^
Main.java:20: error: cannot find symbol
        var mapper = new ObjectMapper();
                         ^
  symbol:   class ObjectMapper
  location: class Main
Main.java:24: error: cannot find symbol
            var data = mapper.readValue(new File("./src/main/resources/json/tickets.json"), Data.class);
                                                                                            ^
  symbol:   class Data
  location: class Main
Main.java:27: error: cannot find symbol
                    .map(Ticket::getArrival_date)
                         ^
  symbol:   variable Ticket
  location: class Main
Main.java:31: error: cannot find symbol
                    .map(Ticket::getArrival_time)
                         ^
  symbol:   variable Ticket
  location: class Main
Main.java:35: error: cannot find symbol
                    .map(Ticket::getDeparture_date)
                         ^
  symbol:   variable Ticket
  location: class Main
Main.java:39: error: cannot find symbol
                    .map(Ticket::getDeparture_time)
                         ^
  symbol:   variable Ticket
  location: class Main
9 errors
error: compilation failed
