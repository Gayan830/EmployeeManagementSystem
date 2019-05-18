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

import com.empmanagement.entity.Loan;
import com.empmanagement.entity.Notification;
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
				String registered = rs.getString("registered");
				user = new User(employeeId, firstName, lastName, userName, pwd, eMail, telephone, address, role,
						position, department,registered);
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
					+ "telephone = ?, address =?, , department = ?, password = ?"
					+ " where employeeId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getEmail());

			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getAddress());
			
			pstmt.setString(7, user.getDepartment());
			pstmt.setString(8, user.getPassword());
			pstmt.setString(9, user.getEmployeeId());
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

	public String getEmployeeFullName(String id) {
		String fullName = null;
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("select firstName,lastName from user where employeeId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fullName = rs.getString("firstName")+" "+rs.getString("lastName");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return fullName;
	}
	
	public boolean register(User user) {
		try {
			conn = DBConnection.getConnectionToDatabase();

			String sql = "insert into user values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
			pstmt.setString(12, "no");

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

	public List<Double> getSalaryScale(String position) {
		try {
			List<Double> arr = new ArrayList<Double>();
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select * from salaryscale where position = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, position.toLowerCase());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("here");
				arr.add(rs.getDouble("salary"));
				arr.add(rs.getDouble("ovarDayPayRate"));
				arr.add(rs.getDouble("deductionRate"));
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
	
	public double getSalary(String position) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "select salary from salaryscale where position = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, position);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getDouble("salary");
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
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
				System.out.println("hello");
				promotion.add(new Promotion(
						rs.getInt("yearsWorked"),rs.getString("currentPostion"), rs.getString("managerApproval"),
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

	public boolean submitPromotionRequest(Promotion promotion) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			String sql = "insert into promotions(firstName,lastName,currentPostion,yearsWorked,department,managerApproval,employeeId) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, promotion.getFirstName());
			pstmt.setString(2, promotion.getLastName());
			pstmt.setString(3, promotion.getCurrentPosition());
			pstmt.setInt(4, promotion.getYearsWorked());
			pstmt.setString(5, promotion.getDepartment());
			pstmt.setString(6, promotion.getManagerApproval());
			pstmt.setString(7, promotion.getEmployeeId());

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
			pstmt = conn.prepareStatement(
					"update promotions set currentPostion = ? , managerApproval = ? where employeeId = ?");
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

	public boolean insertIntoPayments(SalaryPayment payment, String month, String year) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement(
					"insert into payment(datePaid,month,year,salary,compesanation,deduction,payment,approval) values(?,?,?,?,?,?,?,?)");
			pstmt.setDate(1, Date.valueOf(payment.getDate()));
			pstmt.setString(2, month);
			pstmt.setInt(3, Integer.parseInt(year));
			pstmt.setDouble(4, payment.getSalary());
			pstmt.setDouble(5, payment.getCompasanation());
			pstmt.setDouble(6, payment.getDeduction());
			pstmt.setDouble(7, payment.getPayment());
			pstmt.setString(8, "No");

			if (pstmt.executeUpdate() > -1) {
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

	public void insertNotification(String id, String approval, String type, String specific) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("insert into notification(date, approval, type, specialMsg, employeeId) values(?,?,?,?,?)");

			pstmt.setDate(1, Date.valueOf(LocalDate.now()));
			pstmt.setString(2, approval);
			pstmt.setString(3, type);
			pstmt.setString(4, specific);
			pstmt.setString(5, id);

			if (pstmt.executeUpdate() > -1) {
				System.out.println("Successfully Inserted into notifications");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public List<Notification> getNotifications(String id) {
		List<Notification> notifications = new ArrayList<Notification>();
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("select * from notification where employeeId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				notifications.add(new Notification(rs.getDate("date"),rs.getString("approval"),rs.getString("type"),rs.getString("specialMsg")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return notifications;
	}

	public boolean insertLoanRequest(Loan loan,String empid) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("insert into loan(loanAmount,rePaymentYears,installment,approvalManager,purpose,employeeId) "
					+ "values(?,?,?,?,?,?)");
			pstmt.setDouble(1, loan.getLoanAmount());
			pstmt.setDouble(2, loan.getRePaymentYears());
			pstmt.setDouble(3, loan.getInstallment());
			pstmt.setString(4, loan.getApprovalManager());
			pstmt.setString(5, loan.getPurpose());
			pstmt.setString(6, empid);
			if(pstmt.executeUpdate()>-1) {
				System.out.println("Inserted Successfully");
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
	
	private String getFullName(String empId) throws SQLException{
		PreparedStatement pst = conn.prepareStatement("select firstName,lastName from user where employeeId = ?");
    	pst.setString(1, empId);
		ResultSet r = pst.executeQuery();
    	if(r.next()) {
    		return r.getString("firstName") +" " + r.getString("lastName") ;
    	}
    	return null;
	}
	
	public List<Loan> getLoanRequests() {
		List<Loan> loanList = new ArrayList<Loan>();
		try {
			conn = DBConnection.getConnectionToDatabase();
			st = conn.createStatement();
			rs = st.executeQuery("select * from loan");
		    while(rs.next()) {
		    	System.out.println("here comes");
		    	double loanAmount = rs.getDouble("loanAmount");
		    	int rePaymentYears = rs.getInt("rePaymentYears");
		    	double installment = rs.getDouble("installment");
		    	String approvalManager = rs.getString("approvalManager");
		    	String purpose = rs.getString("purpose");
		    	String empId = rs.getString("employeeId");
		    	int id = rs.getInt("id");
		    	String name = getFullName(empId);
		    	loanList.add(new Loan(id,loanAmount,rePaymentYears,installment,approvalManager,purpose,name,empId));
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return loanList;
	}

	public boolean updateNotification(int id,String approval) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("update notification set approved = ? where employeeId = ?");
			pstmt.setInt(1, id);
			pstmt.setString(2, approval);
			if(pstmt.executeUpdate()>-1) {
				System.out.println("updated notification state successfully");
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean deleteNotification(String employeeId) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("delete from notification where employeeId = ?");
			pstmt.setString(1, employeeId);
			if(pstmt.executeUpdate()>-1) {
				System.out.println("Deleted Successfully.");
				return true;
			}
			return false;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	} 
	
	public List<User> getUnregisteredUsers() {
		List<User> users = new ArrayList<User>();
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("select * from user where registered = ?");
			pstmt.setString(1, "no");
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				String registered = rs.getString("registered");
				users.add( new User(employeeId,firstName,lastName,userName,pwd,eMail,telephone,address,role,position,department,registered));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return users;
	}
	
	public void approveRegistration(String id) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("update user set registered = ? where employeeId = ? ");
			pstmt.setString(1, "yes");
			pstmt.setString(2, id);
			if(pstmt.executeUpdate()>-1) {
				System.out.println("user registered successfully.");
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public void approveLoan(String id) {
		try {
			conn = DBConnection.getConnectionToDatabase();
			pstmt = conn.prepareStatement("update loan set approvalManager = ? where employeeId = ? ");
			pstmt.setString(1, "yes");
			pstmt.setString(2, id);
			if(pstmt.executeUpdate() > -1) {
				System.out.println("successfully updated loans table");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
	}
	

	
}