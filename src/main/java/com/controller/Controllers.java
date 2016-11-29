package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Account;
import com.dao.Dao;
import com.db.SpitterRepository;
import com.db.SpittleRepository;

@Controller
public class Controllers {
	
	private Logger logger=LoggerFactory.getLogger(Controllers.class);
	
	@Autowired
	SpitterRepository spitterRepository;
	
	@Autowired
	Dao dao;
	
	@Autowired
	SpittleRepository spittleRepository;
	
	public Controllers() {
		logger.info("´´½¨Controllers¿ØÖÆ");
	}

	@RequestMapping(value = { "index", "/" })
	public String show(Model model) {
		List<Account> lists= dao.queryAccountAll();
		for(Account a:lists){
			logger.info(a.toString());
		}
		model.addAttribute("model", lists);
		return "index";
	}
	
	@RequestMapping("create")
	public String CreateAccount(Model model,Account account){
		if(account!=null){
			account.setId(null);
			logger.info(account.toString());
			account= dao.cretaeAccount(account);
			model.addAttribute("model", account);
			logger.info(account.toString());
		}
		return "index";
	}
	
	@RequestMapping("queryAccountByKey")
	public String queryAccountByKey(Model model ,Account account){
		if(account!=null){
			if(account.getId()!=0){
				Account result= dao.getAccountById(account.getId());
				if(result!=null){
					
					logger.info(result.toString());
					model.addAttribute("model", result);
				}
			}
		}
		return "index";
	}

}
