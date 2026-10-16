DROP PROCEDURE IF EXISTS get_absences;

DELIMITER //

CREATE PROCEDURE get_absences(IN p_student_id BIGINT)
BEGIN
    SELECT s.name, a.attendance_date, a.status
    FROM attendance a
    JOIN student s ON a.student_id = s.id
    WHERE a.student_id = p_student_id
        AND a.status = 'ABSENT'
    ORDER BY a.attendance_date;
END //

DELIMITER ;