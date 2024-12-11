INSERT INTO Users (username, is_admin, is_locked, full_name, address, birth_date, gender, email, password)
VALUES 
('john_doe', 0, 0, 'John Doe', '123 Main St, New York, NY', '1985-03-15', 'Male', 'john.doe@example.com', 'hashed_password_1'),
('jane_smith', 1, 0, 'Jane Smith', '456 Elm St, Los Angeles, CA', '1990-06-25', 'Female', 'jane.smith@example.com', 'hashed_password_2'),
('bob_jones', 0, 1, 'Bob Jones', '789 Pine St, Chicago, IL', '1992-08-30', 'Male', 'bob.jones@example.com', 'hashed_password_3'),
('alice_williams', 0, 0, 'Alice Williams', '101 Maple St, Houston, TX', '1988-12-05', 'Female', 'alice.williams@example.com', 'hashed_password_4');


INSERT INTO FriendList (user_id, friend_id, requesting, requested)
VALUES 
(1, 2, 1, 0), 
(2, 3, 1, 0), 
(3, 1, 0, 1),
(4, 2, 1, 0),
(2, 4, 0, 1);

INSERT INTO Blocked (user_id, blocked_user_id)
VALUES 
(1, 2), 
(3, 1), 
(4, 2), 
(2, 3); 

INSERT INTO GroupChat (group_name, initial_member)
VALUES 
('Group Chat A', 1),
('Group Chat B', 2), 
('Group Chat C', 3), 
('Group Chat D', 4); 

INSERT INTO GroupMembers (group_id, user_id, is_admin)
VALUES 
(1, 1, 1), 
(1, 2, 0), 
(2, 3, 1),  
(2, 4, 0), 
(3, 2, 0),  
(3, 4, 0),  
(4, 1, 0), 
(4, 3, 0); 

INSERT INTO Spam (reported_user_id, username, report_time)
VALUES 
(2, 'jane_smith'),
(3, 'bob_jones'), 
(1, 'john_doe'), 
(4, 'alice_williams'); 