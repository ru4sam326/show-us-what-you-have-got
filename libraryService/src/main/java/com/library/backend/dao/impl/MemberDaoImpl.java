package com.library.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.backend.dao.MemberDao;
import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;

@Repository("memberDao")
public class MemberDaoImpl  extends AbstractDao implements MemberDao {

	@SuppressWarnings("unchecked")
	public List<PendingRequest> getPendingRequestsForSpecifiedUser(Member member) {
			System.out.println("DAO author provided : " +  member.getName());
			Criteria criteria = getSession().createCriteria(PendingRequest.class);
			criteria.add(Restrictions.eq("member_id",member.getMemberId()));
			List<PendingRequest> list = criteria.list();
			System.out.println("List size : " + list.size());
			return list;
	}

	@SuppressWarnings("unchecked")
	public List<PendingRequest> getPendingRequestsForAll() {
		Criteria criteria = getSession().createCriteria(PendingRequest.class);
		List<PendingRequest> list = criteria.list();
		System.out.println("List size : " + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ReservedBook> getReservedBooksByUser(Member member) {
		System.out.println("DAO author provided : " +  member.getName());
		Criteria criteria = getSession().createCriteria(ReservedBook.class);
		criteria.add(Restrictions.eq("member_id",member.getMemberId()));
		List<ReservedBook> list = criteria.list();
		System.out.println("List size : " + list.size());
		return list;
	}

}
