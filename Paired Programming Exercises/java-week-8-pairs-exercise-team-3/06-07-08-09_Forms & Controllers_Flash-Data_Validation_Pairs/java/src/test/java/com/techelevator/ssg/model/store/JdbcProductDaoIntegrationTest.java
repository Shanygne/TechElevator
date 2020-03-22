package com.techelevator.ssg.model.store;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.ssg.DAOIntegrationTest;

public class JdbcProductDaoIntegrationTest extends DAOIntegrationTest {

	private JdbcProductDao dao;

	@Before
	public void setup() {
		dao = new JdbcProductDao(getDataSource());
	}

	@Before
	public void clearProductTable() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM products");
	}

	@Test
	public void saves_and_reads_one_product() {
		Product theProduct = new Product();
		theProduct.setName("Solar System Geek Telescope");
		theProduct.setDescription("Look at planets and stuff...");
		theProduct.setPrice(new DollarAmount(9999));
		theProduct.setImageName("telescope.png");

		dao.save(theProduct);
		Product result = dao.getProductById(theProduct.getId());

		assertNotNull(result);
		assertThat(result, equalTo(theProduct));
	}

	@Test
	public void saves_and_reads_all_products() {
		Product product1 = new Product();
		product1.setName("Solar System Geek Telescope");
		product1.setDescription("Look at planets and stuff...");
		product1.setPrice(new DollarAmount(9999));
		product1.setImageName("telescope.png");

		Product product2 = new Product();
		product2.setName("Geek Card");
		product2.setDescription("Make it official...");
		product2.setPrice(new DollarAmount(499));
		product2.setImageName("geek_card.png");

		dao.save(product1);
		dao.save(product2);
		List<Product> allProducts = dao.getAllProducts();

		assertNotNull(allProducts);
		assertEquals(2, allProducts.size());
		assertThat(allProducts, hasItem(equalTo(product1)));
		assertThat(allProducts, hasItem(equalTo(product2)));
	}

	private Matcher<Product> equalTo(final Product expected) {
		return new TypeSafeMatcher<Product>() {

			public void describeTo(Description description) {
			}

			protected boolean matchesSafely(Product product) {
				return nullOrEqual(expected.getId(), product.getId())
						&& nullOrEqual(expected.getName(), product.getName())
						&& nullOrEqual(expected.getDescription(), product.getDescription())
						&& nullOrEqual(expected.getPrice(), product.getPrice())
						&& nullOrEqual(expected.getImageName(), product.getImageName());

			}

			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

}
