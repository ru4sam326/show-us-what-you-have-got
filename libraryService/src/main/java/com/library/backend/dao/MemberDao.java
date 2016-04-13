package com.library.backend.dao;

import java.util.List;

import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;


public interface MemberDao {

	List<PendingRequest> getPendingRequestsForSpecifiedUser(Member member);
	List<PendingRequest> getPendingRequestsForAll();
	List<ReservedBook> getReservedBooksByUser(Member member);
}