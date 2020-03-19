
--------------------------------------------
Data Exfiltration Activity - Part 1
--------------------------------------------
In a data exfiltration attack, the goal of the attacker is to stealthily extract/exfiltrate sensitive
private information from a user’s smartphone. In the first part of the activity, you will develop a
simple web application capable of storing data sent to it, which will be used for Part 2, in which
you will create the actual attack.

Activity Statement:

Using a programming language of your choice (preferably Java, Python or JavaScript and its
extension frameworks), create a simple web application that can store data sent to it via HTTP
request methods such as GET, POST or PUT.

-------------------------
Design Decisions
-------------------------

Our project is built on Spring boot technology. We created a RESTful Web service using Spring.

This service accepts an HTTP POST request and returns a JSON representation of the data that was sent.

The project is maven based and the dependencies were installed using POM.xml.

To execute this project you will need:
1. JDK 1.8 or later
2. Maven 3.2+
3. An IDE like Intellij or Eclipse to execute the project

The project can be run using the IDE or a command prompt in Windows or a Terminal on Mac.

The service will handle a /POST request for /createOutputFile, optionally with any key value pair passed into the url as headers.
Example: http://localhost:8080/createOutputFile?username=john&password=password@123&country=Newzealand

-------------------------
Resource Representation
-------------------------

Resource representation returns a JSON with all the headers sent via HTTP request.

-------------------------
Resource Controller
-------------------------

The resource controller handles the HTTP requests and processes them and returns appropriate responses. Instead of relying on a view based technology, to perform a server-side rendering into an HTML, this RESTful Web service controller returns an "Attack" object. The object data is written directly to the HTTP in the form of a JSON.


The application is executable and is in the form of a "jar" file.

1. Execute the "AttackApplication.java" from the IDE.

2. The application executes and says "Started Application" in the console



3. Hit the url http://localhost:8080/createOutputFile on a browser of your choice. But alternatively
   open up any of the REST Clients like Postman or SOAP UI
4. Feed the URL above and add additional headers as shown in the example.


5. Then hit "Send"
6. Look for an "Output" folder in the Desktop.
7. To view the response, open the output.txt file.




-------------------------
Reference Links
-------------------------
https://spring.io/guides/gs/rest-service/#initial


-------------------------
Contributed by:
-------------------------
Arjun Kalidas, Tabish Maniar and John McMillan

