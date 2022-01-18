package io.spring5.learn.aop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring5.learn.aop.entities.ContractDTO;
import io.spring5.learn.aop.service.ContractService;

/**
 * 
 * @author marko
 *
 * @date Jan 18, 2022
 *
 */
@RestController
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController {

	@Autowired
	private ContractService contractService;
	
	@PostMapping("/new")
	public ResponseEntity<ContractDTO> createContract(@RequestBody ContractDTO contract) {
		ContractDTO c =  contractService.createContract(contract);
		return new ResponseEntity<ContractDTO>(c, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ContractDTO>> getAllContracts() {
		List<ContractDTO> dtos = contractService.getAllContracts();
		return new ResponseEntity<List<ContractDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContractDTO> getContract(@PathVariable("id") Long id) {
		ContractDTO contract = contractService.getContract(id);
		return new ResponseEntity<ContractDTO>(contract, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ContractDTO> deleteContract(@PathVariable("id") Long id) {
		contractService.deleteContract(id);
		return new ResponseEntity<ContractDTO>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContractDTO> updateContract(@PathVariable("id") Long id, @RequestBody ContractDTO contract) {
		ContractDTO c = contractService.updateContract(id, contract);
		return new ResponseEntity<ContractDTO>(c, HttpStatus.OK);
	}
}
