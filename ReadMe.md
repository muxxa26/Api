# RestAssured API Testing Automation Framework
This project has a RestAssured based API testing framework. Underlying, it uses RestAssured -API testing library, Cucumber - Third-party free library for Running tests. This framework can be used for any Restful application to create API tests.

# Contents
* [Framework Details](#FrameworkDetails)
	* [Framework - What and Why?](#ww)
	* [Project structure](#structure)
	* [Properties](#properties)
* [Packages](#package)
	* [Main Package](#main)
	* [Test Package](#test)


# Framework Details<a name="FrameworkDetails"></a>
#### Base API<a name="api"></a>
> We(Jee,Mohamed) have used [Restful-booker](https://restful-booker.herokuapp.com/apidoc/index.html ) API as a basis for the API test framework. Restful-booker is a Create Read Update Delete Web API that comes with authentication features and loaded with a bunch of bugs for you to explore. The API comes pre-loaded with 10 records for you to work with and resets itself every 10 minutes back to that default state. Restful-booker also comes with detailed API documentation to help get you started with your API testing straight away.

#### Framework - What and Why?<a name="ww"></a>
> For any software requirement, certain common and basic tasks need to be performed. Such tasks would have been already solved and would be available as open-source/free projects. One can use that and build their code on top of it to solve the software requirements specific to them.
      
#### Project structure<a name="structure"></a>
> This project uses a standard Maven Java project with standard java folder structure and POM.xml

#### Properties<a name="properties"></a>
> `src/main/resources/constants.properties` is a simple constants properties file to store various constants like application URL, DB & SSH details.

# Packages<a name="package"></a>
#### Main Package
> `src/main/java/` is the core package of Framework and it has various sub-packages dedicated  for various API testing functionalities. All sub-package details are mentioned in the following section. Added necessary documentation to all classes. 

#### Test Package<a name="test"></a>
> `src/test/java/` is the actual test package and the sub package  holds all test scenarios (BDD) related to restfulbooker application. 



## Main Package<a name="main"></a>
```
- com.actions
	 - HttpOperation.java
	 - ValidatorOperation.java
- com.interfaces
	- APIs.Java
- com.restassuredFunctions
	- API.java
- com.restfulbooker.apitest.utilities
	- DBConnection.Java
	- Helper.java
	- SshConnectionManager.java
- com.restfulbooker.apitest.baseAPI
	- Application API End points
```

### 1.com.restfulbooker.apitest.actions
#### HttpOperation.java
 > Its a Java Enum type, which is implemented to have a set of different HttpOperation constants. Which can be used to create, read, update, and delete (or CRUD) operations, respectively.

#### ValidatorOperation.java
> Its a Java Enum type, which is implemented to have a set of different ValidatorOperation constants. Which can be used in response json assertions.

### 2.com.interfaces
#### IApi.java
> It contains all the methods needed to write API tests and provides basic assertion APIs. It is the blueprint of the `API.java` class.

### 3.com.restassuredFunctions
#### API.java
> The `API.java` class which implements the IApi interface defines complete functionality for the methods declared in the `IApi interface`.

### 5.com.api.utilities
#### DBConnection.java
> A Singleton Java class for MySQL DB connection. It contains insert, update, truncate, and query methods, apart from that it has a singleton pattern to connect to MySQL database. All database constants(URL,dbname, username, etc) can be found in Constants.properties file.

#### Helper.java
> Its a custom Java helper class, which contains some reusable functions for reading CSV / TSV files, common JSON path assertions, etc.Its a Java class for SSH remote server connection. It contains methods to create/close new SSH sessions and methods to execute SSH commands.

#### SshConnectionManager.java
> Its a Java class for SSH remote server connection. It contains methods to create/close new SSH sessions and methods to execute SSH commands

### 6.com.baseAPI
`com.restfulbooker.apitest.baseAPI` represents application’s each API entities with web service’s request data properties like request headers & request body data. For each API endpoint, one java file should be there with different functions/methods for each HTTP action. (eg:- for /users API, one java file (users.java) would be created. If /users support GET, POST&PUT HTTP methods then 3 unique functions/methods should be there in users.java file to invoke different HTTP actions of /users API).  In order for the tests to work properly, names of the fields(request data(headers, body)) must match the application's API structure convention.


# Simple Example Test<a name="example"></a>
Now, let's get started with the simple example – a basic booking sites login page:

## API Details
> `Post` https://www.mwtestconsultancy.co.uk/auth

**Header**
| Field  | Type | Description | 
| --- | --- | --- |
| Content-Type | String  | Sets the format of payload you are sending Default value: `application/json` |

**Request body**
| Field  | Type | Description | 
| --- | --- | --- |
| username	| String | Username for authentication, Default value: `admin` |
| password	| String | Password for authentication, Default value: `password123` |
		
**Success 200**
| Field  | Type | Description |
| --- | --- | --- |
| token	| String | Token to use in future requests |

**Response** 
```
HTTP/1.1 200 OK

{
    "token": "abc123"
}		
```





