package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ChangeDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberInfoAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ChangeDTO changeDto = new ChangeDTO();
		changeDto.setUserId(request.getParameter("userId"));
		changeDto.setCurrentPassword(request.getParameter("current_password"));
		changeDto.setChangePassword(request.getParameter("change_password"));	
		
		// service 호출
		MemberService service = new MemberServiceImpl();
		boolean updateFlag = service.changePassword(changeDto);
		
		if(updateFlag) {
			HttpSession session = request.getSession();
			session.invalidate();
		} else  {
			path = "/member/info.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
