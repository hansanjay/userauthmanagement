package com.tsd.auth.manager.repo;

import org.tsd.sdk.exception.ApplicationException;

import com.tsd.auth.manager.entity.Address;
import com.tsd.auth.manager.entity.Customer;
import com.tsd.auth.manager.entity.UpdateCustomerReq;

public interface CustomerJDBCRepository {
	Customer findCustomer(String principle) throws ApplicationException;
	Customer findCustomerById(Integer cusId) throws ApplicationException;
	Customer updateCust(Integer cusId, UpdateCustomerReq updateReq) throws ApplicationException;
	Customer updateAddress(Integer cusId, Address address) throws ApplicationException;
	Customer createAddress(Integer cusId, Address address) throws ApplicationException;
	void deleteAddress(Integer id) throws ApplicationException;
}