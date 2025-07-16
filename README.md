# Electricity Billing System
 
 A Java-based billing system that asks for each customer's name, house number, and units of electricity used. Based on  unit slabs (e.g. 10 units = Rs. 100, 20 units = Rs. 250, etc.), the program calculates the total bill for each customer. After processing 3–5 houses, it prints the bill for each total amount and customer name with the house number and identifies the highest paying customer along with their house number.


## Unit slab
| Units Consumed      | Price (Rs.)         | Notes                              |
|---------------------|---------------------|-------------------------------------|
| 1 – 10              | 100                 | Flat rate for first 10 units       |
| 11 – 20             | 250                 | Flat rate for first 20 units       |
| 21 and above        | 250 + Rs. 2/unit    | Rs. 2 for each unit after 20 units |

## Features

- Maintain customer details: {name, house number, electricity units consumed}

- The system should allow input of units consumed

- The bill must be calculated based on unit slabs

- Special handling is required for customers consuming more than 20 units

- Generate and display the electricity bill for each customer using the unit slab system

- Display the customer who paid the highest bill along with their house number and the amount paid
