package org.softech.flexbet;

import org.axonframework.commandhandling.gateway.*;
import org.softech.flexbet.aggregates.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.time.*;

@Component
public class Simulation implements CommandLineRunner {
    private final CommandGateway commandGateway;

    public Simulation(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public void run(String... strings) throws Exception {
        String saleId = "1";

        // Create sale
        commandGateway.send(new MakeSaleCommand(saleId,
                "1",
                "1",
                100D,
                new Timestamp(System.currentTimeMillis()))
        );

        // Send 50 updates to the SAME product to create a Snapshot when 30 command receive on
        // sale aggregate id 1
        for (int i = 0; i < 30; i++) {
            System.out.println("-----> update sale of id 1 with price: " + i);
            commandGateway.send(new UpdateSaleCommand(saleId, i));
        }

    }
}
