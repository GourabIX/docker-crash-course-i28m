FROM tomcat:9.0.58-jre8-openjdk
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
ENTRYPOINT ["catalina.sh","run"]
