package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberDupAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		
		// service 호출
		MemberService service = new MemberServiceImpl();
		boolean dupFlag = service.duplicateId(userId);
		
		if(dupFlag) {
			request.setAttribute("dup", "true");
		} else  {
			request.setAttribute("dup", "false");
		}
		
		return new ActionForward(path, true);
	}

}
