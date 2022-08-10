### Application Server

После клонирования репозитория необходимо:
1. Переопределить [settings.xml](settings.xml).
2. Добавить пользователя в локальные конфигурации application server-а и в [settings.xml](settings.xml).
3. Запустить application server.
4. _`mvn clean package`_
5. _`mvn -P tomcat tomcat7:redeply`_

*_При использовании Apache Tomcat версия должна быть не ниже 10.х._
***


###Быстрые ссылки:
- [Корзина](http://localhost:8080/servletFirstHw/main?stage=cart)
- [Каталог](http://localhost:8080/servletFirstHw/main?stage=catalog)
***