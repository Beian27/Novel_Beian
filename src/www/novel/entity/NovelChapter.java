package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 * уб╫з╠М
 * 
 * @author 10258
 *
 */
@Table(name = "tb_novle_chapter_info")
public class NovelChapter {
	private Long chapterId;
	private Long novelId;
	private String chapterName;
	private String chapterContent;
	private String chapterDateTime;
	private String chapterState;

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public Long getNovelId() {
		return novelId;
	}

	public void setNovelId(Long novelId) {
		this.novelId = novelId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public String getChapterDateTime() {
		return chapterDateTime;
	}

	public void setChapterDateTime(String chapterDateTime) {
		this.chapterDateTime = chapterDateTime;
	}

	public String getChapterState() {
		return chapterState;
	}

	public void setChapterState(String chapterState) {
		this.chapterState = chapterState;
	}

}
