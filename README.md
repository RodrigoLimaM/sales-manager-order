# Sales Manager Order Service

Microsservice for order management of the sales-manager architecture

* **URL**\
/order

* **Method:**\
 `POST`
 
 *  **Request Body**
    ```json
    {
       "customerId": "string",
       "productName": "string",
       "value": 500.0
     }
    ```
 * **Success Response:**
 
     * **Code:** 201 <br />
         **Content:**
     ```json
     {
           "_id": "5f677945d9e3f749d4f42f97",
           "customerId": "string",
           "productName": "string",
           "value": 500,
           "orderStatus": "PENDING",
           "creationDate": "2020-09-20T12:46:13.0672456",
           "updateDate": "2020-09-20T12:46:13.0672456",
           "orderId": "5f677945d9e3f749d4f42f97"
         }
     ```
    
* **Error Response:**

    * **Code:** 400 <br />
        **Content:** 
    ```json
    {
       "timestamp": "2020-09-20T12:42:35.305623",
       "status": 400,
       "message": "Invalid null or blank field"
    }
    ```
  
 * **Architecture:**
 
    ![Alt text](https://user-images.githubusercontent.com/51386403/93714108-e232b080-fb36-11ea-9881-894dd0f900a2.png "Architecture")
    * 1 - Will receive an order, create it and persist on MongoDB with status ***PENDING***;
    * 2 - The persisted order will be produced on ***NEW_ORDER*** Kafka topic;
    * 3 - Will listen to the topic and check if the customer has a balance;
    * 4 - Will produce a message on ***ORDER_STATUS_CHANGE*** Kafka topic updating the order status (***FINISHED*** or ***CANCELLED***);
    * 5 - Will listen to the topic and update the order status on MongoDB.
    
    
    