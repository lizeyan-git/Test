package com.dao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.bean.Account;
import com.dao.Dao;

@Repository
public class DaoImp implements Dao, RowMapper<Account> {

	private Logger logger = LoggerFactory.getLogger(DaoImp.class);

	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	private DataSource dataSource;

	public Account getAccountById(Long id) {
		logger.info("查询数据--Key:"+id);
		Account account = jdbc.queryForObject(String.format("select * from account where id=%d ", id), this);
		return account;
	}

	public List<Account> queryAccountAll() {
		logger.info("查询Account数据");
		List<Account> accounts = jdbc.query("select * from account where id=?", this, "1");
		return accounts;
	}

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setEmail(rs.getString("email"));
		account.setId(rs.getLong("id"));
		account.setPassword(rs.getString("password"));
		account.setUsername(rs.getString("username"));
		account.setPhone(rs.getString("phone"));
		return account;
	}

	public Account cretaeAccount(Account account) {
		logger.info("创建数据");
		SimpleJdbcInsert simple = new SimpleJdbcInsert(dataSource).withTableName("account");
		simple.setGeneratedKeyName("id");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", account.getUsername());
		params.put("password", account.getPassword());
		params.put("email", account.getEmail());
		params.put("phone", account.getPhone());
		account.setId(simple.executeAndReturnKey(params).longValue());
		return account;
	}

}
