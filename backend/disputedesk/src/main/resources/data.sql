INSERT INTO transactions (customer_id, merchant, amount, transaction_date, status)
SELECT customer_id, merchant, amount, transaction_date, status
FROM (VALUES
    ('C001', 'Amazon', 89.99, DATE '2026-11-03', 'COMPLETED'),
    ('C001', 'Amazon', 89.99, DATE '2026-11-03', 'COMPLETED'),
    ('C001', 'Safeway', 64.32, DATE '2026-11-08', 'COMPLETED'),
    ('C001', 'Shell', 48.75, DATE '2026-10-19', 'COMPLETED'),
    ('C001', 'Netflix', 15.49, DATE '2026-10-25', 'COMPLETED'),
    ('C001', 'Delta Airlines', 412.60, DATE '2026-10-12', 'COMPLETED'),
    ('C001', 'Best Buy', 129.99, DATE '2026-11-15', 'PENDING'),
    ('C001', 'Starbucks', 8.45, DATE '2026-11-21', 'COMPLETED'),
    ('C002', 'Apple', 249.00, DATE '2026-10-14', 'COMPLETED'),
    ('C002', 'Walmart', 93.18, DATE '2026-10-28', 'COMPLETED'),
    ('C002', 'Uber', 27.36, DATE '2026-11-05', 'COMPLETED'),
    ('C002', 'Target', 76.24, DATE '2026-11-11', 'COMPLETED'),
    ('C002', 'Electric Utility', 118.42, DATE '2026-11-18', 'PENDING'),
    ('C002', 'Chipotle', 21.65, DATE '2026-10-31', 'COMPLETED'),
    ('C003', 'Home Depot', 184.50, DATE '2026-10-07', 'COMPLETED'),
    ('C003', 'Spotify', 11.99, DATE '2026-10-20', 'COMPLETED'),
    ('C003', 'Whole Foods', 52.73, DATE '2026-11-02', 'COMPLETED'),
    ('C003', 'United Airlines', 356.20, DATE '2026-11-09', 'COMPLETED'),
    ('C003', 'CVS Pharmacy', 34.88, DATE '2026-11-16', 'COMPLETED'),
    ('C003', 'The Ritz-Carlton', 625.00, DATE '2026-10-30', 'PENDING')
) AS sample(customer_id, merchant, amount, transaction_date, status)
WHERE NOT EXISTS (SELECT 1 FROM transactions);
