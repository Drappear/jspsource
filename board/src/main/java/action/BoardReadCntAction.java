package action;

import java.net.URLEncoder;

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
		
		// 페이지 나누기
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		// 검색
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		
		// 조회수 업데이트
		service.hitUpdate(bno);
		
		path += "?bno="+ bno + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword=" + keyword;
		
		return new ActionForward(path, true);
	}

}
