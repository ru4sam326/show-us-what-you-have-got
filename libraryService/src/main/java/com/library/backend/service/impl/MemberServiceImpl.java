package com.library.backend.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.backend.dao.MemberDao;
import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;
import com.library.backend.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public List<PendingRequest> getPendingRequestsForSpecifiedUser(Member member) {
		return memberDao.getPendingRequestsForSpecifiedUser(member);
	}

	public List<PendingRequest> getPendingRequestsForAll() {
		return memberDao.getPendingRequestsForAll();
	}

	public List<ReservedBook> getReservedBooksByUser(Member member) {
		return memberDao.getReservedBooksByUser(member);
	}

}
