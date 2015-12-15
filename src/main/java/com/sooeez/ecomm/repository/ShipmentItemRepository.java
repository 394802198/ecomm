package com.sooeez.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sooeez.ecomm.domain.ShipmentItem;

public interface ShipmentItemRepository extends JpaRepository< ShipmentItem, Long >
{
	@Query( "SELECT SUM( si.qtyShipped ) FROM ShipmentItem si WHERE si.orderItemId = ?1" )
	int getQtyShippedSumByOrderItemId( Long orderItemId );
}
