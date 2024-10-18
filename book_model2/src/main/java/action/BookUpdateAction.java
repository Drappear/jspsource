package action;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDTO;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookUpdateAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BookDTO updateDto = new BookDTO();
		// PK
		updateDto.setCode(Integer.parseInt(request.getParameter("code")));
		// 수정할 컬럼
		updateDto.setPrice(Integer.parseInt(request.getParameter("price")));
		updateDto.setDescription(request.getParameter("description"));
		
		String keyword = request.getParameter("keyword");
		
		// service
		BookService service = new BookServiceImpl();
		boolean updateFlag = service.update(updateDto);
		
		if(updateFlag) {
			// 성공시
			path += "?code="+updateDto.getCode()+"&keyword="+URLEncoder.encode(keyword, "utf-8");
		} else {
			// 실패시
			path ="/modify.do?code="+updateDto.getCode()+"&keyword="+URLEncoder.encode(keyword, "utf-8");
		}
		
		
		return new ActionForward(path, true);
	}

}
