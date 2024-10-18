package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberLoginAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		MemberDTO loginDto = new MemberDTO();
		loginDto.setUserId(request.getParameter("userId"));
		loginDto.setPassword(request.getParameter("password"));		
		
		// service 호출
		MemberService service = new MemberServiceImpl();
		MemberDTO dto = service.login(loginDto);
		
		if(dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", dto);
			path += "?keyword=";
		} else  {
			path = "/member/login.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
