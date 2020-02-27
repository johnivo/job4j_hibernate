[![Build Status](https://travis-ci.org/johnivo/job4j_hibernate.svg?branch=master)](https://travis-ci.org/johnivo/job4j_hibernate)

## job4j_hibernate

### TODO-list

Простой планировщик задач.

![hall](https://github.com/johnivo/job4j_hibernate/blob/master/src/main/resources/todo.GIF)

#### Задача: создать приложение TODO-list.

+ Одна таблица в базе данных (item. id, desc. created, done).
+ Веб приложение должно иметь одну страницу index.html.
+ На странице форма: добавить новое задание, описание.
+ Ниже список всех заданий и галочка: выполнено / не выполнено.
+ Вверху списка галочка: "показать все". Если включена, то показывать все задания. Если нет - только невыполненные.
+ Все данные на форму загружаются через AJAX.
+ Данные должны сохраняться через Hibernate.

#### Использованные технологии:
+ Java 8
+ Apache Maven
+ Apache Tomcat
+ Servlet 3
+ Ajax JSON
+ Hibernate
+ Liquibase
+ PostgreSQL
+ JUnit