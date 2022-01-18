package io.spring5.learn.aop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.spring5.learn.aop.entities.Contract;
import io.spring5.learn.aop.entities.ContractDTO;
import io.spring5.learn.aop.entities.repository.ContractRepository;
import io.spring5.learn.aop.exceptions.TaskException;
import io.spring5.learn.aop.mapper.ContractMapper;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository repository;
	
	@Autowired
	private ContractMapper mapper;
	
	@Transactional
	@Override
	public ContractDTO createContract(ContractDTO contractDto) {
		Contract c = mapper.mapToContract(contractDto);
		
		return mapper.mapToContractDto(repository.save(c));
	}

	@Transactional
	@Override
	public void deleteContract(Long id) {
		Optional<Contract> contract = repository.findById(id);
		if(!contract.isPresent()) {
			throw new TaskException(HttpStatus.NOT_FOUND,"Task Not Found!");
		}
		
		Contract c = contract.get();
		repository.delete(c);
	}

	@Transactional
	@Override
	public ContractDTO getContract(Long id) {
		Optional<Contract> contract = repository.findById(id);
		if(contract.isPresent()) {
			return mapper.mapToContractDto(contract.get());
		}
		
		
		return null;
	}
	

	@Transactional
	@Override
	public ContractDTO updateContract(Long id, ContractDTO contract) {
		
		Optional<Contract> c = repository.findById(id);
		if(c.isPresent()) {
			Contract cToUpdate = mapper.mapToContract(contract);
			cToUpdate.setId(id);
			
			return mapper.mapToContractDto(repository.save(cToUpdate));
		}
		
		throw new TaskException(HttpStatus.NOT_FOUND, "No Task Found with Id "+id);
	}

	@Override
	public List<ContractDTO> getAllContracts() {
		return mapper.mapToListDto(repository.findAll());
	}

}
