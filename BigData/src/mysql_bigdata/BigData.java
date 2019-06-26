package mysql_bigdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Connection;

import cn.zhou.jdbcutils.ant.JdbcUtils;

public class BigData {


	/*
	 * 	max_allowed_packet=10485760　　最大上传文件大小为１０M
	 * 　如果无法上传，有可能是ＭｙＳＱＬ数
	 * 据库的默认设置存储文件的大小，把这句话写入my.init文件中或许可以解决问题
	 * 

	 * 
	 * 把一首ＭＰ３文件存入ＭｙＳＱＬ数据库
	 * 
	 * 并且从数据库中取出来正常播放
	 * 
	 */

	@Test
	public void test1() throws SQLException, FileNotFoundException, IOException {
		Connection con = JdbcUtils.getConnection();  //链接数据库并获得返回的链接对象
		
		String sql = "insert into mp3 values(?,?,?)";   //写ｓｑｌ插入语句
		PreparedStatement prepared = con.prepareStatement(sql); //得到ｐｒｅｐａｒｅdｓｔａｔｅｍｅｎｔ对象
		prepared.setString(1, null);   //设置第一条参数
		prepared.setString(2, "流光飞舞.mp3");  // 第二条参数

		//把ＭＰ３文件转换成字节数组
		byte[] bytes = IOUtils.toByteArray(new FileInputStream("/home/zhou/workspace/music/流光飞舞.mp3"));
		Blob blob = new SerialBlob(bytes);  //把字节数组转换成ｂｌｏｂ对象
		prepared.setBlob(3, blob);     //设置第三条参数：特殊的参数　　ｂｌｏｂ参数
		/// /home/zhou/workspace/music/流光飞舞.mp3

		prepared.execute();   //向数据库发送ｓｑｌ语句
	}

	@Test
	public void test2() throws SQLException, IOException {

		Connection con = JdbcUtils.getConnection();
		String sql = "select *from mp3";
		PreparedStatement prepared = con.prepareStatement(sql);
		ResultSet rs = prepared.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String mp3Name = rs.getString("filename");
			Blob blob = rs.getBlob("data");  //得到ＭＰ３文件的ｂｌｏｂ数据
			InputStream is = blob.getBinaryStream();    //把ｂｌｏｂ数据转换成二进制文件
			OutputStream os = new FileOutputStream("/home/zhou/流光飞舞.mp3");  //填写ＭＰ３文件的书写路径
			IOUtils.copy(is, os);  //把二进制文件写到硬盘中
		}

	}

}
