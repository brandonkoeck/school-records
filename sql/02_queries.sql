SELECT s.name, COUNT(*) AS absences
FROM attendance a
JOIN student s ON a.student_id = s.id
WHERE a.status = 'ABSENT'
GROUP BY s.id, s.name
HAVING COUNT(*) > 2
ORDER BY absences DESC;