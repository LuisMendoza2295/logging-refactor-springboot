# Logger-Refactor
This is a Spring Boot project, which allows to print and store logs on different places. Also, it allows to include this as part of another project and create your own loggers.

## Instructions
If you're in a Windows host, deploy the application into a Tomcat server, and the file logs will be stored at the **logger.file.path**
Otherwise, you have to change the **file-system path** where the logs are going to be stored
### Properties
- logger.file.path=D://mylogger//logfile.txt

To change the path property, just override the **SPRING_APPLICATION_JSON** environment variable, and at **logger.file.path** key, set your own file-path
For the container, the path has been defined as **/usr/local/tomcat/logs/logfile.txt**

To see the database stored logs, in the browser go to **localhost:{your_host_bind_port}/h2** with the following:

- URL: jdbc:h2:mem:db
- user: sa
- password: sa