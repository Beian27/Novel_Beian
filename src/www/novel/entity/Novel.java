package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 * 小说基本信息表
 * 
 * @author 10258
 *
 */
@Table(name = "tb_novel_base_info")
public class Novel {
	private Long novelId;
	private String novelName;
	private String novelDesc;
	private String novelAuthor;
	private String novelClassify;
	private String novelState;
	private NovelChapter novelChapter;
	private Recommendation recommendation;
	
	private String novelImage;



	/**
	 * @return the novelImage
	 */
	public String getNovelImage() {
		return novelImage;
	}
	
	/**
	 * @param novelImage the novelImage to set
	 */
	public void setNovelImage(String novelImage) {
		this.novelImage = novelImage;
	}

	public Long getNovelId() {
		return novelId;
	}

	public void setNovelId(Long novelId) {
		this.novelId = novelId;
	}

	public String getNovelName() {
		return novelName;
	}

	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}

	public String getNovelDesc() {
		return novelDesc;
	}

	public void setNovelDesc(String novelDesc) {
		this.novelDesc = novelDesc;
	}

	public String getNovelAuthor() {
		return novelAuthor;
	}

	public void setNovelAuthor(String novelAuthor) {
		this.novelAuthor = novelAuthor;
	}

	public String getNovelClassify() {
		return novelClassify;
	}

	public void setNovelClassify(String novelClassify) {
		this.novelClassify = novelClassify;
	}

	public String getNovelState() {
		return novelState;
	}

	public void setNovelState(String novelState) {
		this.novelState = novelState;
	}

	public NovelChapter getNovelChapter() {
		return novelChapter;
	}

	public void setNovelChapter(NovelChapter novelChapter) {
		this.novelChapter = novelChapter;
	}

	public Recommendation getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Novel [novelId=" + novelId + ", novelName=" + novelName + ", novelDesc=" + novelDesc + ", novelAuthor="
				+ novelAuthor + ", novelClassify=" + novelClassify + ", novelState=" + novelState + ", novelChapter="
				+ novelChapter + ", recommendation=" + recommendation + ", novelImage=" + novelImage + "]";
	}

	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Novel(Long novelId, String novelName, String novelDesc, String novelAuthor, String novelClassify,
			String novelState, NovelChapter novelChapter, Recommendation recommendation, String novelImage) {
		super();
		this.novelId = novelId;
		this.novelName = "未创建章节";
		this.novelDesc = "未创建章节";
		this.novelAuthor = "未创建章节";
		this.novelClassify = "未创建章节";
		this.novelState = "未创建章节";
		this.novelChapter = null;
		this.recommendation = null;
		this.novelImage = "未创建章节";
	}



}
