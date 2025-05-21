CREATE TABLE tb_game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    game_year INT,
    genre VARCHAR(255),
    platforms VARCHAR(255),
    score DOUBLE,
    img_url VARCHAR(255),
    short_description TEXT,
    long_description TEXT
);
