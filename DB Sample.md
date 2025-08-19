SELECT * FROM CAFES 

INSERT INTO cafes (
    id, name, type, address, latitude, longitude,
    date, group_name, internet, number, parking,
    table_info, toilet, created_at, updated_at
) VALUES (
    'CAF1234567890',                     -- id (UUID 등으로 생성 추천)
    '커피에반하다 삼청점',                -- name
    '무인',                              -- type
    '서울 종로구 삼청로4길 18',           -- address
    '37.5823168',                        -- latitude (문자열)
    '126.9820046',                       -- longitude (문자열)
    '2024-01-24',                        -- date
    '4인석',                             -- group_name
    '가능',                              -- internet
    '070-4493-7699',                     -- number
    '',                                  -- parking
    '2 테이블',                          -- table_info
    '',                                  -- toilet
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);

INSERT INTO places (
    id, name, type, address, latitude, longitude,
    additional, group_name, internet, number, parking,
    table_info, toilet, created_at, updated_at
) VALUES (
    '11xAY9RP9nfRMY4JaFVx',       -- id
    'asdasd',                     -- name
    '무인',                       -- type
    '서울 서초구 사임당로19길 6',   -- address
    37.490444,                    -- latitude
    127.0202161,                  -- longitude
    '',                           -- additional
    '',                           -- group_name
    '',                           -- internet
    '',                           -- number
    '',                           -- parking
    '',                           -- table_info
    '',                           -- toilet
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);
