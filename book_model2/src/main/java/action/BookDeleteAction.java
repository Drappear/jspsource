package action;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookDeleteAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		String keyword = request.getParameter("keyword");
		
		BookService service = new BookServiceImpl();
		boolean deleteFlag = service.delete(code);
		
		if(!deleteFlag) {
			path = "/modify.do?code="+code;
		} else {
			path += "?keyword="+URLEncoder.encode(keyword, "utf-8");
		}
		
		return new ActionForward(path, true);
	}

}
