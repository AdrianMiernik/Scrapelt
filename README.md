# ScrapeIt

## Table of elements
* [Description](#description)
* [Technogy Stack](#technogy-stack)
* [App Testing](#app-testing)

## Description
>The application is a new feature of web scraping project. It’s major functionality is upload the files to database, getting information about the object in JSON format and download the file if necessary.

## Technogy Stack
* Java
* Spring MVC
* MySQL
* DTO
* Exception handling
* Postman (test)


## Application Testing

### Add object: method „POST” 
POSTMAN passes the file to database. Persist it’s name, add unique id and some metadata. 
POST http://localhost:8080/file/upload<br>
Headers: Key=”file”<br> Value=”TXChiropractor.txt”
Succesfull request get response: 'status 200' with below informaton as a return:
````json
[{
"id": 4,
"fileType": "text/plain",
"message": "File has been uploaded successfully!",
"uploadStatus": true
}]
````

### Display list of objects: method „GET” 
Exempli gratia: http://localhost:8080/file/list<br>
Returns list of files saved to MySql.

JSON:
````json
[{
	"id": 1,
	"name": "Logo.png"
},{
	"id": 2,
	"name": "SpringBootDocumentation.odt"
},{
	"id": 3,
	"name": "ScrapItCodingTask.docx"
},{
	"id": 4,
	"name": "TXChiropractor.txt"
}]
````
