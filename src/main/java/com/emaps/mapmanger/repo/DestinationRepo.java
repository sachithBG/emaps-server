package com.emaps.mapmanger.repo;

import com.emaps.mapmanger.model.Destination;
import com.emaps.mapmanger.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepo extends JpaRepository<Destination, Long> {
    Iterable<Destination> findAllByOrigin(Origin origin);
}
