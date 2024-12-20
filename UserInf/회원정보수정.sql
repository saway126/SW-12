SELECT * FROM quedoc.user;


UPDATE user
SET 
    password = 'fO4&fZ/Fq@=6*',
    nickname = 'Quinsee',
    email = 'equinsee2@princeton.edu',
    phoneNumber = '528-743-7785',
    address = '1065 Summer Ridge Parkway'
WHERE 
    idx = 5
    AND password = 'oldPassword';
