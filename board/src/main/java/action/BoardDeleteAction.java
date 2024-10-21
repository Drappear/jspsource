package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardDeleteAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService service = new BoardServiceImpl();
		
		
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		boolean deleteFlag = service.delete(bno, password);
		
		if(!deleteFlag) {
			path = "/modify.do?bno="+bno;
		}
		
		return new ActionForward(path, true);
	}

}
