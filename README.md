# Sales Manager Order Service

Microsservice for order management of the sales-manager architecture

* **URL**\
/order

* **Method:**\
 `POST`
 
 *  **Request Body**
    ```json
    {
      "address": {
        "city": "São Paulo",
        "country": "Brasil",
        "number": 405,
        "recipient": "Rodrigo Lima Martins da Silva",
        "state": "São Paulo",
        "street": "Rua Elias Bedran",
        "zipCode": "08051-480"
      },
      "customerId": "5f82758834671438dfdc7483",
      "productId": "5f82756006d17568b0ab0ed4",
      "productQuantity": 1
    }
    ```
 * **Success Response:**
 
    * **Code:** 200 <br />
        **Content:**
    ```json
    {
      "_id": "5f82785d0ce99e49c0859f0e",
      "customerId": "5f82758834671438dfdc7483",
      "productId": "5f82756006d17568b0ab0ed4",
      "productQuantity": 1,
      "orderTotalValue": 160,
      "orderStatus": "PROCESSING_PAYMENT",
      "address": {
        "recipient": "Rodrigo Lima Martins da Silva",
        "street": "Rua Elias Bedran",
        "number": 405,
        "zipCode": "08051-480",
        "city": "São Paulo",
        "state": "São Paulo",
        "country": "Brasil"
      },
      "creationDate": "2020-10-11T00:13:33.1025255",
      "updateDate": "2020-10-11T00:13:33.1025255",
      "orderId": "5f82785d0ce99e49c0859f0e",
      "orderDescription": "Processando pagamento"
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