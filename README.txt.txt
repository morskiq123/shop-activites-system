This repo contains my first Java program - a coursework for OOP programming. Below is the configuration for the program.

TASK

You are to develop a system in Java for a Computer Accessories Shop (CAS) to help the business to handle many of the shop’s activities in an easy and practical manner.

Each product the shop stocks has a barcode (a unique 6 digit number), brand, colour, connectivity (either wired or wireless), quantityin stock, original cost and retail price.  The shop sells two types of product:  mouses and keyboards. 

The different types of keyboard that they sell are standard, internet, gaming and flexible. The keyboardshave the US layout or the UK layout. 

The different types of mouse that they sell are standard andgaming. The mouses may have different number of buttons.The users of the system will need to have unique user ID, unique username, surname, address (con-sisting of house number, postcode and city). 

A user can be an admin of the system or a customer. Theadmin user has the right to add a product to the system and view all products with all their attributes. 

A customer in addition to the above users’ attributes will need to have a shopping basket.  Customersshould be able to add items to their shopping basket and pay for all items in the basket (by choosing apayment method which can be either PayPal or Credit Card). 

The Credit Card payments consist of a 16 digits card number and 3 digits security code, and for PayPal payments, an email address is required.Furthermore, customers need to be able to cancel all items in the shopping basket and mark all as save for later. 

A customer should be also able to view all product attributes except original cost.

FUNCTIONS MISSING / NOT WORKING: 

MISSING:
– Search ... Displays a list of all available products to purchase on the screen can be filtered
by → Filter class
    ∗ your chosen brand, and/or
    ∗ keyboards with UK layout

NOT WORKING PROPERLY:
  • Products with a same barcode must not be added more than once. → buggy filtration for shopping
basket