1) JNDI LOOKUP CONFIG

	<jee:jndi-lookup
		id="dataSource"
		jndi-name="jdbc/musicdb"
		expected-type="javax.sql.DataSource" />
	
2) MYSQL CONFIG

	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> 
		<property name="driverClassName" value="com.mysql.jdbc.Driver" /> 
		<property name="url" value="jdbc:mysql://localhost:3306/musicdb?useSSL=false" />
		<property name="username" value="prospring5" /> 
		<property name="password" value="prospring5" />
	</bean>
		
3) EMBDEDED DATABASE (H2) CONFIG

	<jdbc:embedded-database id="dataSource"
		type="H2" >
		<jdbc:script location="classpath:db/schema.sql" />
		<jdbc:script location="classpath:db/data.sql" />
	</jdbc:embedded-database>