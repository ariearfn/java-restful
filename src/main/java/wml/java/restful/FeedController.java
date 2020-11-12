package wml.java.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {
	
	@Autowired
	private FeedService feedService;

	@GetMapping("/update-feeds")
	  public @ResponseBody String updateFeed() {
		
		FlickrRequest flickrRequest = new FlickrRequest();
		feedService.deleteAndUpdate(flickrRequest);
	    return "Update Success";
	  }
	
	@GetMapping("/feeds")
	public List<Feed> list() {
	    return feedService.listAll();
	}

	
}
