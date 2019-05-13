package com.empmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.empmanagement.entity.Promotion;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.User;
import com.empmanagement.entity.Work;

public class ApplicationDao {

	public static ApplicationDao appDaoInstance = new ApplicationDao();
	private Connection conn;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pstmt;

	public static ApplicationDao getInstance() {
		return appDaoInstance;
	}

	public User isValidUser(String username, String password) {
		try {
			User user = null;
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("select * from user where userName = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String employeeId = rs.getString("employeeId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String userName = rs.getString("userName");
				String pwd = rs.getString("password");
				String eMail = rs.getString("email");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String role = rs.getString("role");
				String position = rs.getString("position");
				String department = rs.getString("department");
				user = new User(employeeId, firstName, lastName, userName, pwd, eMail, telephone, address, role,
						position, department);
			}
			return user;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;

		} finally {
			close();
		}
	}

	public boolean updateEmployeeDetails(User user) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "update user set firstName = ?, lastName = ?, userName = ?, email = ?,"
					+ "telephone = ?, address =?,  role = ?, position = ? , department = ?, password = ?"
					+ " where employeeId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getEmail());

			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getRole());
			pstmt.setString(8, user.getPosition());
			pstmt.setString(9, user.getDepartment());
			pstmt.setString(10, user.getPassword());
			pstmt.setString(11, user.getEmployeeId());
			pstmt.execute();
			return true;
		} catch (Exception e) {

			System.out.println("Can't update...");
			return false;
		} finally {
			close();
		}

	}

	public String getEmployeePosition(String id) {
		String position = null;
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("select position from user where employeeId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				position = rs.getString("position");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return position;
	}

	public boolean register(User user) {
		try {
			conn = DBConnection.getConnectionToDatabase();

			String sql = "insert into user values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmployeeId());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getUserName());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getTelephone());
			pstmt.setString(8, user.getAddress());
			pstmt.setString(9, user.getRole());
			pstmt.setString(10, user.getPosition());
			pstmt.setString(11, user.getDepartment());

			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Inserted");
				return true;
			}
			return false;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			close();
		}
	}

	public boolean requestforPromotion(String userId, Promotion promotion) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "insert into user Promotion( ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, promotion.getYearsWorked());
			pstmt.setString(2, promotion.getCurrentPosition());
			pstmt.setString(3, "no");
			pstmt.setString(4, userId);
			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Inserted promotions");
				return true;
			}
			return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			close();
		}
	}

	private void close() {
		try {

			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (st != null) {
				st.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertWorkDetails(String userId, Work work) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "insert into work values( ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, work.getMonth());
			pstmt.setString(2, work.getYear());
			pstmt.setString(3, work.getType());
			pstmt.setString(4, userId);
			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Inserted works");
			}
			return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			close();
		}
	}

	public List<Work> getWorkDetails(String year, String employeeId, String month) {

		try {
			List<Work> listWorks = new ArrayList<Work>();
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select * from work where employeeId = ? and month = ? and year = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeId);
			pstmt.setString(2, month);
			pstmt.setString(3, year);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				listWorks.add(new Work(rs.getString("month"), rs.getString("year"), rs.getString("type")));

			}
			return listWorks;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			close();
		}
	}

	public List<Work> getAllWorkDetails() {

		try {
			List<Work> listWorks = new ArrayList<Work>();
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select * from work";
			st = conn.createStatement();

			rs = st.executeQuery(sql);

			while (rs.next()) {

				listWorks.add(new Work(rs.getString("month"), rs.getString("year"), rs.getString("type")));

			}
			return listWorks;
		} catch (Exception e) {
			return null;
		} finally {
			close();
		}
	}
//	public List<Work> getWorkDetails(String year,String userId, String month) {
//		
//		try {
//			List<Work> listWorks = new ArrayList<Work>();
//			conn = DBConnection.getConnectionToDatabase();
//			String sql = "select * from work where employeeId = 'af8e3d34-4911-4a13-b3f5-ac6001bc1787' ";
//			st = conn.createStatement();
//			
//			System.out.println(st);
////			pstmt.setString(1, userId);
//			rs = st.executeQuery(sql);
//			String m = rs.getDate("date").toLocalDate().getMonth().toString();
//			String y = String.valueOf(rs.getDate("date").toLocalDate().getYear());
//			
//			while (rs.next()) {
//				if (m.equals(month) && y.equals(year)) {
//					System.out.println("Hi");
//					listWorks.add(new Work(rs.getDate("date").toLocalDate(), rs.getString("type")));
//				}
//			}
//			return listWorks;
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		} finally {
//			close();
//		}
//	}
	
	public List<String> getPositions() {
		List<String> positions = new ArrayList<String>();
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select position from salaryscale";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				positions.add(rs.getString("position"));
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return positions;
	}

	public Double[] getSalaryScale(String position) {
		try {
			Double[] arr = new Double[3];
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select * from salaryscale where position = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, position);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr[0] = rs.getDouble("salary");
				arr[1] = rs.getDouble("overDayPayRate");
				arr[2] = rs.getDouble("deductionRate");
				return arr;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			close();
		}
	}

	public List<User> getEmployeeList() {
		List<User> user = new ArrayList<User>();
		try {

			conn = DBConnection.getConnectionToDatabase();
			String sql = "select employeeId,firstName,lastName from user";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				user.add(new User(rs.getString("employeeId"), rs.getString("firstName"), rs.getString("lastName")));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			close();
		}
		return user;
	}

	public List<Promotion> getPromotionRequest() {
		try {
			List<Promotion> promotion = new ArrayList<Promotion>();
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select * from promotions";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				boolean managerApproval = false;
				if (rs.getString("managerApproval").toLowerCase().equals("yes")) {
					managerApproval = true;
				}
				promotion.add(new Promotion(rs.getInt("yearsWorked"), rs.getString("currentPosition"), managerApproval,
						rs.getString("employeeId"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("department")));
			}
			return promotion;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			close();
		}
	}

	public boolean submitPromotionRequest(Promotion promotion, String employeeId) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "insert into promotion-request values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, promotion.getYearsWorked());
			pstmt.setString(2, promotion.getCurrentPosition());
			pstmt.setBoolean(3, promotion.getManagerApproval());
			pstmt.setString(4, employeeId);

			if (pstmt.executeUpdate() > -1) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			close();
		}

	}

	public void promote(String id, String selectedPromotion) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("update user set position = ? where employeeId = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, selectedPromotion);
			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Updated..");
			}
			pstmt = conn.prepareStatement("update promotions set currentPosition = ? , managerApproval = ? where employeeId = ?");
			pstmt.setString(1, selectedPromotion);
			pstmt.setString(2, "yes");
			pstmt.setString(3, id);
			
			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Updated Employee..");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
	}
	
	public boolean insertIntoPayments(SalaryPayment payment) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("insert into payment values(?,?,?,?.?)");
			pstmt.setDate(1, Date.valueOf(payment.getDate()));
			pstmt.setDouble(2, payment.getSalary());
			pstmt.setDouble(3, payment.getCompasanation());
			pstmt.setDouble(4, payment.getDeduction());
			pstmt.setDouble(5, payment.getPayment());
			
			if(pstmt.executeUpdate() >-1) {
				System.out.println("Successfully Inserted.");
				return true;
			}
			return false;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			close();
		}
		
	}
	
}