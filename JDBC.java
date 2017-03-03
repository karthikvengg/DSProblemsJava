package JDBCTest2.Example2;

import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class JDBC {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
    	//System.out.print(con.isValid(0));
    	//Statement stmt=null;
    	PreparedStatement stmt=null;
    	//String query = "SELECT * FROM sys.user";
    	String query = "INSERT INTO sys.user VALUES ('umarjani','uma@uma@com')";
    	//stmt = con.createStatement();
    	stmt = con.prepareStatement(query);
    	//stmt.setString(1,"umarani");
    	//stmt.setString(2,"uma@uma.com");
    	//Boolean result = stmt.execute(query);    	
    	int rows = stmt.executeUpdate(query);
    	//ResultSet rs = stmt.executeQuery(query);
    	System.out.println("Return value is : " + rows );
    	/*while(rs.next()){
    		System.out.print(rs.getString("username")+" ");
    		System.out.println(rs.getString("email"));
    	}*/
    	//rs.close();
    	stmt.close();
    	con.close();
    	return "Got it!";
    }
}
