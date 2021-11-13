@echo off
call mvn clean package
call docker build -t ma.emsi/tpCustomerApplication1 .
call docker rm -f tpCustomerApplication1
call docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplication1 ma.emsi/tpCustomerApplication1