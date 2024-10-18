package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberRegisterAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDTO insertDto = new MemberDTO();
		
		insertDto.setUserId(request.getParameter("userId"));
		insertDto.setName(request.getParameter("name"));
		insertDto.setPassword(request.getParameter("password"));		
		
		// service 호출
		MemberService service = new MemberServiceImpl();
		boolean insertFlag = service.join(insertDto);
		
		if(!insertFlag) {
			path = "/member/register.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
