package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 *  Èº‹
 * 
 * @author 10258
 *
 */
@Table(name = "tb_bookself")
public class BookSelf {
	private Long bookSelfId;
	private Long novelId;
	private Long readerId;

	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	public Long getBookSelfId() {
		return bookSelfId;
	}

	public void setBookSelfId(Long bookSelfId) {
		this.bookSelfId = bookSelfId;
	}

	public Long getNovelId() {
		return novelId;
	}

	public void setNovelId(Long novelId) {
		this.novelId = novelId;
	}

}
