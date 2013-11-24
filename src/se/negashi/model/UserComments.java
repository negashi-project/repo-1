package se.negashi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@NamedNativeQuery(name = "postcomments", query = "SELECT "
		+ "user_comments.COMMENT_ID, user_comments.COMMENTED_BY, "
		+ "user_comments.COMMENT, user_comments.POST_ID,users.name "
		+ "FROM user_comments inner join users "
		+ "on user_comments.COMMENTED_BY = users.email "
		+ "where user_comments.POST_ID=:post_id", resultClass = UserComments.class)
@Entity
public class UserComments {
	@Id
	int COMMENT_ID;
	String COMMENTED_BY;
	String COMMENT;
	int POST_ID;
	String name;
	public int getCOMMENT_ID() {
		return COMMENT_ID;
	}
	public void setCOMMENT_ID(int cOMMENT_ID) {
		COMMENT_ID = cOMMENT_ID;
	}
	public String getCOMMENTED_BY() {
		return COMMENTED_BY;
	}
	public void setCOMMENTED_BY(String cOMMENTED_BY) {
		COMMENTED_BY = cOMMENTED_BY;
	}
	public String getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	public int getPOST_ID() {
		return POST_ID;
	}
	public void setPOST_ID(int pOST_ID) {
		POST_ID = pOST_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
