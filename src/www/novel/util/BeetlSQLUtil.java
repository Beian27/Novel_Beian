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
			// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
			UnderlinedNameConversion nc = new UnderlinedNameConversion();
			// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
			sqlManager = new SQLManager(mysql, loader, source, nc, new Interceptor[] { new DebugInterceptor() });
		}
	}

	public static SQLManager getSQLManager() {
		return sqlManager;
	}
}
