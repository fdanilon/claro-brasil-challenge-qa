package dataFactory;

import pojo.UserPojo;

public class UserDataFactory {

    public static UserPojo createUser (){
        UserPojo user = new UserPojo();
        user.setUserLogin("qwertyuuytrewq@gmail.com");
        user.setUserPassword("https://practice.automationtesting.in/");

        return user;
    }

    public static UserPojo creatNotRegisteredUser (){
        UserPojo user = new UserPojo();
        user.setUserLogin("asdvcxxcvdsa@gmail.com");
        user.setUserPassword("https://practice.automationtesting.in/");

        return user;
    }
}
