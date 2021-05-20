# ScrapeIt

## Table of elements
* [Description](#description)
* [Technogy Stack](#technogy-stack)
* [App Testing](#app-testing)

## Description
>The application is a new feature of web scraping project. It’s major functionality is uploading the files to database, getting information about the object in JSON format and download the file if required.

## Technogy Stack
* Java
* Spring MVC
* MySQL
* DTO
* Exception handling
* Postman (test)


## Application Testing

### Add object: method „POST” 
POSTMAN passes the file to database. Persist it’s name, add unique 'id' and some metadata.<br>
http://localhost:8080/file/upload<br>
Body:<br> Key=”file”<br> Value=”TXChiropractor.txt”<br>
Successfull request get response: 'status 200' with below informaton:
````json
[{
	"id": 4,
	"fileType": "text/plain",
	"message": "File has been uploaded successfully!",
	"uploadStatus": true
}]
````

### Display list of objects: method „GET” 
http://localhost:8080/file/list<br>
Returns list of files previously saved to db.<br>
Successfull request get response: 'status 200'.

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

### Display object per id: method „GET” 
http://localhost:8080/file/get/4<br>
Returns information about chosen file in JSON format.
Successfull request get response: 'status 200'.

JSON:
````json
[{
	"fileId": 4,
	"fileName": "TXChiropractor.txt",
	"createdAt": "2021-05-20T23:39:50.000+00:00"
}]
````

### Download the file by id: method „GET”
http://localhost:8080/file/download/1<br>
http://localhost:8080/file/download/4<br>
Returns the file in txt, jpg etc.
