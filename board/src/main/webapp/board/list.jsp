<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container-fluid">
	<h1 class="h3 mb-4 text-gray-800">List</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
		
			<form action="/list.do" id="searchForm">
				<select name="criteria" id="criteria" class="form-select">
					<option value="n" <c:out value="${searchDto.criteria == null?'selected':''}"/>>------------</option>
					<option value="title" <c:out value="${searchDto.criteria == 'title'?'selected':''}"/>>제목</option>
					<option value="content" <c:out value="${searchDto.criteria == 'content'?'selected':''}"/>>내용</option>
					<option value="name" <c:out value="${searchDto.criteria == 'name'?'selected':''}"/>>작성자</option>
				</select>
				<input type="text" name="keyword" id="keyword" value="${searchDto.keyword}"/>
				<button class="btn btn-warning">검색</button>
			</form>
			
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>					
					<tbody>
						<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.bno}</td>
							<td>
								<c:if test="${dto.reLev!=0}">
									<c:forEach begin="0" end="${dto.reLev*1}">
										&nbsp;
									</c:forEach>
								</c:if>
								<a href="${dto.bno}" class="text-decoration-none text-reset">${dto.title}</a>
							</td>
							<td>${dto.name}</td>
							<td>${dto.regDate}</td>
							<td>${dto.readCnt}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ul class="pagination justify-content-center">
					<c:if test="${pageDto.prev}">
						<li class="paginate_button page-item previous">
							<a href="${pageDto.startPage - 1}" class="page-link">previous</a>
						</li>
					</c:if>
					
					<c:forEach begin="${pageDto.startPage}" end="${pageDto.endPage }" var="idx">
						<li class="paginate_button page-item <c:out value="${pageDto.searchDto.page == idx?'active':''}" />">
							<a href="${idx}" class="page-link">${idx}</a>
						</li>
					</c:forEach>
					
					<c:if test="${pageDto.next}">
						<li class="paginate_button page-item next">
							<a href="${pageDto.endPage + 1}" class="page-link">next</a>
						</li>
					</c:if>
					
				</ul>
			</div>
		</div>
	</div>
</div>

<%-- 페이지 나누기 --%>
<form action="" method="get" id="actionForm">
	<input type="hidden" name="bno" value="" />
	<input type="hidden" name="page" value="${pageDto.searchDto.page}" />
	<input type="hidden" name="amount" value="${pageDto.searchDto.amount}" />
	<input type="hidden" name="criteria" value="${pageDto.searchDto.criteria}" />
	<input type="hidden" name="keyword" value="${pageDto.searchDto.keyword}" />
</form>
<script src = "/js/custom/list.js"></script>
<%@ include file="../include/footer.jsp"%>