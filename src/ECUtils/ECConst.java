package ECUtils;
public interface ECConst {
	String DB_NAME ="colg";
	String DB_HOST="localhost";
	String DB_USER="root";
	String DB_PASS ="";
	String SQLS[] = 
	{
		"create table teachers (id varchar(40) , user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), deprt varchar(40), quali varchar(40))",	
		"create table civil(id varchar(40) , user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table mech (id varchar(40), user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table cse (id varchar(40), user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table it (id varchar(40), user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table eee (id varchar(40), user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table etc (id varchar(40), user_name varchar(40), phone_no varchar(15), PRIMARY KEY (id), email varchar(40), sem varchar(40))",	
		"create table user(user_name varchar(40), password varchar(40),ques varchar(100),ans varchar(40), PRIMARY KEY (user_name))",
	};
       
}
