CREATE TABLE IF NOT EXISTS audit_log (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_name  VARCHAR(50)  NOT NULL,
    record_id   BIGINT       NOT NULL,
    action      VARCHAR(10)  NOT NULL,
    details     VARCHAR(255),
    created_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

DROP TRIGGER IF EXISTS after_attendance_insert;

DELIMITER //

CREATE TRIGGER after_attendance_insert
AFTER INSERT ON attendance
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (table_name, record_id, action, details)
    VALUES (
            'attendance',
            NEW.id,
            'INSERT',
            CONCAT('Student ', NEW.student_id, ' marked ', NEW.status, ' on ', NEW.attendance_date)
           );
END //

DELIMITER ;