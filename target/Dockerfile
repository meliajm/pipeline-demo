FROM tomcat:8-jre8-alpine
#comment
RUN rm -rf /usr/local/tomcat/webapps/*
COPY YelloServlet.war /usr/local/tomcat/webapps/YelloServlet.war
CMD [ "catalina.sh", "run"]
