USE [irrigation_system]
GO
SET IDENTITY_INSERT [dbo].[crop] ON 

INSERT [dbo].[crop] ([id], [crop_name], [water_amount_per_meter]) VALUES (1, N'tomato', 1)
INSERT [dbo].[crop] ([id], [crop_name], [water_amount_per_meter]) VALUES (2, N'rice', 5)
INSERT [dbo].[crop] ([id], [crop_name], [water_amount_per_meter]) VALUES (3, N'orange', 2)
INSERT [dbo].[crop] ([id], [crop_name], [water_amount_per_meter]) VALUES (4, N'wheat', 1)
SET IDENTITY_INSERT [dbo].[crop] OFF
SET IDENTITY_INSERT [dbo].[land] ON 

INSERT [dbo].[land] ([id], [land_name], [location], [owner_name], [total_area]) VALUES (1, N'Fayrouz land', N'Sinai', N'Mostafa Mohamed', 600)
INSERT [dbo].[land] ([id], [land_name], [location], [owner_name], [total_area]) VALUES (2, N'Zahraa land', N'Giza', N'Ahmed Mohamed', 300)
SET IDENTITY_INSERT [dbo].[land] OFF
SET IDENTITY_INSERT [dbo].[water_pipe] ON 

INSERT [dbo].[water_pipe] ([id], [water_capacity_per_min]) VALUES (1, 2)
INSERT [dbo].[water_pipe] ([id], [water_capacity_per_min]) VALUES (2, 1)
INSERT [dbo].[water_pipe] ([id], [water_capacity_per_min]) VALUES (3, 2)
INSERT [dbo].[water_pipe] ([id], [water_capacity_per_min]) VALUES (4, 2)
INSERT [dbo].[water_pipe] ([id], [water_capacity_per_min]) VALUES (5, 5)
SET IDENTITY_INSERT [dbo].[water_pipe] OFF
SET IDENTITY_INSERT [dbo].[land_plots] ON 

INSERT [dbo].[land_plots] ([id], [length], [soil_temp], [watering_ind], [width], [crop_id], [land_id], [pipe_id]) VALUES (1, 1, 80, N'N', 1, 3, 1, 2)
INSERT [dbo].[land_plots] ([id], [length], [soil_temp], [watering_ind], [width], [crop_id], [land_id], [pipe_id]) VALUES (2, 2, 50, N'N', 3, 2, 1, 3)
INSERT [dbo].[land_plots] ([id], [length], [soil_temp], [watering_ind], [width], [crop_id], [land_id], [pipe_id]) VALUES (3, 2, 80, N'N', 2, 4, 2, 4)
INSERT [dbo].[land_plots] ([id], [length], [soil_temp], [watering_ind], [width], [crop_id], [land_id], [pipe_id]) VALUES (4, 200, 80, N'N', 2, 1, 2, 5)
SET IDENTITY_INSERT [dbo].[land_plots] OFF
SET IDENTITY_INSERT [dbo].[irrigation_slot] ON 

INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (37, CAST(N'2022-10-03 17:18:17.5150000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (38, CAST(N'2022-10-03 17:20:28.4080000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (39, CAST(N'2022-10-03 17:23:22.0030000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (40, CAST(N'2022-10-03 17:26:20.3680000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (41, CAST(N'2022-10-03 17:28:45.0880000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (42, CAST(N'2022-10-03 17:31:36.0750000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (43, CAST(N'2022-10-03 17:33:46.7340000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (44, CAST(N'2022-10-03 20:29:55.5290000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (45, CAST(N'2022-10-03 20:33:13.3540000' AS DateTime2))
INSERT [dbo].[irrigation_slot] ([id], [begin_watering_date]) VALUES (46, CAST(N'2022-10-03 20:42:27.1340000' AS DateTime2))
SET IDENTITY_INSERT [dbo].[irrigation_slot] OFF
INSERT [dbo].[plot_irrigation_slots] ([plot_id], [slot_id], [end_watering_date]) VALUES (1, 43, CAST(N'2022-10-03 17:33:46.7340000' AS DateTime2))
INSERT [dbo].[plot_irrigation_slots] ([plot_id], [slot_id], [end_watering_date]) VALUES (1, 44, CAST(N'2022-10-03 20:29:55.5290000' AS DateTime2))
INSERT [dbo].[plot_irrigation_slots] ([plot_id], [slot_id], [end_watering_date]) VALUES (1, 45, CAST(N'2022-10-03 20:34:13.3500000' AS DateTime2))
INSERT [dbo].[plot_irrigation_slots] ([plot_id], [slot_id], [end_watering_date]) VALUES (3, 46, CAST(N'2022-10-03 20:50:27.1230000' AS DateTime2))
