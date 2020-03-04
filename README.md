This springboot application is for call rest services from BookStore API (https://gitlab.mynisum.com/nvakiti/bookstore-api.git)

Below are the URL's of BookStore App

http://localhost:8082/getbooks 
Above Url access http://localhost:8083/getbookdetails BookStore-API Rest service

http://localhost:8082/getauthor
Above Url access http://localhost:8083/getauthordetails BookStore-API Rest service

http://localhost:8082/addbooks
Above Url access http://localhost:8083/addbookdetails BookStore-API Rest service


Same above URL's we can access through gateway application using below URL's
http://localhost:8081/bookstore/getbooks
http://localhost:8081/bookstore/getauthor
http://localhost:8081/bookstore/addbooks


