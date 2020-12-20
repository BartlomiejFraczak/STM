;             
CREATE USER IF NOT EXISTS "STM_USER" SALT '9fcf625d6cd80d09' HASH '782757373c2bf0ba5341fa2d21ef9fc08ea3227a45db4260d5ad6ce8508b6fb3' ADMIN;   
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_DFD6580C_3FBD_4C51_908A_182D59FDE4A4" START WITH 3 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_5DA94823_0EAE_461B_94E0_C8593588FCBB" START WITH 3 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."TASKS"(
    "TASK_ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_5DA94823_0EAE_461B_94E0_C8593588FCBB" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_5DA94823_0EAE_461B_94E0_C8593588FCBB",
    "DATE_ADDED" DATETIME DEFAULT CURRENT_TIMESTAMP,
    "DESCRIPTION" VARCHAR(255),
    "STATUS" VARCHAR(255),
    "TITLE" VARCHAR(255),
    "TYPE" VARCHAR(255),
    "USER_USER_ID" INTEGER
);
ALTER TABLE "PUBLIC"."TASKS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("TASK_ID");   
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.TASKS;   
INSERT INTO "PUBLIC"."TASKS" VALUES
(1, TIMESTAMP '2020-12-20 12:01:33.069468', 'zrobic pranie', 'NEW', 'pranie', 'TASK', 1),
(2, TIMESTAMP '2020-12-20 12:01:33.069468', 'ugotuj obiad', 'INPROGRESS', 'obiad', 'TASK', 1);
CREATE CACHED TABLE "PUBLIC"."USERS"(
    "USER_ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_DFD6580C_3FBD_4C51_908A_182D59FDE4A4" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_DFD6580C_3FBD_4C51_908A_182D59FDE4A4",
    "EMAIL" VARCHAR(255),
    "LAST_NAME" VARCHAR(255),
    "NAME" VARCHAR(255),
    "PASSWORD" VARCHAR(255),
    "REGISTRATION_DATE_AND_TIME" DATETIME DEFAULT CURRENT_TIMESTAMP,
    "STATUS" BOOLEAN DEFAULT FALSE
);        
ALTER TABLE "PUBLIC"."USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4D" PRIMARY KEY("USER_ID");  
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.USERS;   
INSERT INTO "PUBLIC"."USERS" VALUES
(1, 'bartekfraczak@gmail.com', 'Fraczak', 'Bartek', '123', TIMESTAMP '2020-12-20 12:01:33.067467', TRUE),
(2, 'marcinkaczmarek@o2.pl', 'Kaczmarek', 'Marcin', '321', TIMESTAMP '2020-12-20 12:01:33.068467', FALSE);    
ALTER TABLE "PUBLIC"."TASKS" ADD CONSTRAINT "PUBLIC"."FKPMRSAIKUG4G2IA9G3NDHNMNF5" FOREIGN KEY("USER_USER_ID") REFERENCES "PUBLIC"."USERS"("USER_ID") NOCHECK;
