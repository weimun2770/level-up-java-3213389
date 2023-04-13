package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TicketUtils {

    public static void parseCSVfile(String fileName) {
        if(!fileName.endsWith(".csv")) {
            System.out.println("Invalid file format. It is not a CSV file");
            return;
        }

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            List<TicketHolder> ticketHolders = new BufferedReader(fileReader)
                                        .lines()
                                        .skip(1)
                                        .map(line -> {
                                            String result[] = line.split(",");
                                            return new TicketHolder(result[0].trim(), Integer.valueOf(result[1].trim()));
                                        })
                                        .collect(Collectors.toList());
            fileReader.close();

            checkTicket(ticketHolders);

        } catch (IOException e) {
            System.out.println("Failed to parse CSV file " + e);
        }
    }

    public static void checkTicket(List<TicketHolder> ticketHolders) {
        ticketHolders
        .stream()
        .forEachOrdered(
            ticketHolder -> {
                if(ticketHolder.getQuantity() <= 0) {
                    ticketHolder.printNotAllowMessage();
                } else {
                    ticketHolder.printAllowMessage();
                }
            }
        );
    }
}
