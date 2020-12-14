package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

@Table(name = "tb_author")
public class Author {
	private Long authorId;
	private String authorName;
	private String authorAccount;
	private String authorPassword;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorAccount() {
		return authorAccount;
	}

	public void setAuthorAccount(String authorAccount) {
		this.authorAccount = authorAccount;
	}

	public String getAuthorPassword() {
		return authorPassword;
	}

	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}

}
