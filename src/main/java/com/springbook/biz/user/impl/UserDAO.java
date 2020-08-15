package com.springbook.biz.user.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.springbook.biz.user.UserVO;

public class UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JPA로 getUser() 기능 처리");
		
		String jpql = "SELECT b FROM User WHERE id = :id AND password = :password";
		TypedQuery<UserVO> query = em.createQuery(jpql, UserVO.class);
		query.setParameter("id", vo.getId());
		query.setParameter("password", vo.getPassword());
		
		return (UserVO) em.find(UserVO.class, query);
	}
	
}
