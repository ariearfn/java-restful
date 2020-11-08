package wml.java.restful;

import wml.java.restful.Feed;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class FeedController {

	@Autowired
	private FeedRepository feedRepository;
//	
//	@GetMapping("/search")
//	public @ResponseBody String searchFeedByAuthor() {
//	    //feedRepository.fin
//	  }
//	@GetMapping(value = "/feeds", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<PagedResources<FeedEntity>> AllFeeds(Pageable pageable, PagedResourcesAssembler assembler) {
//		Page<FeedEntity> feeds = feedService.findAllFeed(pageable);
//		PagedResources<FeedEntity> fe = assembler.toResource(feeds, linkTo(FeedController.class).slash("/feeds").withSelfRel());
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Link", createLinkHeader(fe));
//		return new ResponseEntity <> (assembler.toResource(feeds, linkTo(FeedController.class).slash("/feeds").withSelfRel()), responseHeaders, HttpStatus.OK);
//	}
	
//	private String createLinkHeader(PagedResources<FeedEntity> fe) {
//		final StringBuilder linkHeader = new StringBuilder();
//		linkHeader.append(buildLinkHeader(fe.getLinks("first").get(0).getHref(), "first"));
//		linkHeader.append(", ");
//		linkHeader.append(buildLinkHeader(fe.getLinks("first").get(0).getHref(), "next"));
//		return linkHeader.toString();
//	}
//	
//	public static String buildLinkHeader(final String uri, final String rel) {
//		return "<" + uri + ">; rel=\"" + rel + "\"";
//	}
		
				
	@GetMapping("/feed")
	  public @ResponseBody String getAllFeeds() {
	    long c = feedRepository.count();
	    return "Record "+c;
	  }
	
	@GetMapping("/update-feed")
	  public @ResponseBody String updateFeed() {
		feedRepository.deleteAll();
		FlickrRequest fr = new FlickrRequest();
		List<Item> item;
		try {
			item = fr.getFeed();
			for(Item i : item) {
				Feed feed = new Feed();
				feed.setAuthor(i.getAuthor());
				feed.setLink(i.getLink());
				feed.setAuthor_id(i.getAuthor());
				feed.setDate_taken(i.getDateTaken().toString());
				feed.setMedia(i.getMedia().getM());
				feed.setPublished(i.getPublished().toString());
				feed.setTags(i.getTags());
				feed.setTitle(i.getTitle());
				feed.setDescription(i.getDescription());
				feedRepository.save(feed);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "Update Success";
	  }
}
