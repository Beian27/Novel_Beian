package www.novel.dao;

import java.util.ArrayList;
import java.util.List;

import www.novel.entity.Author;
import www.novel.util.BeetlSQLUtil;

public class AuthorDao {

	public List<Author> allAuthor(String q) {
		List<Author> authors = new ArrayList<>();
		if (null != q) {
			if (q.equals("")) {
				authors = BeetlSQLUtil.getSQLManager().all(Author.class);
			} else {
				authors = BeetlSQLUtil.getSQLManager().query(Author.class).andLike("author_name", "%" + q + "%")
						.select();
			}
		} else {
			authors = BeetlSQLUtil.getSQLManager().all(Author.class);
		}
		return authors;
	}
}
