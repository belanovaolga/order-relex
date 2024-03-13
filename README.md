# order-relex
Relex company spring internship 2024 test task Java

## Стек:
Java 17\
Maven\
PostgreSQL\
Spring Boot 3.2.3\
Spring-Boot-Web\
Spring-Boot-Data-JPA\
Project Lombok

## Задание:
Разработать приложение в виде RESTful API на языке Java с использованием фреймворка Spring Boot.\
Данные, получаемые и отправляемые приложением, должны быть в формате JSON.\
Приложение должно реализовывать функционал для оптимизации работы фермы.
## Реализованные требования:

_Примеры привожу в Postman_

### Добавление собранного (произведенного) товара в хранилище:
* есть API, позволяющий добавить произведенный товар в хранилище\
  _В качестве хранилища используется PostgreSQL_

![Order Create .png](src%2Fmain%2Fresources%2Fimages%2FLogin%20Page.png)

![Order Create DB before .png](src%2Fmain%2Fresources%2Fimages%2FOrder%20Create%20DB%20before.png)

![Order Create DB after .png](src%2Fmain%2Fresources%2Fimages%2FOrder%20Create%20DB%20after.png)

* при добавлении произведенного товара сотрудником, также обновляется общее количество товара

![Product Update .png](src%2Fmain%2Fresources%2Fimages%2FProduct%20Update.png)

### Просмотр статистики по произведенным товарам по конкретному человеку и ферме в целом:
* есть API, позволяющий посмотреть статистику по произведенным товара по ферме в целом

![Collected Order .png](src%2Fmain%2Fresources%2Fimages%2FCollected%20Order.png)

* есть API, позволяющий посмотреть статистику по произведенным товарам по конкретному человеку

![Collected Order By Employee .png](src%2Fmain%2Fresources%2Fimages%2FCollected%20Order%20By%20Employee.png)
