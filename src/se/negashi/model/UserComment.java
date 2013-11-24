package se.negashi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_comments")
public class UserComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMMENT_ID",unique=true,nullable=false)
	int id;
	@Column(name="COMMENT")
	String comment;
	@Column(name="COMMENTED_BY")
	String comentedBy;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POST_ID",nullable=false)
	Post post;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComentedBy() {
		return comentedBy;
	}
	public void setComentedBy(String comentedBy) {
		this.comentedBy = comentedBy;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	

}
