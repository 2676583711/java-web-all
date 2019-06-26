package cn.zhou.utils.mydbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.zhou.jdbcutils.transaction.TransactionUtils;

public class QueryRunnerUtils extends QueryRunner {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#batch(java.lang.String,
	 * java.lang.Object[][])
	 */
	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {

		Connection con = TransactionUtils.getConnection();
		int[] batch = super.batch(con, sql, params);
		TransactionUtils.closeConnection(con);
		return batch;

		// return super.batch(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#execute(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execute(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = TransactionUtils.getConnection();
		int batch = super.execute(con, sql, params);
		TransactionUtils.closeConnection(con);
		return batch;

		// return super.execute(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#execute(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.execute(con, sql, rsh, params);
		TransactionUtils.closeConnection(con);
		return (List<T>) batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#insert(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.insert(con, sql, rsh, params);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#insert(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.insert(con, sql, rsh);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#insertBatch(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[][])
	 */
	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.insertBatch(con, sql, rsh, params);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String,
	 * java.lang.Object, org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.query(con, sql, param, rsh);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String,
	 * java.lang.Object[], org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.query(con, sql, params, rsh);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.query(con, sql,  rsh,params);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String,
	 * org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		T batch = (T) super.query(con, sql,  rsh);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		int batch =  super.update(con, sql,  params);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		int batch =  super.update(con, sql,  param);
		TransactionUtils.closeConnection(con);
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String)
	 */
	@Override
	public int update(String sql) throws SQLException {
		Connection con = TransactionUtils.getConnection();
		int batch =  super.update(con, sql);
		TransactionUtils.closeConnection(con);
		return batch;
	}

}
