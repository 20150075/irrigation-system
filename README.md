#Automatic irrigation system
this appplication listen on plot soil temperature (listen on [soil_temp] column from land_plots table)
if the soil temperature less than or equal the dry temperature (dryTemp configurable property in property file) then 
the automatic irrigation process will be begin for this plot and watering indicator will be 'Y' till the process ends
and soil temperature will be raised to the normal temperature (normalTemp onfigurable property ),
listening proccess occurred every 1 min.

#Needed softwares
Tomcat or anything to run the war 
Sql server Database
Postman 

#Deployment guides 
create new database called irrigation_system using this command  "create DATABASE irrigation_system"
put the war folder in tomcat webapps
configure application.properties file
application will create the tables and their constraints "spring.jpa.hibernate.ddl-auto = drop-create
or you can run the schema and data from schema.sql &data.sql  (in resources folder)
run the tomcat
try the services through postman

#Database structure 
land_plots table has plot properties :length,width,soil_temp,watering_ind,id
crop table :crop_name,water_amount_per_meter,id (each plot has one crop)
irrigation_slot: begin_watering_date,id (each plot has more than one watering slot, and each slot can be related to more than plot)
land: land_name,location,owner_name,total_area,id (each land has more than plot and each plot related to one land)
water_pipe: water_capacity_per_min,id (each pipe connected to one plot and each plot has one pipe)
plot_irrigation_slots: to handle many to many relationship between slots and plots, this relationship has end_watering_date column to record irrigation end time and date

#Services

 --Password Encryptin 
 password encryption (this service to generate encrypted database password to help in property file configuration , or u can online website to generate it
 https://www.devglan.com/online-tools/jasypt-online-encryption-decryption with secret key (P@ssw0rd-Key)
 
 --Plot
 add Plot 
 get all plots
 get plot by id
 delete plot 
 update plot (u can update crop , soil temperature ) only 
 
 --pipe 
 add pipe
 get pipe by id
 get all pipes
 update pipe
 
 --land
 get all lands
 update land
 add land
 get land by id
 
 --crop
 get all crops
 update crop
 add crop
 get crop by id
 
 --irrigationSlot
  get all slots
  
  
 


