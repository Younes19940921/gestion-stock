package metier;
import java.sql.Connection;
import java.sql.DriverManager;





public class  Iconnection {
	private static Connection connection;
	static  {	
	    try {
		       Class.forName("com.mysql.jdbc.Driver");		
		       connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gproduit","root","youness33");
		       System.out.println("connected");    }
		catch (ClassNotFoundException e) {
			       System.out.println("Impossible de charger le driver");
		            }
		catch(Exception ex) {
			System.out.println("Error de connexion");
				    }}
	public static Connection getConnection() {
		return connection;
	}
	
	
}
