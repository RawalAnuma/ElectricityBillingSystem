# Electricity Billing System
 
 A Java-based billing system that asks for each customer's name, house number, and units of electricity used. Based on  unit slabs (e.g. 10 units = Rs. 100, 20 units = Rs. 250, etc.), the program calculates the total bill for each customer. After processing 3–5 houses, it prints the bill for each total amount and customer name with the house number and identifies the highest paying customer along with their house number.

## Features
- Customer ko detail record {name, house number, kati electricity use garyo}
- Should be able to provide the units consumed
- Unit slabs anusar kaam garnu parxha
- 20 unit vanda mathi ko discuss garnu parni xha
- Bill calculate garnu parni xha for every customer  (unit slab use garera)
- Bill pani dekhaua parni xa
- Highest paying customer with house number [paid amount dekhauda thik hunthyo??]

## Unit slab
| Units Consumed      | Price (Rs.)         | Notes                              |
|---------------------|---------------------|-------------------------------------|
| 1 – 10              | 100                 | Flat rate for first 10 units       |
| 11 – 20             | 250                 | Flat rate for first 20 units       |
| 21 and above        | 250 + Rs. 2/unit    | Rs. 2 for each unit after 20 units |