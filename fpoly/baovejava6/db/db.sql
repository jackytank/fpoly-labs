USE [baove]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 8/17/2022 4:50:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_roles] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 8/17/2022 4:50:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [nvarchar](100) NOT NULL,
	[password] [nvarchar](100) NULL,
	[fullname] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[admin] [bit] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_role]    Script Date: 8/17/2022 4:50:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [nvarchar](100) NULL,
	[role_id] [nvarchar](50) NULL,
 CONSTRAINT [PK_users_role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (N'ADMIN', N'Admins')
INSERT [dbo].[roles] ([id], [name]) VALUES (N'CUST', N'Customers')
INSERT [dbo].[roles] ([id], [name]) VALUES (N'USER', N'Users')
INSERT [dbo].[users] ([id], [password], [fullname], [email], [admin]) VALUES (N'batman1', N'$2a$10$tDsKau0qy2Y8/9uEU0Dqo.w91lCdzrKwg41cSsQ1i0aGc82oNtrFm', N'Bruce Wayne 1', N'batman1@gmail.com', 1)
INSERT [dbo].[users] ([id], [password], [fullname], [email], [admin]) VALUES (N'batman2', N'$2a$10$tDsKau0qy2Y8/9uEU0Dqo.w91lCdzrKwg41cSsQ1i0aGc82oNtrFm', N'Bruce Wayne 2', N'batman2@gmail.com', 1)
SET IDENTITY_INSERT [dbo].[users_role] ON 

INSERT [dbo].[users_role] ([id], [user_id], [role_id]) VALUES (7, N'batman1', N'ADMIN')
INSERT [dbo].[users_role] ([id], [user_id], [role_id]) VALUES (8, N'batman1', N'USER')
INSERT [dbo].[users_role] ([id], [user_id], [role_id]) VALUES (9, N'batman2', N'CUST')
SET IDENTITY_INSERT [dbo].[users_role] OFF
ALTER TABLE [dbo].[users_role]  WITH CHECK ADD  CONSTRAINT [FK_1] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[users_role] CHECK CONSTRAINT [FK_1]
GO
ALTER TABLE [dbo].[users_role]  WITH CHECK ADD  CONSTRAINT [FK_2] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[users_role] CHECK CONSTRAINT [FK_2]
GO
