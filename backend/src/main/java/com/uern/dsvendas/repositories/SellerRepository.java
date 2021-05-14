package com.uern.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uern.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>
{

}
