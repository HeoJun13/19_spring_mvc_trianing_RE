package com.spring.training.member.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.training.member.dao.MemberDAOPT;
import com.spring.training.member.dto.MemberDTO;

@Service
public class MemberServiceImplPT implements MemberSevicePT {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private String FILE_REPO_PATH = "C:\\spring_mvc_member_file_repo\\";
	private org.mybatis.logging.Logger logger = org.mybatis.logging.LoggerFactory.getLogger(MemberServiceImplPT.class);
	
	@Autowired
	private MemberDAOPT memberDAO;

	@Override
	public void addMember(MemberDTO memberDTO) {
		 memberDTO.setPasswd(bCryptPasswordEncoder.encode(memberDTO.getPasswd() ));
		 MemberDAOPT.insertMember(memberDTO);
	}
	
}
