package wml.java.restful;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FeedService {
	
	@Autowired
	private FeedRepository repo;
	
	public void save(Feed feed) {
		//System.out.print(feed.getAuthor());
		repo.save(feed);
	}
	
	public Feed get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
    public List<Feed> listAll() {
        return (List<Feed>) repo.findAll();
    }
    
    public void UpdateFeed(FlickrRequest request) {
    	List<Item> item;
		try {
			item = request.getFeed();
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
				repo.save(feed);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteAndUpdate(FlickrRequest request) {
    	repo.deleteAll();
    	this.UpdateFeed(request);
    }
	
}
