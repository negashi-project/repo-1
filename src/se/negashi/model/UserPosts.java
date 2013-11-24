package se.negashi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQuery(name = "allposts", query = "SELECT posts.POST_ID, posts.POST_DATE, posts.POST_TEXT,users.name"
		+ " FROM posts inner join users "
		+ "on users.email=posts.POSTED_BY ", resultClass = UserPosts.class)
/*
 * ,
 * 
 * @NamedNativeQuery(name = "postcomments", query =
 * "SELECT user_comments.COMMENT_ID, user_comments.COMMENTED_BY, " +
 * "user_comments.COMMENT, user_comments.POST_ID,users.name " +
 * "FROM user_comments inner join users " +
 * "on user_comments.COMMENTED_BY = :users.email")
 */
@Entity
public class UserPosts {
	@Id
	int POST_ID;
	String POST_TEXT;
	String name;
	Date POST_DATE;

	public int getPOST_ID() {
		return POST_ID;
	}

	public void setPOST_ID(int pOST_ID) {
		POST_ID = pOST_ID;
	}

	public String getPOST_TEXT() {
		return POST_TEXT;
	}

	public void setPOST_TEXT(String pOST_TEXT) {
		POST_TEXT = pOST_TEXT;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPOST_DATE() {
		return POST_DATE;
	}

	public void setPOST_DATE(Date pOST_DATE) {
		POST_DATE = pOST_DATE;
	}
}
