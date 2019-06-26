package mysql_batch;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;

import cn.zhou.jdbcutils.ant.JdbcUtils;

public class ExecuteBatch {

	// uri + ? rewriterBatchedStatements=true   提高ＭｙＳＱＬ的批处理的效率
	// useUnicode=true&characterEncoding=utf-8&useSSL=false　　开启ＭｙＳＱＬ的批处理
	@Test
	public void test1() throws SQLException, ClassNotFoundException {

		// Connection con=JdbcUtils.getConnection();

		// ?useSSL=false 开启ＭｙＳＱＬ的批处理

		// className=com.mysql.jdbc.Driver
		// url=jdbc:mysql:localhost:3306/zhou
		// username=root
		// password=zhou123

		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zhou?useSSL=false&rewriterBatchedStatements=true";
		String name = "root";
		String ps = "zhou123";

		Class.forName(className);
		Connection con = (Connection) DriverManager.getConnection(url, name, ps);

		System.out.println(con);

		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement prepared = con.prepareStatement(sql);

		for (int i = 0; i < 100; i++) {
			prepared.setInt(1, i + i + i);
			prepared.setString(2, "stu" + i);
			prepared.setInt(3, i);
			prepared.setString(4, i % 2 == 0 ? "男" : "女");
			prepared.addBatch();

		}
		
		long start = System.currentTimeMillis();
		prepared.executeBatch(); // 执行批
		long end = System.currentTimeMillis();

		System.out.println(end - start);   //34149       
	}
}
