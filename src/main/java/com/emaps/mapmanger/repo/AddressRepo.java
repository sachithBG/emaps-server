package com.emaps.mapmanger.repo;

import com.emaps.mapmanger.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
