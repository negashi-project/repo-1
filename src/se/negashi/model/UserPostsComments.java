package se.negashi.model;

import java.util.List;

public class UserPostsComments {
	UserPosts post;
	List<UserComments> comments;
	public UserPosts getPost() {
		return post;
	}
	public void setPost(UserPosts post) {
		this.post = post;
	}
	public List<UserComments> getComments() {
		return comments;
	}
	public void setComments(List<UserComments> comments) {
		this.comments = comments;
	}
	

}
