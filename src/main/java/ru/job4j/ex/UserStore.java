package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User is not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Scrapy Coco", false),
                new User("Li", true),
                new User("Po", false),
                new User("Lol", true)
        };
        try {
            User user = findUser(users, "loooo");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException iex) {
            iex.printStackTrace();
        } catch (UserNotFoundException nfex) {
            nfex.printStackTrace();
        }
    }
}