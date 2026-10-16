DROP FUNCTION IF EXISTS attendance_pct;

DELIMITER //

CREATE FUNCTION attendance_pct(p_student_id BIGINT)
RETURNS DECIMAL(5,2)
READS SQL DATA
BEGIN
    DECLARE v_total INT;
    DECLARE v_present INT;

    SELECT COUNT(*) INTO v_total
    FROM attendance
    WHERE student_id = p_student_id;

    SELECT COUNT(*) INTO v_present
    FROM attendance
    WHERE student_id = p_student_id
        AND status IN ('PRESENT', 'TARDY');

    IF v_total = 0 THEN
        RETURN NULL;
    END IF;

    RETURN v_present * 100.0 / v_total;

END //

DELIMITER ;