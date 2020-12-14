package www.novel.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 * ÍÆ¼ö±í
 * 
 * @author
 *
 */
@Table(name = "tb_recommendation")
public class Recommendation {
	private Long recommendationId;
	private Long recommendationNovelId;
	private Long recommendationNovelCount;
	private Long recommendationNovelDate;

	public Long getRecommendationNovelDate() {
		return recommendationNovelDate;
	}

	public void setRecommendationNovelDate(Long recommendationNovelDate) {
		this.recommendationNovelDate = recommendationNovelDate;
	}

	public Long getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(Long recommendationId) {
		this.recommendationId = recommendationId;
	}

	public Long getRecommendationNovelId() {
		return recommendationNovelId;
	}

	public void setRecommendationNovelId(Long recommendationNovelId) {
		this.recommendationNovelId = recommendationNovelId;
	}

	public Long getRecommendationNovelCount() {
		return recommendationNovelCount;
	}

	public void setRecommendationNovelCount(Long recommendationNovelCount) {
		this.recommendationNovelCount = recommendationNovelCount;
	}

}
