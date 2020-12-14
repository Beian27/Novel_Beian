package www.novel.util;

/**
 * ͳ������
 * 
 * @author 10258
 *
 */
public class WordsCount {
	// TODO caihao 2016-11-06 ����ͳ�� ������
	/**
	 * ͳ������������MS office word 2007����
	 * 
	 * @param context
	 *            �ı�����
	 * @return ����
	 */
	public static int getMSWordsCount(String context) {
		int words_count = 0;
		// ���ĵ���
		String cn_words = context.replaceAll("[^(\\u4e00-\\u9fa5������������������������������������������)]", "");
		int cn_words_count = cn_words.length();
		// �����ĵ���
		String non_cn_words = context.replaceAll("[^(a-zA-Z0-9`\\-=\';.,/~!@#$%^&*()_+|}{\":><?\\[\\])]", " ");
		int non_cn_words_count = 0;
		String[] ss = non_cn_words.split(" ");
		for (String s : ss) {
			if (s.trim().length() != 0)
				non_cn_words_count++;
		}
		// ���ĺͷ����ĵ��ʺϼ�
		words_count = cn_words_count + non_cn_words_count;
		return words_count;
	}
}
