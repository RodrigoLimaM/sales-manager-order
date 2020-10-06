# Sales Manager Order Service

Microsservice for order management of the sales-manager architecture

* **URL**\
/order

* **Method:**\
 `POST`
 
 *  **Request Body**
    ```json
    {
      "customerId": "5f7cdf2f00f37b096056a874",
      "productId": "5f7cdfb273e86e129ea6efa9",
      "productQuantity": 5
    }
    ```
 * **Success Response:**
 
    * **Code:** 200 <br />
        **Content:**
    ```json
    {
      "_id": "5f7ce3a263fd9b52935c4f19",
      "customerId": "5f7cdf2f00f37b096056a874",
      "productId": "5f7cdfb273e86e129ea6efa9",
      "productQuantity": 5,
      "orderTotalValue": 11000,
      "orderStatus": "PENDING",
      "creationDate": "2020-10-06T18:37:38.1778324",
      "updateDate": "2020-10-06T18:37:38.1778324",
      "orderId": "5f7ce3a263fd9b52935c4f19"
    }
    ```
    
* **Error Response:**

    * **Code:** 400 <br />
        **Content:** 
    ```json
    {
      "timestamp": "2020-10-06T18:38:10.1928963",
      "status": 400,
      "message": "Invalid null or blank field"
    }
    ```
  
* **Architecture:**
 
    ![Alt text](https://user-images.githubusercontent.com/51386403/95261158-45436900-0800-11eb-9b10-ec7bfe7cd371.png "Architecture")
    * 1 - Will receive an order and check if stock is avaliable
    * 2 - If has stock, will create the order and persist on MongoDB with status ***PENDING***;
    * 3 - The persisted order will be produced on ***NEW_ORDER*** Kafka topic;
    * 4 - Will listen to the topic and check if the customer has available balance;
    * 5 - Will produce a message on ***ORDER_STATUS_CHANGE*** Kafka topic updating the order status (***FINISHED*** or ***CANCELLED***);
    * 6 - Will listen to the topic and update the order status on MongoDB;
    * 7 - Will update the product stock (if product status is ***FINISHED***).