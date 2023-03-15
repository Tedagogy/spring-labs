package com.revature.L5_freight.Repository;

import com.revature.L5_freight.Model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
