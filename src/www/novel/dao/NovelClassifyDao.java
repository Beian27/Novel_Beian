package www.novel.dao;

import java.util.ArrayList;
import java.util.List;

import www.novel.entity.NovelClassify;
import www.novel.util.BeetlSQLUtil;
/**
 * 小说分类
 * @author 10258
 *
 */
public class NovelClassifyDao {
	/**
	 * 小说分类
	 * @param query
	 * @return
	 */
	public List<NovelClassify> allClassify(String query) {
		List<NovelClassify> classifies = new ArrayList<>();
		if (null != query) {
			if (query.equals("")) {
				classifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
			} else {
				classifies = BeetlSQLUtil.getSQLManager().query(NovelClassify.class)
						.andLike("novel_classify_name", "%" + query + "%").select();
			}
		} else {
			classifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
		}
		return classifies;

	}
}
