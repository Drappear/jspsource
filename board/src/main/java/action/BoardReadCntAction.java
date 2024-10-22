package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReadCntAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService service = new BoardServiceImpl();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 조회수 업데이트
		service.hitUpdate(bno);
		
		path += "?bno="+bno;
		
		return new ActionForward(path, true);
	}

}
