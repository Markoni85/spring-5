package io.spring5.learn.aop.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.spring5.learn.aop.entities.ContractDTO;
/**
 * 
 * @author marko
 *
 * @date Jan 18, 2022
 *
 */
public interface ContractController {

	public ResponseEntity<ContractDTO> createContract(ContractDTO contract);

	public ResponseEntity<List<ContractDTO>> getAllContracts();

	public ResponseEntity<ContractDTO> getContract(Long id);

	public ResponseEntity<ContractDTO> deleteContract(Long id);

	public ResponseEntity<ContractDTO> updateContract(Long id, ContractDTO contract);
}
