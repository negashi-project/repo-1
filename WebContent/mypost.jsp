
<div class="postArea">
	<div class="userInput">
		<form method="post" action="PostControler">
		<input type="hidden" name="posterEmail" value="${user.email}">
			<textarea name="userInputPost" placeholder="What is in your mind?"
				onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }">
</textarea>
		</form>
	</div>

	<c:forEach var="posts" items="${userposts}">
		<div class="displayArea">
			<p>
				<c:out value="${posts.post.POST_TEXT}"></c:out>
			</p>
		</div>
		<c:forEach var="comments" items="${posts.comments}">
			<div class="divRow">
				<img class="userIcon" src="image1.jpg"> <strong><c:out
						value="${comments.name}"></c:out></strong>
				<c:out value="${comments.COMMENT}"></c:out>
			</div>
		</c:forEach>
		<div class="userInput">
			<form method="post" action="CommentControler">
				<input type="hidden" name="userId" value="${user.id}"> <input
					type="hidden" name="postId" value="${posts.post.POST_ID}">
					<input type="hidden" name="userEmail" value="${user.email}">
				<textarea name="userComment" placeholder="Give comment"
					onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }"></textarea>
			</form>
		</div>
	</c:forEach>
</div>