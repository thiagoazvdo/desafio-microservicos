CREATE TABLE Notification (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              recipient VARCHAR(255) NOT NULL,
                              message TEXT NOT NULL,
                              type ENUM('EMAIL', 'SMS', 'PUSH_NOTIFICATION') NOT NULL
);
