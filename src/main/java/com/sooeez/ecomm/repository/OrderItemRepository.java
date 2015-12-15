package com.sooeez.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sooeez.ecomm.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository< OrderItem, Long >
{
	@Query( "UPDATE OrderItem SET qtyShipped = ?1 WHERE id = ?2" )
	@Modifying
	@Transactional
	void updateQtyShippedById( Integer qtyTotalItemShipped, Long id );
}
