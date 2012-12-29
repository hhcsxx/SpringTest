package net.chuangdie.lhb.test;

import javax.sql.DataSource;

import net.chuangdie.lhb.bean.ComImpl;
import net.chuangdie.lhb.bean.Shopping;
import net.chuangdie.lhb.bean.Transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring implements GreetingService
{
	private String greeting;
	private static DataSource source;

	private Shopping shopping;

	public void sayGreeting()
	{
		System.out.println(greeting);
	}

	public String getGreeting()
	{
		return greeting;
	}

	public void setGreeting(String greeting)
	{
		this.greeting = greeting;
	}

	public static void main(String[] args) throws Exception
	{
		ApplicationContext factory = new FileSystemXmlApplicationContext(
				"src/main/resources/hello.xml");
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		greetingService.sayGreeting();

		Shopping shopping = (Shopping) factory.getBean("shopping");
		// shopping.createTable();
		shopping.setName("wqwqwa");
		shopping.setPrice(2.21);
		// shopping.insert(shopping);
		Transaction transaction = (Transaction) factory.getBean("transaction");
		// transaction.createTable();
		transaction.setIn_cash(100d);
		transaction.setOut_cash(5.05);
		transaction.setCreate_date(1356589216);
		// transaction.insert(transaction);

		ComImpl comImpl = (ComImpl) factory.getBean("com");
		comImpl.enrollStudentInCourse(shopping, transaction);
		// Connection conn = null;
		// PreparedStatement stmt = null;
		// ResultSet rs = null;
		//
		// source = (DataSource) factory.getBean("dataSource",
		// DataSource.class);
		//
		// conn = source.getConnection();
		// String sql = "select * from users";
		// stmt = conn.prepareStatement(sql);
		// rs = stmt.executeQuery();
		// while (rs.next())
		// {
		// System.out.println("id:" + rs.getInt("id"));
		// System.out.println("name:" + rs.getString("user_name"));
		// System.out.println("password:" + rs.getString("password"));
		// }
	}
}
