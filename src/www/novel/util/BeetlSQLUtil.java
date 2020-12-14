package www.novel.util;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

import com.alibaba.druid.pool.DruidDataSource;

public class BeetlSQLUtil {
	private static SQLManager sqlManager;

	static {
		if (sqlManager == null) {
			DruidDataSource ds = new DruidDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/novel?serverTimezone=UTC");
			ds.setUsername("root");
			ds.setPassword("123456");
			ConnectionSource source = ConnectionSourceHelper.getSingle(ds);
			DBStyle mysql = new MySqlStyle();
			SQLLoader loader = new ClasspathLoader("/sql");
			// ���ݿ�������java����һ�������Բ���DefaultNameConversion������һ����UnderlinedNameConversion���»��߷���
			UnderlinedNameConversion nc = new UnderlinedNameConversion();
			// ��󣬴���һ��SQLManager,DebugInterceptor ���Ǳ���ģ�������ͨ�����鿴sqlִ�����
			sqlManager = new SQLManager(mysql, loader, source, nc, new Interceptor[] { new DebugInterceptor() });
		}
	}

	public static SQLManager getSQLManager() {
		return sqlManager;
	}
}
