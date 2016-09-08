# PKMST-Toolkit
This is the base from where the pkmst maven archetype is created.It contains a HelloController which is used as a base for cucumber testing and reporting.
SpringMicroApplication class which is the starter is enabled with spring cloud config server and eureka server, configuration of which can be done using
application.yml
Generate archetype using mvn archetype:create-from-project
Archetype will be generated in the target folder.
Now do the mvn clean install from target\generated-sources\archetype