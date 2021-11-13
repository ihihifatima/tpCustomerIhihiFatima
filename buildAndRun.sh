#!/bin/sh
mvn clean package && docker build -t ma.emsi/tpCustomerApplication1 .
docker rm -f tpCustomerApplication1 || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplication1 ma.emsi/tpCustomerApplication1