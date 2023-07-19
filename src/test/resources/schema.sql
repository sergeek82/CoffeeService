CREATE TABLE IF NOT EXISTS store
(
    arabica      TINYINT      NULL,
    gross_weight INT          NULL,
    robusta      TINYINT      NULL,
    id           BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    country_code VARCHAR(255) NULL,
    type         VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS cook_brigade
(
    net_weight   INT          NULL,
    id           BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    store_id     BIGINT       NULL,
    brigade_name VARCHAR(255) NULL,
    CONSTRAINT UK_h72py8o4ttbmfs700sgnxlewo
        UNIQUE (store_id),
    CONSTRAINT FKruljykcmyrw9loi630ei5wmga
        FOREIGN KEY (store_id) REFERENCES store (id)
);