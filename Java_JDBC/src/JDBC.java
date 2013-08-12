import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static Connection getConnection() {
		final String url = "jdbc:mysql://127.0.0.1:3306/test";
		final String sUsr = "root";
		final String sPwd = "1234";
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			return DriverManager.getConnection(url, sUsr, sPwd);
		} catch (final ClassNotFoundException e) {
			// TODO 找不到驱动
		} catch (final SQLException e) {
			// TODO 创建连接异常
		}
		return null;
	}

	public static void get() throws SQLException {
		final String sql = "SELECT id,name FROM user where id=?";
		PreparedStatement pstmt = null;
		final Connection cn = getConnection();
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, 468000);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("id"));
				System.out.print(":");
				System.out.print(rs.getString("name") + "\r\n");
			}
			rs.close();
			pstmt.close();
		}

		finally {
			try {
				cn.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void add() throws Exception {
		 String url = "jdbc:mysql://127.0.0.1:3306/test";
		final String user = "root";
		final String pwd = "1234";
		Connection cn = null;
		Statement stm = null;

		try {
			System.out.println("cn======" + cn);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			  System.out.println("找不到驱动程序"); 
		}
		System.out.println("cn======" + cn);	
	    url = "jdbc:mysql://localhost:3306/GUESTBOOK?user=root&password=123456"; 
        Connection conn = DriverManager.getConnection(url); 
        if(!conn.isClosed()) 
        System.out.println("数据库连接成功!");
        conn.close(); 
        
//		cn = DriverManager.getConnection(url, user, pwd);
//		
//		stm = cn.createStatement();
//		System.out.println("cn======" + stm);
//		final String sql = " insert into user values(9999999,'123','2008-01-01')";
//		stm.execute(sql);

		// finally
		// {
		// stm.close();
		// cn.close();
		// }
	}

	public static void main(final String[] args) throws Exception {
		// get();
		add();
	}
}