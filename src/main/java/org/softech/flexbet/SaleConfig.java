package org.softech.flexbet;

import org.axonframework.eventsourcing.*;
import org.axonframework.eventsourcing.eventstore.*;
import org.axonframework.spring.eventsourcing.*;
import org.softech.flexbet.aggregates.*;
import org.springframework.context.annotation.*;

@Configuration
public class SaleConfig {

    // Use this class to auto configure all the bean for the snapshot
    @Bean
    public SpringAggregateSnapshotterFactoryBean snapshotterFactoryBean() {
        return new SpringAggregateSnapshotterFactoryBean();
    }

    // Say to Axon that your Aggregate should snasphot, by overridong the behavior. Put the name to the bean
    // saleRepository , Axon create automaticaly a bean with AGGREGATE_NAME + Repository
    @Bean("saleRepository")
    public EventSourcingRepository<Sale> orderRepository(EventStore eventStore, Snapshotter snapshotter) {
        return new EventSourcingRepository<>(
                Sale.class,
                eventStore,
                new EventCountSnapshotTriggerDefinition(snapshotter, 10));
    }
}
