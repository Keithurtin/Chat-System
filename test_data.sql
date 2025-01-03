USE [ChatSystem]
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (1, N'ad', N'Admin', N'123 Stret ABC', CAST(N'2004-01-01' AS Date), N'Male', N'user1@gmail.com', N'123', N'Online', CAST(N'2024-11-10T16:50:53.510' AS DateTime), 1, 0)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (2, N'user2', N'Anonymous User 2', N'456 Street DEF', CAST(N'2004-02-02' AS Date), N'Female', N'user2@gmail.com', N'password456', N'online', CAST(N'2024-11-10T16:50:53.510' AS DateTime), 0, 0)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (1004, N'user3', N'Anonymous User 3', N'789 Street GHI', CAST(N'2004-03-03' AS Date), N'Male', N'user3@gmail.com', N'password789', N'online', CAST(N'2024-11-26T03:15:02.827' AS DateTime), 0, 0)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (1005, N'user0', N'Anonymous User 0', N'000 Street 000', CAST(N'2000-10-10' AS Date), N'Female', N'user0@gmail.com', N'password000', N'online', CAST(N'2024-11-26T03:48:03.943' AS DateTime), 0, 0)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (1009, N'user100', N'Anonymous User 100', N'100 Street ZZZ', CAST(N'2000-01-01' AS Date), N'Male', N'user100@gmail.com', N'password100', N'online', CAST(N'2024-11-26T19:39:45.683' AS DateTime), 0, 1)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (2010, N'admin', N'Admin', N'123 Street 456', CAST(N'2000-12-01' AS Date), N'Male', N'admin@gmail.com', N'CuguGPP1YflgTbSxCqcM+h/rczvrA+IujSPQnJkINVxmpE8kEenkmOVWokFpHYbY', N'online', CAST(N'2024-12-11T19:03:33.277' AS DateTime), 1, 0)
INSERT [dbo].[Users] ([user_id], [username], [full_name], [address], [birth_date], [gender], [email], [password], [user_status], [create_time], [is_admin], [is_locked]) VALUES (2011, N'userTest', N'User Test', N'123 Test', CAST(N'2004-12-03' AS Date), N'Male', N'test@gmail.com', N'gWD8vOgpG3giubUWeCzGKNc30D0dAXjeK7fIG2T8aEY14/TjoC4fas2CZWffN/6S', N'offline', CAST(N'2024-12-11T19:07:58.510' AS DateTime), 0, 0)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
SET IDENTITY_INSERT [dbo].[ChatDM] ON 

INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (2, 1, 2, N'Hello', CAST(N'2024-12-03T18:04:27.507' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (3, 2, 1, N'Hello', CAST(N'2024-12-03T18:04:33.990' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (4, 1, 2, N'How are you', CAST(N'2024-12-03T18:04:49.020' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (5, 2, 1, N'Im fine', CAST(N'2024-12-03T18:05:15.557' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (6, 2010, 2011, N'hello', CAST(N'2024-12-11T19:22:07.937' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (7, 2011, 2010, N'nice to meet you', CAST(N'2024-12-11T19:22:30.983' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (8, 2010, 2011, N'yo', CAST(N'2024-12-11T19:23:04.760' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (9, 2011, 2010, N'wasup''', CAST(N'2024-12-11T20:13:23.060' AS DateTime))
INSERT [dbo].[ChatDM] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (10, 2010, 2011, N'nothing', CAST(N'2024-12-12T19:45:19.080' AS DateTime))
SET IDENTITY_INSERT [dbo].[ChatDM] OFF
GO
SET IDENTITY_INSERT [dbo].[GroupChat] ON 

INSERT [dbo].[GroupChat] ([group_id], [group_name], [initial_member], [create_time]) VALUES (1, N'Group 1', 1, CAST(N'2024-11-28T20:40:21.610' AS DateTime))
INSERT [dbo].[GroupChat] ([group_id], [group_name], [initial_member], [create_time]) VALUES (2, N'Group user', 1, CAST(N'2024-11-28T20:40:37.420' AS DateTime))
INSERT [dbo].[GroupChat] ([group_id], [group_name], [initial_member], [create_time]) VALUES (3, N'Group foo', 1, CAST(N'2024-11-28T20:40:44.347' AS DateTime))
INSERT [dbo].[GroupChat] ([group_id], [group_name], [initial_member], [create_time]) VALUES (1003, N'test group', 2010, CAST(N'2024-12-11T20:15:06.343' AS DateTime))
SET IDENTITY_INSERT [dbo].[GroupChat] OFF
GO
SET IDENTITY_INSERT [dbo].[ChatGroup] ON 

INSERT [dbo].[ChatGroup] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (1, 1, 1, N'Hello everyone', CAST(N'2024-12-03T18:06:47.923' AS DateTime))
INSERT [dbo].[ChatGroup] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (2, 2, 1, N'Hello', CAST(N'2024-12-03T18:06:58.107' AS DateTime))
INSERT [dbo].[ChatGroup] ([message_id], [sender_id], [receiver_id], [message_content], [send_time]) VALUES (3, 2010, 1003, N'hello everyone', CAST(N'2024-12-11T20:15:17.610' AS DateTime))
SET IDENTITY_INSERT [dbo].[ChatGroup] OFF
GO
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (1, CAST(N'2024-11-27T02:00:42.090' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (1, CAST(N'2024-11-27T02:01:08.430' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2, CAST(N'2024-11-27T02:01:02.630' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-11T20:01:39.333' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-11T20:13:48.437' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T19:42:32.033' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T19:43:00.557' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T19:43:47.450' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T19:44:49.553' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T22:44:29.803' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2010, CAST(N'2024-12-12T22:44:58.080' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2011, CAST(N'2024-12-11T20:13:05.537' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2011, CAST(N'2024-12-11T20:15:27.807' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2011, CAST(N'2024-12-12T19:42:46.617' AS DateTime))
INSERT [dbo].[LoginHistory] ([user_id], [login_time]) VALUES (2011, CAST(N'2024-12-12T19:45:05.450' AS DateTime))
GO
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (1, 2, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (1, 1004, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (1, 2010, 1, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (2, 1, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (2, 1005, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (1004, 1, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (1005, 2, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (2010, 1, 0, 1)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (2010, 2011, 0, 0)
INSERT [dbo].[FriendList] ([user_id], [friend_id], [requesting], [requested]) VALUES (2011, 2010, 0, 0)
GO
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (1, 1, 1)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (1, 2, 0)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (2, 2, 1)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (2, 1004, 0)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (3, 1, 1)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (3, 1005, 0)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (1003, 2010, 0)
INSERT [dbo].[GroupMembers] ([group_id], [user_id], [is_admin]) VALUES (1003, 2011, 0)
GO
INSERT [dbo].[Spam] ([reported_user_id], [report_time], [username]) VALUES (1005, CAST(N'2024-12-01T20:29:10.933' AS DateTime), N'user0')
INSERT [dbo].[Spam] ([reported_user_id], [report_time], [username]) VALUES (1009, CAST(N'2024-12-01T20:28:39.147' AS DateTime), N'user100')
INSERT [dbo].[Spam] ([reported_user_id], [report_time], [username]) VALUES (1009, CAST(N'2024-12-01T20:29:25.350' AS DateTime), N'user100')
GO
