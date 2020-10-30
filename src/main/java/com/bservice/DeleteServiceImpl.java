package com.bservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdao.IdeleteDao;
import com.domain.User;

@Service
@Transactional
public class DeleteServiceImpl implements IdeleteService {
	
	@Autowired
	private IdeleteDao userDaoImpl;	

	/* Delete a record */
	@Override
	public void deleteUserById(User user) {
		userDaoImpl.delete(user);		
	}

	/* Delete all records */
	public void deleteAll() {
		userDaoImpl.deleteAll();		
	}

	@Override
	public String toString() {
		return "DeleteServiceImpl";
	}

}