<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>
<script src="${context}/resources/js/reply.js"></script>
<script>
	var context = '${context}'; // 자바스크립트에서 사용할 컨텍스트 경로명
	var user = '${USER.userId}'; // 현재 사용자 ID
	$(function() {

		$('#delete-btn').click(function(e) {

			e.preventDefault();
			$('.password-panel').show();
		});

		$('#delete-cancle').click(function() {
			$('#password').val('');
			$('.password-panel').hide();
		});

		$('#delete-confirm').click(function() {
			var password = $('#password').val();
			var boardId = $(this).data('target');

			if (password == '') {
				alert('비밀번호를 입력하세요');
				$('#password').focus();
				return;
			}
			console.log(boardId, password);

			var result = confirm("게시물을 삭제할까요?");

			var url = "../delete";
			var params = {
				boardId : boardId,
				password : password,
			};

			$.get(url, params, function(result) {
				if (result == 'ok') {
					alert('게시물을 삭제 했습니다.');
					// 자바 태그에서 페이지 이동, location
					location = '../list';
				} else {
					alert('삭제 실패 : ' + result);
				}
			});
		});
		$('#reply-form').replyForm($('#reply-list'));
		$('#reply-list').replyList(${board.boardId});
	});
</script>




<div class="container">
	<iot:page-header icon="book-open" title="게시글 보기" />
	<iot:board-display title="제목" item="${board.title}" />
	<iot:board-display title="작성자" item="${board.writer}" />
	<iot:board-display title="조회수" item="${board.readCnt}" />

	<div class="row">
		<div class="col-md-2">첨부파일</div>
		<div class="col-md-10">
			<c:forEach var="file" items="${board.attachList}">
				<div>
					<a href="../download/${file.attachmentId}"> <i
						class="fas fa-download"></i>${file.fileName}
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">작성일</div>
		<div class="col-md-10">
			<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">수정일</div>
		<div class="col-md-10">
			<fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd" />
		</div>
	</div>

	<hr />

	<div>${board.content}</div>
	<div class="text-center">
		<c:if test="${USER.userId==board.writer}">
			<a href="../edit/${board.boardId}?page=${param.page}" class="mr-4">
				<i class="fas fa-edit mr-2"></i> 수정
			</a>
			<a href="#" id="delete-btn" class="mr-4"> <i
				class="fas fa-trash mr-2"></i> 삭제
			</a>
		</c:if>
		<a href="../list?page=${param.page}"> <i class="fas fa-undo mr-2"></i>돌아가기
		</a>
	</div>

	<div class="password-panel my-3 text-center" style="display: none">
		비밀번호 : <input type="password" id="password" />
		<button type="button" id="delete-confirm"
			data-target="${board.boardId}">확인</button>
		<button type="button" id="delete-cancle"">취소</button>
	</div>
	<c:if test="${not empty USER}">
		<jsp:include page="reply-form.jsp" />
	</c:if>
	<div id="reply-list" class="mt-5">
		<jsp:include page="reply-list.jsp" />
	</div>

</div>