CREATE DATABASE ChatSystem;
GO

USE ChatSystem;
GO

CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1, 1),
    username NVARCHAR(50) NOT NULL,
	is_admin BIT DEFAULT 0,
	is_locked BIT DEFAULT 0,
    full_name NVARCHAR(100) NOT NULL,
    address NVARCHAR(100),
    birth_date DATE,
    gender NVARCHAR(6),
    email NVARCHAR(100) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL,
    user_status NVARCHAR(10) DEFAULT 'online',
    create_time DATETIME DEFAULT GETDATE()
);

CREATE TABLE LoginHistory (
    user_id INT,
    login_time DATETIME DEFAULT GETDATE(),
	PRIMARY KEY (user_id, login_time),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE FriendList (
    user_id INT,
    friend_id INT,
	requesting BIT DEFAULT 0,	 --User gửi yêu cầu kết bạn
	requested BIT DEFAULT 0,	 --User nhận được yêu cầu kết bạn
	PRIMARY KEY (user_id, friend_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (friend_id) REFERENCES Users(user_id)
);

CREATE TABLE Blocked (
	user_id INT,
	blocked_user_id INT,
	PRIMARY KEY (user_id, blocked_user_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id),
	FOREIGN KEY (blocked_user_id) REFERENCES Users(user_id),
)

CREATE TABLE GroupChat (
    group_id INT PRIMARY KEY IDENTITY(1, 1),
    group_name NVARCHAR(100) NOT NULL,
	initial_member INT,
    create_time DATETIME DEFAULT GETDATE(),
	FOREIGN KEY (initial_member) REFERENCES Users(user_id)
);

CREATE TABLE GroupMembers (
    group_id INT,
    user_id INT,
    is_admin BIT DEFAULT 0,
	PRIMARY KEY (group_id, user_id),
    FOREIGN KEY (group_id) REFERENCES GroupChat(group_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Bảng tin nhắn (Messages)
CREATE TABLE ChatDM (
    message_id INT IDENTITY(1, 1),
    sender_id INT,
    receiver_id INT,
    message_content NVARCHAR(MAX),
    send_time DATETIME DEFAULT GETDATE(),
	PRIMARY KEY (message_id, sender_id, receiver_id),
    FOREIGN KEY (sender_id) REFERENCES Users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES Users(user_id)
);

CREATE TABLE ChatGroup (
    message_id INT IDENTITY(1, 1),
    sender_id INT,
    receiver_id INT, --group_id
    message_content NVARCHAR(MAX),
    send_time DATETIME DEFAULT GETDATE(),
	PRIMARY KEY (message_id, sender_id, receiver_id),
    FOREIGN KEY (sender_id) REFERENCES Users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES GroupChat(group_id)
);

CREATE TABLE Spam (
    reported_user_id INT,
	username NVARCHAR(50) NOT NULL,
    report_time DATETIME DEFAULT GETDATE(),
	PRIMARY KEY (reported_user_id, report_time),
    FOREIGN KEY (reported_user_id) REFERENCES Users(user_id)
);
