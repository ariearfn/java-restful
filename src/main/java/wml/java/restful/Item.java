package wml.java.restful;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"title",
"link",
"media",
"date_taken",
"description",
"published",
"author",
"author_id",
"tags"
})

public class Item {
	
	@JsonProperty("title")
	private String title;
	@JsonProperty("link")
	private String link;
	@JsonProperty("media")
	private Media media;
	@JsonProperty("date_taken")
	private Date dateTaken;
	@JsonProperty("description")
	private String description;
	@JsonProperty("published")
	private Date published;
	@JsonProperty("author")
	private String author;
	@JsonProperty("author_id")
	private String authorId;
	@JsonProperty("tags")
	private String tags;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("title")
	public String getTitle() {
	return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
	this.title = title;
	}

	@JsonProperty("link")
	public String getLink() {
	return link;
	}

	@JsonProperty("link")
	public void setLink(String link) {
	this.link = link;
	}

	@JsonProperty("media")
	public Media getMedia() {
	return media;
	}

	@JsonProperty("media")
	public void setMedia(Media media) {
	this.media = media;
	}

	@JsonProperty("date_taken")
	public Date getDateTaken() {
	return dateTaken;
	}

	@JsonProperty("date_taken")
	public void setDateTaken(Date dateTaken) {
	this.dateTaken = dateTaken;
	}

	@JsonProperty("description")
	public String getDescription() {
	return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
	this.description = description;
	}

	@JsonProperty("published")
	public Date getPublished() {
	return published;
	}

	@JsonProperty("published")
	public void setPublished(Date published) {
	this.published = published;
	}

	@JsonProperty("author")
	public String getAuthor() {
	return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
	this.author = author;
	}

	@JsonProperty("author_id")
	public String getAuthorId() {
	return authorId;
	}

	@JsonProperty("author_id")
	public void setAuthorId(String authorId) {
	this.authorId = authorId;
	}

	@JsonProperty("tags")
	public String getTags() {
	return tags;
	}

	@JsonProperty("tags")
	public void setTags(String tags) {
	this.tags = tags;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}