package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.BoardCreateAction;
import action.BoardDeleteAction;
import action.BoardListAction;
import action.BoardReadAction;
import action.BoardReadCntAction;
import action.BoardReplyAction;
import action.BoardUpdateAction;

/**
 * Servlet implementation class BasicServlet
 */
//									5MB							50MB
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*50)
@WebServlet("*.do")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
			
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestUri.substring(contextPath.length());
		
		Action action = null;
		
		if(cmd.equals("/list.do")) {
			action = new BoardListAction("/board/list.jsp");
		}else if(cmd.equals("/read.do")) {
			action = new BoardReadAction("/board/read.jsp");
		}else if(cmd.equals("/modify.do")) {
			action = new BoardReadAction("/board/modify.jsp");
		}else if(cmd.equals("/update.do")) {
			action = new BoardUpdateAction("/read.do");
		}else if(cmd.equals("/delete.do")) {
			action = new BoardDeleteAction("/list.do");
		}else if(cmd.equals("/create.do")) {
			action = new BoardCreateAction("/list.do");
		}else if(cmd.equals("/cntupdate.do")) {
			action = new BoardReadCntAction("/read.do");
		}else if(cmd.equals("/replyView.do")) {
			action = new BoardReadAction("/board/reply.jsp");
		}else if(cmd.equals("/reply.do")) {
			action = new BoardReplyAction("/list.do");
		}
		
		ActionForward af = null;
		
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
