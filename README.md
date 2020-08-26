# Logger-Refactor
This is a Spring Boot project, which allows to  print and store logs on different places. Also it allows to include this as part of another project and create your own loggers.

## Instructions
If you're in a Windows host, just execute the **docker-compose up** command, and the file logs will be stored at the default **logger.file.path**
Otherwise, you have to change the **file-system path** where the logs are going to be stored
### Properties
- logger.file.path=D://mylogger//logfile.txt
### 

To change the path property, just override the **SPRING_APPLICATION_JSON** environment variable, and at **logger.file.path** key, set your own file-path