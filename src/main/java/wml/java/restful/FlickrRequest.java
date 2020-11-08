package wml.java.restful;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import wml.java.restful.FeedService;
import wml.java.restful.Flickr;
import wml.java.restful.Item;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

public class FlickrRequest {
	
	@Autowired
	private FeedRepository feedRepository;
	
	public void save() {
		Feed feed = new Feed();
		feed.setAuthor("tes");
		feed.setLink("tes");
		feed.setAuthor_id("tes");
		feed.setDate_taken("tes");
		feed.setMedia("tes");
		feed.setPublished("tes");
		feed.setTags("tes");
		feed.setTitle("tes");
		feed.setDescription("tes");
		feedRepository.save(feed);
	}
	
	public List<Item> getFeed() throws JsonParseException, JsonMappingException, IOException {
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		ObjectMapper objectMapper = new ObjectMapper();
		URL url;
		try {
			FeedService service = new FeedService();
			url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1");
			 Flickr flickr = objectMapper.readValue(url, Flickr.class);
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return flickr.getItems();
		}catch (MalformedURLException ex) {
			System.out.print("Error "+ex.toString());
		}
		return null;
	}
}
