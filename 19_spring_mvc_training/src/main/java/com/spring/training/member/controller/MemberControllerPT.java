package com.spring.training.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.member.dto.MemberDTO;
import com.spring.training.member.service.MemberService;
import com.spring.training.member.service.MemberSevicePT;




@Controller
@RequestMapping("/MemberPT")
public class MemberControllerPT {
	
	private String FILE_REPO_PATH = "C:\\spring_mvc_member_file_repo\\";
	//private String FILE_REPO_PATH = 
	
	
	@Autowired
	private MemberSevicePT memberSevicePT;
	
	@GetMapping("/register")
	public ModelAndView register() {
		//System.out.println("111111111");
		return new ModelAndView("/MemberPT/register");
	}
	
	@PostMapping
	public @ResponseBody String register(MultipartHttpServletRequest multipartRequest , HttpServletResponse request) throws IllegalStateException, IOException {
		
		Iterator<String> fileList =  multipartRequest.getFileNames();
		String fileName = "";
		if (fileList.hasNext()) {												
			MultipartFile uploadFile = multipartRequest.getFile(fileList.next()); 
			if (!uploadFile.getOriginalFilename().isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				fileName = fmt.format(new Date()) + "_" + UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(FILE_REPO_PATH + fileName)); 
			}
		
		}
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(multipartRequest.getParameter("memberId"));
		memberDTO.setPasswd(multipartRequest.getParameter("passwd"));
		memberDTO.setProfile(multipartRequest.getParameter("memberNm"));
		memberDTO.setSex(multipartRequest.getParameter("sex"));
		memberDTO.setBirthDt(multipartRequest.getParameter("birthDt"));
		memberDTO.setHp(multipartRequest.getParameter("hp"));
		
		if (multipartRequest.getParameter("smsstsYn") == null) {
			memberDTO.setSmsstsYn("N");
		}
		else
			memberDTO.setSmsstsYn("Y");
		
		memberDTO.setEmail(multipartRequest.getParameter("email"));
		
		if (multipartRequest.getParameter("emailstsYn") == null) {
			memberDTO.setEmailstsYn("N");
		}else
			memberDTO.setEmailstsYn("Y");
			
		
		memberDTO.setZipcode(multipartRequest.getParameter("zipcode"));
		memberDTO.setRoadAddress(multipartRequest.getParameter("roadaddress"));
		memberDTO.setJibunAddress(multipartRequest.getParameter("jibunaddress"));
		memberDTO.setEtc(multipartRequest.getParameter("etc"));
		
		
		memberSevicePT.addMember(memberDTO);
		
	
		return null;
		
		
	}
	
	@GetMapping("/memberList")
	public ModelAndView memberList() {
		return new ModelAndView("/MemberPT/memberList");
	}
	
}
	