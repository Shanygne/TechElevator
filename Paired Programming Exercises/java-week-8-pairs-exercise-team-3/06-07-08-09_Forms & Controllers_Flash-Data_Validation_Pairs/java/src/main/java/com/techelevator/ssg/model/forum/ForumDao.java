package com.techelevator.ssg.model.forum;

import java.util.List;

public interface ForumDao {

	public List<ForumPost> getAllPosts();

	public void save(ForumPost post);
}
