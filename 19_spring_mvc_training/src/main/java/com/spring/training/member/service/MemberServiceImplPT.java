package com.spring.training.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.member.dao.MemberDAOPT;

@Service
public class MemberServiceImplPT implements MemberSevicePT {

	@Autowired
	private MemberDAOPT memberDAO;
	
}
