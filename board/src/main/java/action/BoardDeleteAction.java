package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardDeleteAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService service = new BoardServiceImpl();
		
		BoardDTO deleteDto = new BoardDTO();
		
		deleteDto.setBno(Integer.parseInt(request.getParameter("bno")));
		deleteDto.setPassword(request.getParameter("password"));
		
		boolean deleteFlag = service.delete(deleteDto.getBno(), deleteDto.getPassword());
		
		if(!deleteFlag) {
			path = "/modify.do?bno="+deleteDto.getBno();
		}
		
		return new ActionForward(path, true);
	}

}
