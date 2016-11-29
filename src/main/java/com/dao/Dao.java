package com.dao;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.bean.Account;

public interface Dao {
	
	@Cacheable("account")
	public Account getAccountById(Long id);
	
	@Cacheable("account")
	public List<Account> queryAccountAll();
	
	@CachePut(value= "account",key="#result.id")
	public Account cretaeAccount(Account account);
}
