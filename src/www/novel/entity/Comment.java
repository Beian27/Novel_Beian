package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

@Table(name = "tb_comment")
public class Comment {
	private Long commentId;
	private String commentator;
	private String commentContent;
	private String commentDate;
	private Long commentNovelId;
	private Novel novel;

	public Novel getNovel() {
		return novel;
	}

	public void setNovel(Novel novel) {
		this.novel = novel;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentator() {
		return commentator;
	}

	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public Long getCommentNovelId() {
		return commentNovelId;
	}

	public void setCommentNovelId(Long commentNovelId) {
		this.commentNovelId = commentNovelId;
	}
}
