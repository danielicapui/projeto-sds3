package com.uern.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uern.dsvendas.dto.SaleSucessDTO;
import com.uern.dsvendas.dto.SaleSumDTO;
import com.uern.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>
{
	@Query("SELECT new com.uern.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO>amountGroupedBySeller();
	@Query("SELECT new com.uern.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO>sucessGroupedBySeller();
}
