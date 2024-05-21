-- v(2024.05.21)
SELECT cart_id from CART_PRODUCTS
where name = 'Yogurt' and cart_id in (select cart_id  from cart_products where name='Milk');