# Cafe24_Server
Cafe24_Server

---------------------------

CREATE TABLE users ( id BIGINT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) NOT NULL UNIQUE, email VARCHAR(100) NOT NULL UNIQUE, password_hash VARCHAR(255) NOT NULL, failed_attempts INT DEFAULT 0, is_locked BOOLEAN DEFAULT FALSE, last_login_at TIMESTAMP, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP );

1. 기본 정보 사용자 고유 ID (PK, Auto Increment) 아이디(username, unique) 이메일(email, unique) 비밀번호(password → 절대 평문 저장 ❌, 해시 후 저장 ✅) 

2. 보안 관련 필드 password_salt : 해시 강화용 (선택 사항, bcrypt/argon2 같은 함수 쓰면 불필요) failed_attempts : 로그인 실패 횟수 → 계정 잠금 기능에 필요 is_locked : 계정 잠김 여부 last_login_at : 마지막 로그인 시간 → 이상 행동 탐지 가능 created_at / updated_at : 계정 생성 및 수정 시각

---------------------------

CREATE TABLE places (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    additional VARCHAR(255),
    group_name VARCHAR(100),
    internet VARCHAR(50),
    number VARCHAR(50),
    parking VARCHAR(50),
    table_info VARCHAR(50),
    toilet VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE places (
    id VARCHAR(50) PRIMARY KEY,     -- 고유 ID (문자열)
    name VARCHAR(100) NOT NULL,     -- 이름
    type VARCHAR(50) NOT NULL,      -- 유형 (예: 무인, 유인 등)
    address VARCHAR(255),           -- 주소
    latitude DOUBLE NOT NULL,       -- 위도
    longitude DOUBLE NOT NULL,      -- 경도
    additional VARCHAR(255),        -- 추가 정보
    group_name VARCHAR(100),        -- 그룹명
    internet VARCHAR(50),           -- 인터넷 여부
    number VARCHAR(50),             -- 전화번호
    parking VARCHAR(50),            -- 주차장 여부
    table_info VARCHAR(50),         -- 테이블 유무
    toilet VARCHAR(50),             -- 화장실 여부
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 수정일
);


---------------------------

CREATE TABLE cafes (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    latitude VARCHAR(50),
    longitude VARCHAR(50),
    date VARCHAR(20),
    group_name VARCHAR(100),
    internet VARCHAR(50),
    number VARCHAR(50),
    parking VARCHAR(50),
    table_info VARCHAR(50),
    toilet VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE cafes (
    id VARCHAR(50) PRIMARY KEY,        -- 고유 ID (직접 생성 or UUID)
    name VARCHAR(100) NOT NULL,        -- 가게 이름
    type VARCHAR(50) NOT NULL,         -- "무인" 등
    address VARCHAR(255),              -- 주소
    latitude VARCHAR(50),              -- 위도 (문자열로 저장)
    longitude VARCHAR(50),             -- 경도 (문자열로 저장)
    date VARCHAR(20),                  -- 날짜 문자열 (예: "2024-01-24")
    group_name VARCHAR(100),           -- 그룹 (예: "4인석")
    internet VARCHAR(50),              -- 인터넷 가능 여부
    number VARCHAR(50),                -- 전화번호
    parking VARCHAR(50),               -- 주차 가능 여부
    table_info VARCHAR(50),            -- 테이블 정보
    toilet VARCHAR(50),                -- 화장실 여부
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
