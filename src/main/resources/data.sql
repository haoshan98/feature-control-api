INSERT INTO user (email) VALUES ('user01@gmail.com');
INSERT INTO user (email) VALUES ('user02@gmail.com');

INSERT INTO feature (name) VALUES ('feature01');
INSERT INTO feature (name) VALUES ('feature02');
INSERT INTO feature (name) VALUES ('feature03');

INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (1, 1, TRUE);
INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (1, 2, TRUE);
INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (1, 3, FALSE);
INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (2, 1, TRUE);
INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (2, 2, FALSE);
INSERT INTO user_permission (user_id, feature_id, is_enabled) VALUES (2, 3, TRUE);