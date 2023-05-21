# Pantry-Mate 🥫🍇 
**Problem Statement.**

Due to the cost of living crisis, there is an increase in demand for food banks, leading to a higher volume of donations. In order to manage these donations efficiently, food banks need to prioritise their inventory, keeping track of quantity and expiration dates. This is where Pantry-Mate comes in - **an app** designed to help food banks manage their donated items effectively. By using Pantry-Mate, food banks can reduce waste, plan for future needs, and ensure they have enough supplies to meet the needs of their community.

<div style="display: flex; gap: 10px;">
<img src="https://i.imgur.com/8owzK2n.png" alt="Beige Pantry-Mate Logo" width="200"/>
<img src="https://i.imgur.com/FczqVyT.png" alt="Green Pantry-Mate Logo" width="200"/>
<img src="https://i.imgur.com/CqsU0Ct.png" alt="Yellow New Pantry-Mate Logo" width="200"/>
<img src="https://i.imgur.com/iqRqZ2V.png" alt="Green New Pantry-Mate Logo" width="200"/>
</div>
<hr>

**Resources**
* https://www.freecodecamp.org/news/comprehensive-guide-for-color-usage-in-web-design-e2a9afce09fb/#:~:text=Purple%3A%20Royalty%2C%20luxury%2C%20creativity,%3A%20Conservative%2C%20modernity%2C%20luxury.
* https://colorhunt.co/palettes/food

<hr>


**Planning** - **ERD Diagram** &
**UML Diagram**<br>
<div style="display: flex; gap: 10px;">
<img src="https://i.imgur.com/620LDLf.png" alt="ERD Diagram" width="400"/>
<img src="https://i.imgur.com/cV1bRpn.png" alt="UML Diagram" width="400"/>
</div>

* Explanation of each will go here.

<br>
<hr>

**MVP & Extensions** <br>

**MVP**
1. Product Management: Enable users to perform CRUD operations on products, allowing them to add, retrieve, update, and delete product information.
2. Inventory Management: Provide endpoints for users to manage inventories, enabling them to track product quantities, add or remove items, and retrieve inventory details.
3. Food Bank Information: Implement endpoints to retrieve essential food bank details, including name, location, and contact information, allowing users to access relevant information about the food bank.
4. Search Functionality: Include a search feature for users to find products in the inventory based on criteria such as name, category, or other relevant attributes. <br>

**Extensions**
1. Implement secure authentication and authorisation using Spring Security to restrict unauthorised access and ensure data integrity for inventory management.
2. Implement alerts and notifications, such as expiration reminders, to notify users when a product in the inventory is approaching its expiration date.
3. Extend the API to enable sorting and filtering of product or inventory data, allowing users to specify sorting criteria (e.g name or quantity) and apply attribute-based filters (e.g category or expiration date).

<hr>

**Technologies used** 💻
* Spring Boot
* Java 17
* PostgreSQL
* Hibernate
* Postman