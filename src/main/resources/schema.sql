create DATABASE irrigation_system;
USE [irrigation_system]
GO
/****** Object:  Table [dbo].[crop]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[crop](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[crop_name] [varchar](255) NULL,
	[water_amount_per_meter] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_g13g1v396w8kc2m0erf5grgfo] UNIQUE NONCLUSTERED 
(
	[crop_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[irrigation_slot]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[irrigation_slot](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[begin_watering_date] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[land]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[land](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[land_name] [varchar](255) NULL,
	[location] [varchar](255) NULL,
	[owner_name] [varchar](255) NULL,
	[total_area] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[land_plots]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[land_plots](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[length] [int] NOT NULL,
	[soil_temp] [int] NULL,
	[watering_ind] [varchar](255) NULL,
	[width] [int] NOT NULL,
	[crop_id] [int] NULL,
	[land_id] [int] NULL,
	[pipe_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_nu9vubhilrlxmhvgicnc1lgg0] UNIQUE NONCLUSTERED 
(
	[pipe_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[plot_irrigation_slots]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[plot_irrigation_slots](
	[plot_id] [int] NOT NULL,
	[slot_id] [int] NOT NULL,
	[end_watering_date] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[plot_id] ASC,
	[slot_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[water_pipe]    Script Date: 10/4/2022 5:13:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[water_pipe](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[water_capacity_per_min] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[land_plots]  WITH CHECK ADD  CONSTRAINT [FK1v7ilmbhjrdf6nwyvky1f997e] FOREIGN KEY([land_id])
REFERENCES [dbo].[land] ([id])
GO
ALTER TABLE [dbo].[land_plots] CHECK CONSTRAINT [FK1v7ilmbhjrdf6nwyvky1f997e]
GO
ALTER TABLE [dbo].[land_plots]  WITH CHECK ADD  CONSTRAINT [FK9i31btdwj2ucspu0kqkk2ujh5] FOREIGN KEY([pipe_id])
REFERENCES [dbo].[water_pipe] ([id])
GO
ALTER TABLE [dbo].[land_plots] CHECK CONSTRAINT [FK9i31btdwj2ucspu0kqkk2ujh5]
GO
ALTER TABLE [dbo].[land_plots]  WITH CHECK ADD  CONSTRAINT [FKr3w2mbp039t9gyn77tirxjkw0] FOREIGN KEY([crop_id])
REFERENCES [dbo].[crop] ([id])
GO
ALTER TABLE [dbo].[land_plots] CHECK CONSTRAINT [FKr3w2mbp039t9gyn77tirxjkw0]
GO
ALTER TABLE [dbo].[plot_irrigation_slots]  WITH CHECK ADD  CONSTRAINT [FK9mjpdcc2uggp9hhueunjg2mlc] FOREIGN KEY([slot_id])
REFERENCES [dbo].[irrigation_slot] ([id])
GO
ALTER TABLE [dbo].[plot_irrigation_slots] CHECK CONSTRAINT [FK9mjpdcc2uggp9hhueunjg2mlc]
GO
ALTER TABLE [dbo].[plot_irrigation_slots]  WITH CHECK ADD  CONSTRAINT [FKji76i06dk5g5340lc7wo6r20i] FOREIGN KEY([plot_id])
REFERENCES [dbo].[land_plots] ([id])
GO
ALTER TABLE [dbo].[plot_irrigation_slots] CHECK CONSTRAINT [FKji76i06dk5g5340lc7wo6r20i]
GO
