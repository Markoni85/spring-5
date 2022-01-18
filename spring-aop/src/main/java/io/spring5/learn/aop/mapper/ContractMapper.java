package io.spring5.learn.aop.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.spring5.learn.aop.entities.Contract;
import io.spring5.learn.aop.entities.ContractDTO;

@Component
public class ContractMapper {

	public Contract mapToContract(ContractDTO dto) {
		Contract c = new Contract();
		c.setId(dto.getContractId());
		c.setContractDate(dto.getContractDate());
		c.setContractNumber(dto.getContractNumber());
		c.setInterestRate(dto.getInterestRate());
		c.setPayment(dto.getPayment());
		
		return c;
	}
	
	public ContractDTO mapToContractDto(Contract c) {
		ContractDTO dto = new ContractDTO();
		dto.setContractId(c.getId());
		dto.setContractDate(c.getContractDate());
		dto.setInterestStartDate(c.getInterestStartDate());
		dto.setContractNumber(c.getContractNumber());
		dto.setInterestRate(c.getInterestRate());
		dto.setPayment(c.getPayment());
		
		return dto;
	}
	
	public List<ContractDTO> mapToListDto(List<Contract> contracts) {
		return contracts.stream().map( c -> mapToContractDto(c))
				.collect(Collectors.toList());
	}
}
