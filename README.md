# capg_login_console_app :octocat:

In order to use login, firstly extends AuthenticationDaoImpl to UiMainClass ```UiMainClass extends AuthenticationDaoImpl```  to use login, validation, logout service, encrytion service.

### Add User To Store
* add user by creating object as admin type
```
User u1 = new User("user", "password", "type");
service.addUser(store, u1); // retrun type string
```

* add user by creating object as normal user type
```
User u1 = new User(user, password);
service.addUser(store, u1); // retrun type string
```

* add user with username and password 
```
service.addUser(store, username, password) // retrun type string
```

### Validation Using Regex
__This validation password password that contain only number[0-9], alphbade[a-z], and special character _, -, *. Min length is 6 and Max length is 15.__

```
String regex = "^[a-z0-9_-[*]]{6,15}$";
```
*Change this regex accordingly to do validation*

### Password encrytion
__User Password is encryped by using md5 hasing.__


### Methods
* __Login Method__
```
loginCheck(username, password);  //return type String
```

* __Forget Password Method__
```
forgetPassword(username, newpassword); // retrun type string
```

* __Get current login__
```
this.getLoginUser(); // return type string (Id)
```

* __Logout__
```
this.logout(username); // retrun type string
```





