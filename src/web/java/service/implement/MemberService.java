package web.java.service.implement;

import java.util.List;

import web.java.dao.MemberDAO;
import web.java.model.Member;

public class MemberService {
    private MemberDAO memberDAO;
    
    public MemberService() {
	memberDAO = new MemberDAO();
    }
    
    public List<Member> findAll(){
	return memberDAO.findAll();
    }
}
