# How to run
To start the service simply use the command

> java -jar target/echo-0.0.1-SNAPSHOT.jar

# Configure Port
To change which port this service is run on, just change the port number in the application.properties file

> server.port=3000


# Item Mocked Data
This proof of concept uses mocked Item data. Whenever you start up the service it will generate a random list of items for you to play around with.
The mocked data has all of the CRUD functions necessary for testing purposes. All items will be persisted in memory
in an object called mockData.

# All endpoints are on the /items/ resource
## items/retrieve
Sending a GET request to this endpoint will return a list of all items in JSON

## items/retrieve/{id}
Sending a GET request to this endpoint will return a single Item at id in JSON

## items/update/{id}
Sending a PUT request with a JSON body that represents an item will update the item with {id} with the updated name
> example of JSON:
```
{
    "id": 123,
    "name" : "bob" 
 }
```
## items/add
Sending a POST request with a JSON body that represents an item will add that item to the list. If an item in the list
already exists with that id, it will be updated instead.

> example of JSON:
```
{
    "id": 169,
    "name" : "george" 
 }
```

## items/addall
Sending a POST request with a JSON body that represents a list of items will add all items to the list. If any of the 
items have an id that already exists in the list, it will be updated instead.

> example of JSON:
```
[
    {
        "id": 169,
        "name" : "logs" 
    },
    {
        "id": 421,
        "name" : "bricks" 
    },
    {
        "id": 32,
        "name" : "hay" 
    }
]
```


## items/delete/{id}
Sending a DELETE request to this endpoint will delete the item from the list with the given id.

## items/deleteall
Sending a DELETE request to this endpoint will delete all items from the list.



#FUTURE UPDATES/CHANGES
I would of course add more error handling. I would like to change all methods to return ResponseEntities instead, and have
error handling specific to HTTP status codes. I would add unit tests using Mockito if it got more difficult to debug, 
but currently it is easier to test with POSTMAN. If this were a real application I would replace my mockData data structure
with something like a Redis database. 

I know I made some assumptions about how some parts of the application would function, namely if you are trying to add
an item whose id already exists in the data. Not sure if you would update or return an error, but either would be
easy to implement. 

Also, I'm very sorry I somehow missed the part where you wanted multiple commits to see my thought process.
I didn't even make the repo until after I was finished. I can go over any questions you have regarding my thought process.