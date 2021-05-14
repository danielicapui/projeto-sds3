package com.uern.dsvendas.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uern.dsvendas.dto.SaleDTO;
import com.uern.dsvendas.entities.Sale;
import com.uern.dsvendas.repositories.SaleRepository;

@Service
public class SaleService 
{
	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	public Page<SaleDTO> findAll(Pageable pageable)
	{
		Page<Sale>result=repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
			
	
}
