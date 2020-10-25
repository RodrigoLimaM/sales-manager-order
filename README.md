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

* **URL**\
/order/{orderId}

* **Method:**\
 `GET`

  *  **Path Variables**

     `orderId={String}`
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

* **URL**\
/order/customer/{customerId}

* **Method:**\
 `GET`

  *  **Path Variables**

     `customerId={String}`
 * **Success Response:**

    * **Code:** 200 <br />
        **Content:**
    ```json
    [
      {
        "_id": "5f8e4ebef6b0d95639d9c2cc",
        "customerId": "5f8e089f9923fc14d04af7e2",
        "productId": "5f8bbfb897e655264db0607d",
        "productQuantity": 1,
        "orderTotalValue": 1000.99,
        "orderStatus": "PREPARING_FOR_SHIPPING",
        "address": {
          "recipient": "Iris Moraes de Jesus",
          "street": "Travessa Ascendino Lisboa",
          "number": 23,
          "zipCode": "80687-981",
          "city": "São Paulo",
          "state": "São Paulo",
          "country": "Brasil"
        },
        "creationDate": "2020-10-19T23:43:09.59",
        "updateDate": "2020-10-19T23:43:55.941",
        "orderId": "5f8e4ebef6b0d95639d9c2cc",
        "orderDescription": "Preparando para envio"
      }
    ]
    ```

* **URL**\
/order

* **Method:**\
 `GET`

 * **Success Response:**

    * **Code:** 200 <br />
        **Content:**
    ```json
    [
      {
        "_id": "5f95a76d7eef7713f0927298",
        "customerId": "5f959a1534263543d88047ba",
        "productId": "5f8e1527af376630120f3030",
        "productQuantity": 1,
        "orderTotalValue": 90.99,
        "orderStatus": "APPROVED",
        "address": {
          "recipient": "Rodrigo Lima Martins da Silva",
          "street": "Rua Elias Bedran",
          "number": 405,
          "zipCode": "08051-480",
          "city": "São Paulo",
          "state": "São Paulo",
          "country": "Brasil"
        },
        "creationDate": "2020-10-25T13:27:25.437",
        "updateDate": "2020-10-25T13:27:48.856",
        "orderId": "5f95a76d7eef7713f0927298",
        "orderDescription": "Pedido aprovado"
      },
      {
        "_id": "5f95a77f7eef7713f0927299",
        "customerId": "5f959a1534263543d88047ba",
        "productId": "5f8e1833af376630120f3031",
        "productQuantity": 1,
        "orderTotalValue": 254.99,
        "orderStatus": "APPROVED",
        "address": {
          "recipient": "Rodrigo Lima Martins da Silva",
          "street": "Rua Elias Bedran",
          "number": 405,
          "zipCode": "08051-480",
          "city": "São Paulo",
          "state": "São Paulo",
          "country": "Brasil"
        },
        "creationDate": "2020-10-25T13:27:43.045",
        "updateDate": "2020-10-25T13:27:51.296",
        "orderId": "5f95a77f7eef7713f0927299",
        "orderDescription": "Pedido aprovado"
      }
    ]
    ```
  
* **Architecture:**
 
    ![Alt text](https://user-images.githubusercontent.com/51386403/95694559-0ef35880-0c09-11eb-9667-9ae838b4d40f.png "Architecture")
    * 1 - Will receive an order and check if stock is available;
    * 2 - If has stock, will create the order and persist on MongoDB with status ***PROCESSING_PAYMENT***;
    * 3 - The persisted order will be produced on ***NEW_ORDER*** Kafka topic;
    * 4 - Will listen to the topic and check if the customer has available balance;
    * 5 - Will produce a message on ***ORDER_STATUS_CHANGE*** Kafka topic updating the order status (***APPROVED*** or ***CANCELLED***);
    * 6 - Will listen to the topic, update the order status to ***PREPARING_FOR_SHIPPING*** (if order was ***APPROVED***)  and produce a message with the changes in the order;
    * 7 - Will listen to the topic and update the order status on MongoDB;
    * 8 - Will update the product stock (if order was ***APPROVED***);
    * 9 - Occasionally will produce messages as the order status changes and persist the changes on MongoDB.