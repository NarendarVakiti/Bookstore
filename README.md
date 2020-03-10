This springboot application is for call rest services from BookStore API (https://gitlab.mynisum.com/nvakiti/bookstore-api.git)

**Below are the URL's of BookStore App**


*  http://localhost:8082/getbooks 

    Above Url access http://localhost:8083/getbookdetails BookStore-API Rest service


*  http://localhost:8082/getauthor

    Above Url access http://localhost:8083/getauthordetails BookStore-API Rest service


*  http://localhost:8082/addbooks

    Above Url access http://localhost:8083/addbookdetails BookStore-API Rest service


Same above URL's we can access through gateway application using below URL's
* http://localhost:8081/bookstore/getbooks
* http://localhost:8081/bookstore/getauthor
* http://localhost:8081/bookstore/addbooks


**Hystrix circuit breaker**

Here I user Hystrix circuit breaker. Fallback method will call to show some information to user when rest service is down.

when we try to access http://localhost:8082/getbooks **or** http://localhost:8081/bookstore/getbooks
internally http://localhost:8083/getbookdetails rest service will call, if the service is down then fallback method will call.

**Payload Request** for http://localhost:8082/addbooks

{
    "bookId": 101,
    "bookName": "Head First Java",
    "bookPrice": 500.0,
    "active": true,
    "authorId": 1011,
    "authorName": "Herbert Schildt",
    "address": "USA"
}

