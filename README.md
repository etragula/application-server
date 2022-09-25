### Application Server

После клонирования репозитория необходимо:
1. Переопределить [settings.xml](settings.xml).
2. Добавить пользователя в локальные конфигурации application server-а и в [settings.xml](settings.xml).
3. Запустить application server.
4. Добавить конфигурации для БД в [application.properties](src/main/resources/application.properties).
5. `mvn clean package`
6. `mvn -P tomcat tomcat7:redeploy`

*_При использовании Apache Tomcat версия должна быть не ниже 10.х._
***


### Быстрые ссылки:
- [Главная](http://localhost:8080/application-server/)
- [Вход](http://localhost:8080/application-server/signIn)
- [Каталог](http://localhost:8080/application-server/?stage=catalog)
- [Корзина](http://localhost:8080/application-server/?stage=cart)
- [Товары](http://localhost:8080/application-server/products)
- [Загрузить файл](http://localhost:8080/application-server/oneFileUpload)
- [Загрузить файлы](http://localhost:8080/application-server/twoFilesUpload)
- [Калькулятор](http://localhost:8080/application-server/calculator)