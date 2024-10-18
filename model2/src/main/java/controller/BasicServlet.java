package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.CreateAction;
import action.LoginAction;
import action.RegisterAction;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("*.do")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// * 톰캣 서버의 path를 수정하지 않았을 때
		// RequestURI => /프로젝트명/경로명 => /model2/login.do		
		String requestUri = request.getRequestURI();
		
		// ContextPath => /프로젝트명 => /model2
		String contextPath = request.getContextPath();
		
		// 경로명 추출
		String cmd = requestUri.substring(contextPath.length());
		
//		System.out.println("req uri : "+requestUri);
//		System.out.println("con path : "+contextPath);
//		System.out.println("cmd : "+cmd);
		
		Action action = null;
		
		if (cmd.equals("/login.do")) {
			System.out.println("로그인 작업");
			action = new LoginAction("index.jsp");
		} else if(cmd.equals("/register.do")) {
			System.out.println("회원가입 작업");
			action = new RegisterAction("/member/login.jsp");
		} else if(cmd.equals("/create.do")) {
			action = new CreateAction("index.jsp");
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
