package com.mspringjpadata.onetomanyexample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mspringjpadata.onetomanyexample.model.Items;

@Repository
public interface ItemsRepository extends CrudRepository<Items, Long> {

}
