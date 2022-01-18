package io.spring5.learn.aop.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring5.learn.aop.entities.Contract;
/**
 * 
 * @author marko
 *
 * @date Jan 18, 2022
 *
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>{

}
