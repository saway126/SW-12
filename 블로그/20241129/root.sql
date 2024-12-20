# 기본 SELECT 문법
# SELECT 속성, 속성, 속성 FROM 테이블이름;
SELECT * FROM customers;
SELECT * FROM customers;
SELECT customerNumber, customerName, country FROM customers;

# 특정 조건에 맞는 데이터를 조회
# SELECT 속성, 속성, 속성 FROM 테이블이름 WHERE 조건;
# 글자를 비교할 때는 글자를 무조건 ''로 묶어준다.
# 숫자는 그냥 작성
SELECT customerNumber, country FROM customers 
	WHERE country='USA';

# = 같은지 비교, > 큰지 비교, < 작은지 비교, <=, >=, NOT 다른지 비교
SELECT customerNumber, country FROM customers 
	WHERE NOT country='USA';

SELECT customerNumber, creditLimit FROM customers 
	WHERE creditLimit >= 10000;


# AND		OR			XOR 		참 : 1, 거짓 : 0
#0 0  0		0 0  0		0 0  0
#0 1  0		0 1  1		0 1  1
#1 0  0		1 0  1		1 0  1
#1 1  1		1 1  1		1 1  0
# 조건 여러개 같이 사용할 때
# country가 USA 이고 creditLimit이 100000보다 큰 customers의 
# customerNumber, country, creditLimit를 조회
SELECT customerNumber, country, creditLimit  FROM customers 
	WHERE country='USA' AND creditLimit>100000;

# country가 USA 이거나 creditLimit이 100000보다 큰 customers의 
# customerNumber, country, creditLimit를 조회
SELECT customerNumber, country, creditLimit  FROM customers 
	WHERE country='USA' OR creditLimit>100000;
    
# 글자 중에 일부를 포함한 경우 조회
SELECT customerNumber,country FROM customers 
	WHERE country LIKE '%a%';
    
# 정렬, ASC 오름차순, DESC 내림차순
SELECT customerNumber,country FROM customers 
	ORDER BY country ASC;

# 특정 수만큼만 조회
# LIMIT 데이터의 수 OFFSET 몇번째부터
# LIMIT 몇번째부터, 데이터의 수
SELECT customerNumber,country FROM customers 
	LIMIT 3;
    
SELECT customerNumber,country FROM customers 
	LIMIT 3 OFFSET 0;
    
SELECT customerNumber,country FROM customers 
	LIMIT 0, 3;
    
SELECT customerNumber,country FROM customers;

    SELECT * FROM customers;
# JOIN
SELECT * FROM customers
INNER JOIN orders ON customers.customerNumber = orders.customerNumber;

# 회원 테이블과 주문 테이블에서 주문 상태가 Disputed인 
# 회원의 회원 번호와 이름과 주문 번호, 주문 상태를 조회
SELECT customers.customerNumber, customerName, orderNumber, status 
FROM customers
INNER JOIN orders ON customers.customerNumber = orders.customerNumber
WHERE status='Disputed';
    
    
# 
SELECT customers.customerNumber, customerName, orderNumber, status 
FROM customers
LEFT JOIN orders ON customers.customerNumber = orders.customerNumber
WHERE status='Disputed';    
    
    
    
# London에서 주문한 고객들의 주문 번호와 고객 이름 조회
SELECT orderNumber, customerName FROM orders
INNER JOIN customers
ON orders.customerNumber = customers.customerNumber
WHERE city='London';


# 주문한 제품의 수량이 35개 이상인 주문의 주문 번호와 고객 이름
SELECT orders.orderNumber, customerName FROM orders
INNER JOIN customers
ON orders.customerNumber = customers.customerNumber
INNER JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
WHERE quantityOrdered >= 35;



# territory가 APAC에서 근무하는 직원이 담당하는 고객 이름과 고객 번호 조회
SELECT customerName, customerNumber FROM employees
INNER JOIN customers
ON employees.employeeNumber = customers.salesRepEmployeeNumber
INNER JOIN offices
ON offices.officeCode = employees.officeCode
WHERE territory = 'APAC';

# 주문 상태가 Shipped인 주문에 포함된 제품의 이름과 주문한 고객의 이름 조회
SELECT productName, customerName FROM customers
INNER JOIN orders
ON customers.customerNumber = orders.customerNumber
INNER JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
INNER JOIN products
ON orderdetails.productCode = products.productCode
WHERE status='Shipped';


# 내장 함수
# 집계 함수
SELECT SUM(quantityOrdered) FROM orderdetails;
SELECT COUNT(orderNumber) FROM orders;

# 모든 고객의 수
SELECT COUNT(customerNumber) FROM customers;
# 도시 별 고객의 수
SELECT city, COUNT(customerNumber) FROM customers GROUP BY city;

# 중복 제거 DISTINCT


# 도시별로 주문한 고객들의 수와 도시 이름 
SELECT customers.city, COUNT(DISTINCT customers.customerNumber) FROM customers
INNER JOIN orders
ON orders.customerNumber = customers.customerNumber
GROUP BY customers.city;


# 주문한 제품별 제품의 이름과 고객의 수
SELECT products.productName, COUNT(DISTINCT customers.customerNumber) FROM orders
INNER JOIN customers
ON orders.customerNumber = customers.customerNumber
INNER JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
INNER JOIN products
ON orderdetails.productCode = products.productCode
GROUP BY products.productCode;


# territory별 근무하는 직원이 담당하는 고객의 수
SELECT COUNT(customers.customerNumber) FROM employees
INNER JOIN customers
ON employees.employeeNumber = customers.salesRepEmployeeNumber
INNER JOIN offices
ON offices.officeCode = employees.officeCode
GROUP BY offices.territory;
#HAVING COUNT(customers.customerNumber)>30;
#집계함수로 뽑은 결과에 조건을 비교하고 싶을 때는 HAVING 사용