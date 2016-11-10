package com.banking.pool;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.swing.filechooser.FileSystemView;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PoolConfig  {
	HikariConfig config=null;
	HikariDataSource dataSource=null;
	Properties props=null;

	static{
		try {
			Class.forName("java.io.FileInputStream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PoolConfig(){
		config=new HikariConfig();
		
		try {
			props=getProperties();
			if(props!=null){
			config.setJdbcUrl(props.getProperty("config.jdbcUrl"));
			config.setUsername(props.getProperty("config.username"));
			config.setPassword(props.getProperty("config.password"));
			config.addDataSourceProperty("cachePrepStmts", Boolean.getBoolean(props.getProperty("config.cachePreparedStatments")));
			config.addDataSourceProperty("prepStmtCacheSize", props.getProperty("config.preparedStatementCache"));
			config.addDataSourceProperty("prepStmtCacheSqlLimit", props.getProperty("config.preparedStatementCacheSqlLimit"));
			config.addDataSourceProperty("useServerPrepStmts",Boolean.getBoolean(props.getProperty("config.useServerPrepStatements")));
			config.setConnectionTestQuery(props.getProperty("config.testQuery"));
			config.setLeakDetectionThreshold(10000);
			config.setConnectionTimeout(3000);
			config.setIdleTimeout(30000);
			config.setMaxLifetime(30000);
			config.setAutoCommit(true);
			
			dataSource=new HikariDataSource(config);
			dataSource.setMinimumIdle(Integer.parseInt(props.getProperty("dataSource.minimumIdle")));
			dataSource.setMaximumPoolSize(Integer.parseInt(props.getProperty("dataSource.maximumPoolSize")));
			dataSource.setDataSourceClassName(props.getProperty("dataSource.DataSourceClassName"));
			dataSource.addDataSourceProperty("port", Integer.parseInt(props.getProperty("dataSource.port")));
			dataSource.addDataSourceProperty("databaseName",props.getProperty("dataSource.databaseName"));
			dataSource.addDataSourceProperty("user",props.getProperty("dataSource.user"));
			dataSource.addDataSourceProperty("password", props.getProperty("dataSource.password"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Properties getProperties(){
		Properties properties=null;
		FileInputStream fileInput=null;
		
		try {	
			//URL url=getClass().getClassLoader().getResource("hikariConfig.xml");
			//File file =new File(url.getPath());
			//URL url=new URL(null, "classpath:src/main/resources/HikariConfig.xml", new com.banking.pool.Handler(ClassLoader.getSystemClassLoader()));
			
			File file = new File(System.getProperty("catalina.base")+"/"+"wtpwebapps/Application/WEB-INF/classes/HikariConfig.xml");
			
			fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.loadFromXML(fileInput);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(fileInput!=null)
				fileInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(properties!=null)
		if(!properties.isEmpty())
			return properties;
		
		return null;
		
	}
	
	public HikariDataSource getDataSource(){
		return dataSource;
	}
	
	public HikariConfig getHikariConfig(){
		return config;
	}

}
