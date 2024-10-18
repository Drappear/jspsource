package action;

public class ActionForward {
	// 이동방식 저장 클래스
	// sendRedirect, forward  ==>  경로
	
	private String path;
	private boolean redirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public ActionForward(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	
	public ActionForward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
