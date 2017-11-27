package util;

public class SqlQuery {
	public static final String SELECT="select *from dbo.JDBC";
	public static final String FIRST_COLUMN="ACCOUNT";
	public static final String SECOND_COLUMN="FIRSTNAME";
	public static final String THIRD_COLUMN="LASTNAME";
	public static final String FORTH_COLUMN="EMAIL";
	public static final String INSERT="insert into dbo.JDBC("+FIRST_COLUMN+","+SECOND_COLUMN+","
			+ ""+THIRD_COLUMN+","+FORTH_COLUMN+") values(?,?,?,?)";
	public static final String UPDATE = "UPDATE dbo.JDBC SET " + SECOND_COLUMN + "=?, " + THIRD_COLUMN
		      + "=?, " + FORTH_COLUMN + "=?  WHERE " + FIRST_COLUMN + " = ?";
	public static final String FIND_BY_ACCOUNT="select ACCOUNT from dbo.JDBC where ACCOUNT=?";
	public static final String SELECT_ACCOUNT="select *from dbo.JDBC where ACCOUNT=?";
	public static final String DELETE_ACCOUNT="delete from dbo.JDBC where ACCOUNT=?";
}
