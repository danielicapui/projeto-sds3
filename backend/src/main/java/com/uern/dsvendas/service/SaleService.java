package com.uern.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uern.dsvendas.dto.SaleDTO;
import com.uern.dsvendas.dto.SaleSucessDTO;
import com.uern.dsvendas.dto.SaleSumDTO;
import com.uern.dsvendas.entities.Sale;
import com.uern.dsvendas.repositories.SaleRepository;
import com.uern.dsvendas.repositories.SellerRepository;

@Service
public class SaleService 
{
	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	@Transactional(readOnly=true)
	public Page<SaleDTO> findAll(Pageable pageable)
	{
		sellerRepository.findAll();
		Page<Sale>result=repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	@Transactional(readOnly=true)		
	public List<SaleSumDTO>amountGroupedBySeller()
	{
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly=true)		
	public List<SaleSucessDTO>sucessGroupedBySeller()
	{
		return repository.sucessGroupedBySeller();
	}
}
