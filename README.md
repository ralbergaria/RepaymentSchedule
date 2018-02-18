# RepaymentSchedule
- Exemple for gerate a plan with payment schedule

Plugins integration
-
- spring-boot-starter-parent 1.5.3.RELEASE
- spring-boot-starter-web
- spring-boot-starter-test
- maven-embedded-glassfish-plugin (for application service)

Tecnologies
-
- Caching results
- API Restfull

How Execute
-
- You will need set your  MAVEN_OPTS = -Xmx1024m -XX:MaxPermSize=128m
- Use Java 8
- Use the command mvn -DforkMode=never -DforkCount=0  clean install package test
