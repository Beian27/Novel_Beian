package www.novel.dao;

import java.util.ArrayList;
import java.util.List;

import www.novel.entity.Admin;
import www.novel.util.BeetlSQLUtil;

public class AdminDao {

	public List<Admin> allAdmin(String query) {
		List<Admin> admins = new ArrayList<>();
		if (null != query) {
			if (query.equals("")) {
				admins = BeetlSQLUtil.getSQLManager().all(Admin.class);
			} else {
				admins = BeetlSQLUtil.getSQLManager().query(Admin.class).andLike("author_name", "%" + query + "%")
						.select();
			}
		} else {
			admins = BeetlSQLUtil.getSQLManager().all(Admin.class);
		}
		return admins;

	}
}
