package wml.java.restful;

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
	
}
