package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 * 小说分类
 * 
 * @author 10258
 *
 */

@Table(name = "tb_novel_classify")
public class NovelClassify {

	private Long novelClassifyId;
	private String novelClassifyName;

	public Long getNovelClassifyId() {
		return novelClassifyId;
	}

	public void setNovelClassifyId(Long novelClassifyId) {
		this.novelClassifyId = novelClassifyId;
	}

	public String getNovelClassifyName() {
		return novelClassifyName;
	}

	public void setNovelClassifyName(String novelClassifyName) {
		this.novelClassifyName = novelClassifyName;
	}

}
