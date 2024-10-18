package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDTO;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookListAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 검색
		String keyword = request.getParameter("keyword");
		
		// service 호출
		BookService service = new BookServiceImpl();
		List<BookDTO> list = service.list(keyword);
		
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		
		// request.setAttribute => forward => false
		return new ActionForward(path, false);
	}

}
