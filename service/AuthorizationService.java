package service;

import entity.User;

import java.util.Scanner;

public class AuthorizationService {

    private final UserService userService = new UserService();

    public void registration(Scanner scanner) {
        System.out.println( "Input username" );
        String username = scanner.next();
        if (userService.exists( username )) {
            System.out.println( "This username is already used" );
        } else {
            System.out.println( "Input password" );
            String password = scanner.next();
            userService.save( new User( username, password ) );
            System.out.println( "Complete" );
        }
    }

    public User authorization(Scanner scanner) {
        System.out.println( "Input username" );
        String username = scanner.next();
        System.out.println( "Input password" );
        String password = scanner.next();
        User user = userService.findByUsernameAndPassword( username, password );
        if (user != null) {
            System.out.println( "Успех" );
            return user;
        } else {
            System.out.println( "Пользователя не существует или пароль неверен!" );
            return null;
        }

    }
}
