package com.techelevator.ssg.model.forum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcForumDao implements ForumDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcForumDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ForumPost> getAllPosts() {
		List<ForumPost> allPosts = new ArrayList<>();
		String sqlSelectAllPosts = "SELECT * FROM forum_post";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPosts);
		while (results.next()) {
			ForumPost post = new ForumPost();
			post.setId(results.getLong("id"));
			post.setUsername(results.getString("username"));
			post.setSubject(results.getString("subject"));
			post.setMessage(results.getString("message"));
			post.setDatePosted(results.getTimestamp("post_date").toLocalDateTime());
			allPosts.add(post);
		}
		return allPosts;
	}

	@Override
	public void save(ForumPost post) {
		Long id = getNextId();
		String sqlInsertPost = "INSERT INTO forum_post(id, username, subject, message, post_date) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, post.getUsername(), post.getSubject(), post.getMessage(),
				LocalDateTime.now());
		post.setId(id);
	}

	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_forum_post_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if (results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}

}
