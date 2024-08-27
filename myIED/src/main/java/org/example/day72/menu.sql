CREATE TABLE Seating (
    TableID INT PRIMARY KEY,
    Seats INT NOT NULL,
    Location VARCHAR(50)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    TableID INT,
    OrderTime DATETIME,
    OrderStatus VARCHAR(20),
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (TableID) REFERENCES Seating(TableID)
);

CREATE TABLE Menu (
    MenuItemID INT PRIMARY KEY,
    ItemName VARCHAR(100),
    Price DECIMAL(10, 2),
    Category VARCHAR(50)
);

CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY,
    OrderID INT,
    MenuItemID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (MenuItemID) REFERENCES Menu(MenuItemID)
);

CREATE TABLE Ingredients (
    IngredientID INT PRIMARY KEY,
    IngredientName VARCHAR(100),
    StockQuantity DECIMAL(10, 2)
);

CREATE TABLE MenuIngredients (
    MenuItemID INT,
    IngredientID INT,
    QuantityRequired DECIMAL(10, 2),
    PRIMARY KEY (MenuItemID, IngredientID),
    FOREIGN KEY (MenuItemID) REFERENCES Menu(MenuItemID),
    FOREIGN KEY (IngredientID) REFERENCES Ingredients(IngredientID)
);

INSERT INTO Seating (TableID, Seats, Location) VALUES (1, 4, 'Near Window');
INSERT INTO Seating (TableID, Seats, Location) VALUES (2, 2, 'By the Bar');
INSERT INTO Seating (TableID, Seats, Location) VALUES (3, 6, 'Center');
INSERT INTO Seating (TableID, Seats, Location) VALUES (4, 4, 'Patio');

INSERT INTO Menu (MenuItemID, ItemName, Price, Category) VALUES (1, 'Margherita Pizza', 12.99, 'Main Course');
INSERT INTO Menu (MenuItemID, ItemName, Price, Category) VALUES (2, 'Caesar Salad', 8.99, 'Appetizer');
INSERT INTO Menu (MenuItemID, ItemName, Price, Category) VALUES (3, 'Spaghetti Bolognese', 14.99, 'Main Course');
INSERT INTO Menu (MenuItemID, ItemName, Price, Category) VALUES (4, 'Tiramisu', 6.99, 'Dessert');

INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (1, 'Tomato', 100.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (2, 'Mozzarella Cheese', 50.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (3, 'Basil', 30.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (4, 'Romaine Lettuce', 40.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (5, 'Pasta', 60.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (6, 'Beef', 20.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (7, 'Mascarpone Cheese', 25.00);
INSERT INTO Ingredients (IngredientID, IngredientName, StockQuantity) VALUES (8, 'Coffee', 10.00);

INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (1, 1, 2.00); -- Margherita Pizza uses Tomato
INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (1, 2, 1.50); -- Margherita Pizza uses Mozzarella Cheese
INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (1, 3, 0.10); -- Margherita Pizza uses Basil

INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (2, 4, 1.00); -- Caesar Salad uses Romaine Lettuce

INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (3, 5, 1.50); -- Spaghetti Bolognese uses Pasta
INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (3, 6, 0.75); -- Spaghetti Bolognese uses Beef

INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (4, 7, 0.50); -- Tiramisu uses Mascarpone Cheese
INSERT INTO MenuIngredients (MenuItemID, IngredientID, QuantityRequired) VALUES (4, 8, 0.10); -- Tiramisu uses Coffee

INSERT INTO Orders (OrderID, TableID, OrderTime, OrderStatus, TotalAmount) VALUES (1, 1, '2024-08-26 12:30:00', 'waiting', 26.97);
INSERT INTO Orders (OrderID, TableID, OrderTime, OrderStatus, TotalAmount) VALUES (2, 2, '2024-08-26 12:45:00', 'prepping', 14.99);
INSERT INTO Orders (OrderID, TableID, OrderTime, OrderStatus, TotalAmount) VALUES (3, 3, '2024-08-26 13:00:00', 'completed', 21.98);

INSERT INTO OrderDetails (OrderDetailID, OrderID, MenuItemID, Quantity) VALUES (1, 1, 1, 2); -- 2 Margherita Pizzas
INSERT INTO OrderDetails (OrderDetailID, OrderID, MenuItemID, Quantity) VALUES (2, 1, 2, 1); -- 1 Caesar Salad

INSERT INTO OrderDetails (OrderDetailID, OrderID, MenuItemID, Quantity) VALUES (3, 2, 3, 1); -- 1 Spaghetti Bolognese

INSERT INTO OrderDetails (OrderDetailID, OrderID, MenuItemID, Quantity) VALUES (4, 3, 3, 1); -- 1 Spaghetti Bolognese
INSERT INTO OrderDetails (OrderDetailID, OrderID, MenuItemID, Quantity) VALUES (5, 3, 4, 2); -- 2 Tiramisu


CREATE TRIGGER SubtractStockOnPrepping
AFTER UPDATE OF OrderStatus ON Orders
FOR EACH ROW
WHEN NEW.OrderStatus = 'prepping' AND OLD.OrderStatus != 'prepping'
BEGIN
    UPDATE Ingredients
    SET StockQuantity = StockQuantity - (
        SELECT SUM(mi.QuantityRequired * od.Quantity)
        FROM OrderDetails od
        JOIN MenuIngredients mi ON od.MenuItemID = mi.MenuItemID
        WHERE od.OrderID = NEW.OrderID
    )
    WHERE IngredientID IN (
        SELECT mi.IngredientID
        FROM OrderDetails od
        JOIN MenuIngredients mi ON od.MenuItemID = mi.MenuItemID
        WHERE od.OrderID = NEW.OrderID
    );
END;


CREATE TRIGGER AddStockOnCanceled
AFTER UPDATE OF OrderStatus ON Orders
FOR EACH ROW
WHEN NEW.OrderStatus = 'canceled' AND OLD.OrderStatus != 'canceled'
BEGIN
    UPDATE Ingredients
    SET StockQuantity = StockQuantity + (
        SELECT SUM(mi.QuantityRequired * od.Quantity)
        FROM OrderDetails od
        JOIN MenuIngredients mi ON od.MenuItemID = mi.MenuItemID
        WHERE od.OrderID = NEW.OrderID
    )
    WHERE IngredientID IN (
        SELECT mi.IngredientID
        FROM OrderDetails od
        JOIN MenuIngredients mi ON od.MenuItemID = mi.MenuItemID
        WHERE od.OrderID = NEW.OrderID
    );
END;

SELECT
    TableID,
    OrderID,
    OrderTime,
    ROW_NUMBER() OVER (PARTITION BY TableID ORDER BY OrderTime) AS RowNum
FROM
    Orders;


SELECT
    TableID,
    OrderID,
    TotalAmount,
    RANK() OVER (PARTITION BY TableID ORDER BY TotalAmount DESC) AS Rank
FROM
    Orders;


SELECT
    TableID,
    OrderID,
    TotalAmount,
    DENSE_RANK() OVER (PARTITION BY TableID ORDER BY TotalAmount DESC) AS DenseRank
FROM
    Orders;

SELECT
    OrderID,
    TotalAmount,
    NTILE(4) OVER (ORDER BY TotalAmount DESC) AS Quartile
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    TotalAmount,
    LAG(TotalAmount, 1) OVER (PARTITION BY TableID ORDER BY OrderTime) AS PrevOrderAmount
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    TotalAmount,
    LEAD(TotalAmount, 1) OVER (PARTITION BY TableID ORDER BY OrderTime) AS NextOrderAmount
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    OrderTime,
    FIRST_VALUE(OrderTime) OVER (PARTITION BY TableID ORDER BY OrderTime) AS FirstOrderTime
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    OrderTime,
    LAST_VALUE(OrderTime) OVER (PARTITION BY TableID ORDER BY OrderTime ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS LastOrderTime
FROM
    Orders;
	
SELECT
    TableID,
    OrderID,
    TotalAmount,
    SUM(TotalAmount) OVER (PARTITION BY TableID ORDER BY OrderTime) AS CumulativeTotal
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    TotalAmount,
    AVG(TotalAmount) OVER (PARTITION BY TableID ORDER BY OrderTime) AS RunningAvg
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    COUNT(OrderID) OVER (PARTITION BY TableID ORDER BY OrderTime) AS OrderCount
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    TotalAmount,
    MAX(TotalAmount) OVER (PARTITION BY TableID ORDER BY OrderTime) AS MaxOrderAmount
FROM
    Orders;

SELECT
    TableID,
    OrderID,
    TotalAmount,
    MIN(TotalAmount) OVER (PARTITION BY TableID ORDER BY OrderTime) AS MinOrderAmount
FROM
    Orders;


SELECT SUM(TotalAmount) AS TotalRevenue
FROM Orders;


SELECT AVG(TotalAmount) AS AverageOrderAmount
FROM Orders;

SELECT COUNT(OrderID) AS TotalOrders
FROM Orders;

SELECT MAX(TotalAmount) AS HighestOrderAmount
FROM Orders;

SELECT MIN(TotalAmount) AS LowestOrderAmount
FROM Orders;

SELECT GROUP_CONCAT(ItemName, ', ') AS MenuItems
FROM Menu;

SELECT COUNT(DISTINCT TableID) AS NumberOfTables
FROM Orders;

-- (Note: SQLite doesn't support VARIANCE(), but other SQL databases like MySQL do)
SELECT VARIANCE(TotalAmount) AS OrderAmountVariance
FROM Orders;

SELECT VARIANCE(TotalAmount) AS OrderAmountVariance
FROM Orders;

SELECT 
    FIRST(TotalAmount) AS FirstOrderAmount,
    LAST(TotalAmount) AS LastOrderAmount
FROM Orders;


-- how to do mode
SELECT MenuItemID, COUNT(*) AS Frequency
FROM OrderDetails
GROUP BY MenuItemID
ORDER BY Frequency DESC
LIMIT 1;
-- how to do median
SELECT TotalAmount
FROM Orders
ORDER BY TotalAmount
LIMIT 1 OFFSET (SELECT COUNT(*) FROM Orders) / 2;

SELECT TableID, SUM(TotalAmount) AS TotalRevenue
FROM Orders
GROUP BY TableID;

SELECT Category, AVG(Price) AS AveragePrice
FROM Menu
GROUP BY Category;

