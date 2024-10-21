package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService service = new BoardServiceImpl();
		
		BoardDTO updateDto = new BoardDTO();
		
		updateDto.setTitle(request.getParameter("title"));
		updateDto.setContent(request.getParameter("content"));
		updateDto.setBno(Integer.parseInt(request.getParameter("bno")));
		updateDto.setPassword(request.getParameter("password"));
		
		boolean updateFlag = service.update(updateDto);
		
		if(updateFlag) {
			path += "?bno="+updateDto.getBno();
		} else {
			path = "/modify.do?bno="+updateDto.getBno();
		}
		
		return new ActionForward(path, true);
	}

}
