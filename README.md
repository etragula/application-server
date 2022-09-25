### Application Server

После клонирования репозитория необходимо:
1. Переопределить [settings.xml](settings.xml).
2. Добавить пользователя в локальные конфигурации application server-а и в [settings.xml](settings.xml).
3. Запустить application server.
4. _`mvn clean package`_
5. _`mvn -P tomcat tomcat7:redeploy`_

*_При использовании Apache Tomcat версия должна быть не ниже 10.х._
***


### Быстрые ссылки:
- [Главная](http://localhost:8080/application-server/)
- [Вход](http://localhost:8080/application-server/signIn)
- [Каталог](http://localhost:8080/application-server/?stage=catalog)
- [Корзина](http://localhost:8080/application-server/?stage=cart)
- [Загрузить файл](http://localhost:8080/application-server/oneFileUpload)
- [Загрузить файлы](http://localhost:8080/application-server/twoFilesUpload)
- [Калькулятор](http://localhost:8080/application-server/calculator)

http://localhost:8080/application_server/
http://localhost:8080/application-server/