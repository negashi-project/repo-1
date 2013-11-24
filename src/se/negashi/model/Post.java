package se.negashi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.mysql.jdbc.Blob;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POST_ID", unique = true, nullable = false)
	int id;
	@Column(name = "POST_DATE", nullable = false)
	Date date = new Date();
	@Column(name = "POST_TEXT")
	String text;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	List<UserComment> comments = new ArrayList<UserComment>();
	@Column(name = "POSTED_BY", unique = true)
	String postedBy;

	// @Transient
	// private Blob file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

}
