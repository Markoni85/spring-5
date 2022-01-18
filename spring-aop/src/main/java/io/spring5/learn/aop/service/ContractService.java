package io.spring5.learn.aop.service;

import java.util.List;

import io.spring5.learn.aop.entities.Contract;
import io.spring5.learn.aop.entities.ContractDTO;

/**
 * 
 * @author marko
 *
 * @date Jan 18, 2022
 *
 */
public interface ContractService {

	public ContractDTO createContract(ContractDTO contract);
	public void deleteContract(Long id);
	public ContractDTO getContract(Long id);
	public ContractDTO updateContract(Long id, ContractDTO contract);
	public List<ContractDTO> getAllContracts();
}