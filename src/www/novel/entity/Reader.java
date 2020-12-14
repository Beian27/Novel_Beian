package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

@Table(name = "tb_reader")
public class Reader {
	private Long readerId;
	private String readerName;
	private String readerAccount;
	private String readerPassword;

	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderAccount() {
		return readerAccount;
	}

	public void setReaderAccount(String readerAccount) {
		this.readerAccount = readerAccount;
	}

	public String getReaderPassword() {
		return readerPassword;
	}

	public void setReaderPassword(String readerPassword) {
		this.readerPassword = readerPassword;
	}

}
