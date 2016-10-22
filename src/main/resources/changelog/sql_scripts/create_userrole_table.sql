CREATE TABLE USERROLE_TABLE (
 USER_ROLE_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
 USER_ID BIGINT(20) NOT NULL,
 ROLE VARCHAR(20) NOT NULL,
 PRIMARY KEY (USER_ROLE_ID),
 UNIQUE KEY UNI_USER_ID_ROLE(ROLE,USER_ID),
 key FK_USER_IDX(USER_ID),
 CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES USER_TABLE(ID)
);
