package vn.Syaoran.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity 
@Table(name="videos")
@NamedQuery(name="Video.findAll",query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VideoId")
	private int videoId;
	
	@Column(name="Active")
	private int active;
	
	@Column(name="Description", columnDefinition = "nvarchar(500) null")
	private String description;
	
	@Column(name="Poster", columnDefinition = "nvarchar(500) null")
	private String poster;
	
	@Column(name="Title", columnDefinition = "nvarchar(500) null")
	private String title;
	
	@Column(name="Videoclip", columnDefinition = "nvarchar(500) null")
	private String videoclip;
	
	@Column(name="Views")
	private int views;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	public Video() {}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoclip() {
		return videoclip;
	}

	public void setVideoclip(String videoclip) {
		this.videoclip = videoclip;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
