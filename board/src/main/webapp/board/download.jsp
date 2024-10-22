<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.awt.image.DataBufferDouble"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 클라이언트가 요청한 파일명
	String fileName = request.getParameter("fileName");
	// 서버의 업로드 폴더에 가서 요청 파일 읽은 후 보내기
	String saveDir = "c:\\upload";
	String downPath = saveDir + File.separator + fileName;
	
	// 파일 읽기
	FileInputStream fis = new FileInputStream(downPath);
	
	// 읽은 파일 브라우저 헤더에 붙여서 보내기
	response.setContentType("application/octet-stream");
	fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
	
	int start = fileName.lastIndexOf("_");
	String oriName = fileName.substring(start + 1);
	
	/* response.setHeader("content-disposition", "attachment; filename="+oriName); */
	// 파일명에 쉼표 들어갈시 오류발생(크롬 브라우저에서 중복헤더로 인식) => ""로 감싸주기
	response.setHeader("content-disposition", "attachment; filename=\"" + oriName + "\"");
	
	
	
	out.clear();
	out = pageContext.pushBody();
	
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	int numRead = 0;
	byte b[]=new byte[4096];
	while((numRead = fis.read(b)) != -1){
		bos.write(b);
	}
	bos.flush();
	bos.close();
	fis.close();
%>