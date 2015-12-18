package com.sooeez.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sooeez.ecomm.domain.Shipment;

public interface ShipmentRepository extends JpaRepository< Shipment, Long >, JpaSpecificationExecutor< Shipment >
{
	@Modifying
	@Query( "UPDATE Shipment s SET s.shipStatus = ?1 where s.id = ?2" )
	@Transactional
	int updateShipStatus( Integer shipStatus, Long id );

	@Modifying
	@Query( "UPDATE Shipment s SET s.memo = ?1 where s.id = ?2" )
	@Transactional
	int updateMemo( String memo, Long id );

	@Query( "SELECT SUM( s.qtyTotalItemShipped ) FROM Shipment s WHERE s.orderId = ?1" )
	int getQtyShippedSumByOrderId( Long orderId );
}
