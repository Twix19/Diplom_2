package org.example.user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User generic() {
        return new User("dhsjcv@yandex.ru", "P@ssw0rd123", "Svfarrow");
    }
    public static User random() {
        return new User(RandomStringUtils.randomAlphanumeric(5, 20), "P@ssw0rd123", "Sparrow");
    }
}
