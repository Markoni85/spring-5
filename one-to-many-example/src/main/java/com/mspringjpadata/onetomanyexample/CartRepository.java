/**
 * 
 */
package com.mspringjpadata.onetomanyexample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mspringjpadata.onetomanyexample.model.Cart;

/**
 * @author mmarinkovic
 *
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
