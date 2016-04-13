package com.library.backend.service;

import java.util.List;

import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;


public interface MemberService {

	List<PendingRequest> getPendingRequestsForSpecifiedUser(Member member);
	List<PendingRequest> getPendingRequestsForAll();
	List<ReservedBook> getReservedBooksByUser(Member member);
}