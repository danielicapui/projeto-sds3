package com.uern.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uern.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>
{

}
