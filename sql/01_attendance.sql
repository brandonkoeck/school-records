CREATE TABLE attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id),
    UNIQUE (student_id, attendance_date)
);

INSERT INTO attendance (student_id, attendance_date, status) VALUES
    (1, '2026-10-01', 'ABSENT'),
    (2, '2026-10-01', 'PRESENT'),
    (3, '2026-10-01', 'TARDY'),
    (4, '2026-10-01', 'PRESENT'),
    (5, '2026-10-01', 'PRESENT'),

    (1, '2026-10-02', 'PRESENT'),
    (2, '2026-10-02', 'ABSENT'),
    (3, '2026-10-02', 'PRESENT'),
    (4, '2026-10-02', 'TARDY'),
    (5, '2026-10-02', 'ABSENT'),

    (1, '2026-10-05', 'ABSENT'),
    (2, '2026-10-05', 'TARDY'),
    (3, '2026-10-05', 'PRESENT'),
    (4, '2026-10-05', 'ABSENT'),
    (5, '2026-10-05', 'PRESENT'),

    (1, '2026-10-06', 'ABSENT'),
    (2, '2026-10-06', 'PRESENT'),
    (3, '2026-10-06', 'TARDY'),
    (4, '2026-10-06', 'PRESENT'),
    (5, '2026-10-06', 'PRESENT');
