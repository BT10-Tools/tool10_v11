package tool10.sql;

import java.sql.Connection;

public class LogSqliteDb {

	/*
	<Configuration status="WARN">
    <Appenders>
        <!-- Console Appender Configuration -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        </Console>
        <JDBC name="demo-db-appender" tableName="logs">
            <DriverManager>                
                <driverClassName>org.sqlite.JDBC</driverClassName>
                <connectionString>jdbc:sqlite:/home/demo/sqlite_data/demologs.db</connectionString>
            </DriverManager>
            <Column name="timestamp" pattern="%d{yyyy-MM-dd HH:mm:ss}"/>
            <Column name="loglevel" pattern="%p"/>
            <Column name="message" pattern="%m"/>
            <Column name="exception" pattern="%ex"/>
            <Column name="thread" pattern="%t"/>
        </JDBC>
    </Appenders>
    <Loggers>
        <!-- Root Logger Configuration -->
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
        <!-- Application Specific Logger Configuration -->
        <Logger name="com.example" level="info" additivity="false">
            <AppenderRef ref="demo-db-appender"/>
        </Logger>
        
        <Logger name="org.apache.logging.log4j" level="DEBUG">
            <AppenderRef ref="Console"/>
       </Logger>
        
    </Loggers>
</Configuration>
    */   
	//<Column name="log_date_time" isEventTimestamp="true" />
	//  <Column name="clazz" pattern="%logger" isUnicode="false" />
	//   <Column name="level" pattern="%level" isUnicode="false" />
	//   <Column name="log" pattern="%message"  isClob="false" isUnicode="false" />
	//   <Column name="exception" pattern="%ex{full}" isClob="false" isUnicode="false" />
	
	//https://github.com/apache/logging-log4j2/discussions/2911
	public static void createLogTable(Connection connection)	{
		String sqlStr2 = "CREATE TABLE public.logs ( \n\r"+
		" id bigserial NOT NULL, \n\r"+
		" log_date_time timestamp NULL, \n\r"+
		" \"level\" varchar(255) NULL, \n\r"+
		" clazz varchar(255) NULL,  \n\r"+
		" log text NULL,  \n\r"+
		" \"exception\" text NULL,  \n\r"+
		" job_run_id varchar(255) NULL,  \n\r"+
		" created_by varchar(50) NOT NULL DEFAULT 'system'::character varying, \n\r"+
		" created_date timestamp NOT NULL DEFAULT now(), \n\r"+
		" last_modified_by varchar(50) NULL, \n\r"+
		" last_modified_date timestamp NULL, \n\r"+
		" CONSTRAINT log_pkey PRIMARY KEY (id) \n\r"+
		" ) \n\r";
		
		String sqlStr = "CREATE TABLE logs (  \n"+
		   " id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Unique identifier for each log entry \n"+
		   " timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Time the log entry was created  \n"+
		   " level VARCHAR(10),  -- Severity level of the log (e.g., INFO, WARN, ERROR)  \n"+
		   " message TEXT,  -- Log message content  \n"+
		   " exception TEXT,  -- Optional field to store exception details, if any   \n"+
		   " thread VARCHAR(255)  -- Thread name that generated the log entry  \n"+
		   " )  \n"; 
		int cntUpdated = JLite.executeUpdate(connection, sqlStr);
	}
	public static void createIndexes(Connection connection)	{
		//-- Index on the timestamp column
		String sqlStr = "CREATE INDEX idx_timestamp ON logs (timestamp)";
		JLite.executeUpdate(connection, sqlStr);
	}
	public static void createLogDb(String dbFileName)	{
		Connection connection = JLite.getConnection(dbFileName);
		createLogTable(connection);
		createIndexes(connection);
	}
	public static void main(String[] args) {
		String dbFileName = "C:\\app\\sqlite\\similarity\\tool10Log.db";
		
		createLogDb(dbFileName);
		        		
	}
}
