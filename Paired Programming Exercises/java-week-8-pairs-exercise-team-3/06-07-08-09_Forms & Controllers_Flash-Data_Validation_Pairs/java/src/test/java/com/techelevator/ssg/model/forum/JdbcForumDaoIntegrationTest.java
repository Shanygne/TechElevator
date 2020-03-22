package com.techelevator.ssg.model.forum;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.ssg.DAOIntegrationTest;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.forum.JdbcForumDao;

public class JdbcForumDaoIntegrationTest extends DAOIntegrationTest {

	private JdbcForumDao dao;

	@Before
	public void setup() {
		dao = new JdbcForumDao(getDataSource());
	}

	@Before
	public void cleanDatabase() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM forum_post");
	}

	@Test
	public void saved_posts_are_returned_in_list_of_all_posts() {
		ForumPost post1 = createForumPost("Mickey Mouse", "Composition of Moon",
				"Is it true that the Moon is made of cheese?");
		ForumPost post2 = createForumPost("Marvin the Martian", "Earth",
				"I'm going to blow it up; it obstructs my view of Venus.");

		dao.save(post1);
		dao.save(post2);

		List<ForumPost> results = dao.getAllPosts();

		assertThat(results, hasItem(equalTo(post1)));
		assertThat(results, hasItem(equalTo(post2)));
		assertThat(results.size(), CoreMatchers.equalTo(2));
	}

	private Matcher<ForumPost> equalTo(final ForumPost expected) {
		return new TypeSafeMatcher<ForumPost>() {

			public void describeTo(Description desc) {

			}

			protected boolean matchesSafely(ForumPost post) {
				return nullOrEqual(expected.getId(), post.getId())
						&& nullOrEqual(expected.getUsername(), post.getUsername())
						&& nullOrEqual(expected.getSubject(), post.getSubject())
						&& nullOrEqual(expected.getMessage(), post.getMessage())
						&& nullOrEqual(expected.getDatePosted(), post.getDatePosted());

			}

			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

	private ForumPost createForumPost(String username, String subject, String message) {
		ForumPost post = new ForumPost();
		post.setUsername(username);
		post.setSubject(subject);
		post.setMessage(message);
		post.setDatePosted(LocalDateTime.now());
		return post;
	}
}
