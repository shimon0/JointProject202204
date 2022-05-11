/* ユーザー マスタ */
CREATE TABLE IF NOT EXISTS users
    (user_id VARCHAR(50) PRIMARY KEY,user_name VARCHAR(50) NOT null,email VARCHAR(100) NOT null,password VARCHAR(100),
     joining_date DATE NOT null,age INT ,gender INT,engineer_kinds VARCHAR(20),experience VARCHAR(20),introduction VARCHAR(250)
    );
