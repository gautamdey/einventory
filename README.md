Installation steps
1. Create a mariadb database
2. create a user root and password blank 
3. run the db script it will create a schema razzeldazzel 
4. Install tomcat. 
5. checkout the code on eclipse and run mvn clean install. 
6. Create a tomcat runtime on eclipse and deploy the application from within eclipse. 
7 . add the following to the context.xml file of the tomcat/conf folder 
8. Add mariadb-java-client-1.3.3.jar to the lib folder of Tomcat.
<Resource name="jdbc/razzeldazzel" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="root" password="" driverClassName="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/razzeldazzel"/>

