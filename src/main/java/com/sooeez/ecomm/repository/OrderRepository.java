package com.sooeez.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sooeez.ecomm.domain.Order;

public interface OrderRepository extends JpaRepository< Order, Long >, JpaSpecificationExecutor< Order >
{
	@Query( "UPDATE Order SET qtyTotalItemShipped = ?1 WHERE id = ?2" )
	@Modifying
	@Transactional
	void updateQtyTotalItemShippedById( Integer qtyTotalItemShipped, Long id );
}
