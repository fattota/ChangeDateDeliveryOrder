package ru.netology.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;


public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationInfo generateInfo(String locale) {
            String city = generateCity(cities);
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationInfo(city,
                    generateDate(3),
                    faker.name().fullName(),
                    faker.phoneNumber().subscriberNumber(11));
        }

        public static String generateCity(String[] array) {
            int city = new Random().nextInt(array.length);
            return array[city];
        }
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static String[] cities = new String[]{
            "Майкоп",
            "Горно-Алтайск",
            "Уфа",
            "Улан-Удэ",
            "Махачкала",
            "Магас",
            "Нальчик",
            "Элиста",
            "Черкесск",
            "Петрозаводск",
            "Сыктывкар",
            "Симферополь",
            "Йошкар-Ола",
            "Саранск",
            "Якутск",
            "Владикавказ",
            "Казань",
            "Кызыл",
            "Ижевск",
            "Абакан",
            "Грозный",
            "Чебоксары",
            "Барнаул",
            "Чита",
            "Петропавловск-Камчатский",
            "Краснодар",
            "Красноярск",
            "Пермь",
            "Владивосток",
            "Ставрополь",
            "Хабаровск",
            "Благовещенск",
            "Архангельск",
            "Астрахань",
            "Белгород",
            "Бранск",
            "Владимир",
            "Волгоград",
            "Вологда",
            "Воронеж",
            "Иваново",
            "Иркутск",
            "Калининград",
            "Калуга",
            "Кемерово",
            "Киров",
            "Кострома",
            "Курган",
            "Курск",
            "Гатчина",
            "Липецк",
            "Магадан",
            "Красногорск",
            "Мурманск",
            "Нижний Новгород",
            "Великий Новгород",
            "Новосибирск",
            "Омск",
            "Оренбург",
            "Орел",
            "Пенза",
            "Псков",
            "Ростов-на-Дону",
            "Рязянь",
            "Самара",
            "Саратов",
            "Южно-Сахалинск",
            "Екатеринбург",
            "Смоленск",
            "Тамбов",
            "Тверь",
            "Томск",
            "Тула",
            "Тюмень",
            "Ульяновск",
            "Челябинск",
            "Ярославль",
            "Москва",
            "Санкт-Петербург",
            "Севастополь",
            "Биробиджан",
            "Ханты-Мансийск",
            "Анадырь",
            "Салехард"

    };


}
