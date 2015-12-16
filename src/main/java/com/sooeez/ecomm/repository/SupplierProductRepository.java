package com.sooeez.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sooeez.ecomm.domain.SupplierProduct;

public interface SupplierProductRepository extends JpaRepository< SupplierProduct, Long >, JpaSpecificationExecutor< SupplierProduct >
{
	@Query( "SELECT sp FROM SupplierProduct as sp WHERE sp.productId = ( SELECT id FROM Product WHERE sku = ?1 ) AND sp.supplierId = ?2" )
	SupplierProduct getSupplierProductByProductSkuAndSupplierId( String sku, Long supplierId );
}
