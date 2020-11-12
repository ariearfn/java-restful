package wml.java.restful;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(Application.class, args);
		/*
		 * Application app = new Application(); app.list();
		 */		
		
		
	
//		SpringApplication.run(Application.class, args);
//		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
//		ObjectMapper objectMapper = new ObjectMapper();
//		URL url;
//		try {
//			FeedService service = new FeedService();
//			url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1");
//			 Flickr flickr = objectMapper.readValue(url, Flickr.class);
//			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//			System.out.print("Flickr : "+flickr.getTitle());
//			for(Item item : flickr.getItems()) {
//				System.out.println(item.getLink());
//				Feed feed = new Feed();
//				feed.setAuthor(item.getAuthor());
//				feed.setLink(item.getLink());
//				feed.setAuthor_id(item.getAuthorId());
//				feed.setDate_taken(item.getDateTaken());
//				feed.setMedia("");
//				feed.setPublished(item.getPublished());
//				feed.setTags(item.getTags());
//				feed.setTitle(item.getTitle());
//				feed.setDescription(item.getDescription());
//				service.save(feed);
//			}
//		}catch (MalformedURLException ex) {
//			System.out.print("Error "+ex.toString());
//		}
	}

}
