package jp.co.solxyz.lessons.servlet.dao.q02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.solxyz.lessons.servlet.dao.q02.dto.CustomerDto;
import jp.co.solxyz.lessons.servlet.dao.utility.ConnectionManager;

public class CustomerDao {

	// 全件検索のSQL
	private String GET_CUSTOMERLIST = "SELECT * FROM CUSTOMER";

	// 電話番号と所在地によるフィルタを行うSQL
	private String GET_CUSTOMELIST_BY_CONDITION = "SELECT * FROM CUSTOMER WHERE STATE LIKE ? AND MOBILE LIKE ?";

	public List<CustomerDto> getCustomerList() {

		List<CustomerDto> custList = new ArrayList<CustomerDto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_CUSTOMERLIST)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerDto cust = new CustomerDto();
				cust.setId(rs.getInt("ID"));
				cust.setName(rs.getString("NAME"));
				cust.setKana(rs.getString("KANA"));
				cust.setAge(rs.getInt("AGE"));
				cust.setBirthday(rs.getDate("BIRTHDAY"));
				cust.setCity(rs.getString("CITY"));
				cust.setMail(rs.getString("MAIL"));
				cust.setMobile(rs.getLong("MOBILE"));
				cust.setSex(rs.getString("SEX"));
				cust.setTel(rs.getInt("TEL"));
				cust.setAddressline1(rs.getString("ADDRESSLINE1"));
				cust.setAddressline2(rs.getString("ADDRESSLINE2"));
				cust.setState(rs.getString("STATE"));
				cust.setStreet(rs.getString("STREET"));
				cust.setPostal(rs.getString("POSTAL"));

				custList.add(cust);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return custList;
	}

	public List<CustomerDto> getCustomerList(String state, String mobile, String sort) {

		List<CustomerDto> custList = new ArrayList<CustomerDto>();

		// 実行するsql
		String sql;

		// ソート条件が設定されていた場合は ORDER BY句を入れる
		if (sort != null && !"".equals(sort)) {
			sql = GET_CUSTOMELIST_BY_CONDITION + " ORDER BY AGE " + sort;
		} else {
			sql = GET_CUSTOMELIST_BY_CONDITION;
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// プレースホルダーへ値の設定
			ps.setString(1, "%" + state + "%");
			ps.setString(2, mobile + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerDto cust = new CustomerDto();
				cust.setId(rs.getInt("ID"));
				cust.setName(rs.getString("NAME"));
				cust.setKana(rs.getString("KANA"));
				cust.setAge(rs.getInt("AGE"));
				cust.setBirthday(rs.getDate("BIRTHDAY"));
				cust.setCity(rs.getString("CITY"));
				cust.setMail(rs.getString("MAIL"));
				cust.setMobile(rs.getLong("MOBILE"));
				cust.setSex(rs.getString("SEX"));
				cust.setTel(rs.getInt("TEL"));
				cust.setAddressline1(rs.getString("ADDRESSLINE1"));
				cust.setAddressline2(rs.getString("ADDRESSLINE2"));
				cust.setState(rs.getString("STATE"));
				cust.setStreet(rs.getString("STREET"));
				cust.setPostal(rs.getString("POSTAL"));

				custList.add(cust);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return custList;
	}

}
