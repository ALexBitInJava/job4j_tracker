package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (!(user.equals(login))) {
                throw new UserNotFoundException("The login not found");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 4) {
            throw new UserInvalidException("This name is not valid");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {new User("Alex Golovin", true)};
        try {
            User user = findUser(users, "Alex Golovin");
            boolean rsl = validate(user);
        } catch (UserInvalidException usIn) {
            usIn.printStackTrace();
        } catch (UserNotFoundException userNo) {
            userNo.printStackTrace();
        }
    }
}