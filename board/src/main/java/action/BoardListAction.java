package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;
import dto.SearchDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardListAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 페이지 나누기
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		// 검색
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		SearchDTO searchDto = new SearchDTO(criteria, keyword, page, amount);
		
		// list
		BoardService service = new BoardServiceImpl();
		
		List<BoardDTO> list = service.listAll(searchDto);
		
		int total = service.getTotalRows();
		PageDTO pageDto = new PageDTO(searchDto, total);
		
		request.setAttribute("list", list);
		request.setAttribute("searchDto", searchDto);
		request.setAttribute("pageDto", pageDto);
					
		return new ActionForward(path, false);
	}

}
