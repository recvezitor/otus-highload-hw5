# hw5

* монолит
* реактивщина
* без ОРМ
* добавлены индексы к полям для поиска
* добавлено кеширование ленты друзей
* добавлены вебсокеты и реббит


### Инструкция

Добавлена возможность в режиме реального времени публиковать новые посты через вебсокет пользователям, которые подписались на /post/feed/posted
Пользователь должен быть залогинен и в вебсокет запросе предоставить bearer токен.
Exchange создается при старте приложения (если не был уже создан).
При логине пользователя, получаем всех его друзей и на каждого друга создаем  очередь в формате subscription.<friendId>.<userId>
Биндинг происходинг по id пользователя, который опубликовал пост, таким образом все пользователи, которые подписались на очередь своего друга получат
сообщение в соответствующую очередь. Если к этому времени он был подключен через веб-сокет (или имитируем подключение фронта через Постман)
то ему тут же отправится новый пост.
Благодаря тому что очереди сделаны exclusive'ными сервис линейно масштабируется - при подключении нового сервиса соединение с очередью rabbit'а
получит только один из инстансов и публиковать в вебсокет будет только один инстанс, через который произошел логин.
Единственное, нужно будет доработать сохранение вебсокет сессий, чтобы маппинг userId-session хранилась в редисе, а не в памяти
Для кластеризованной версии Рэббита можно использовать образ bitnami/rabbitmq-cluster-operator:latest 

Сценарий:

1. Залогиниться под Леопольдом и подключиться с полученным токеном к вебсокету
2. Залогиниться под Дикаприо и подключиться с полученным токеном к вебсокету
3. Залогиниться под ЛедиГага
4. Опубликовать пост от имени ЛедиГаги
5. Проверить что в вебсокеты Леопольда и Дикаприо прилетел новый пост
6. Если опубликовать пост от имени Леопольда (дружит только с Гагой), то пост будет виден только у Гаги


### install

mvn clean install
docker build -f docker/Dockerfile.jvm -t otus-highload-hw5:latest .
docker images

### publish

docker tag otus-highload-hw5:latest recvezitor/otus-highload-hw5:latest
docker login -> recvezitor/password
docker push recvezitor/otus-highload-hw5:latest

### deploy 

docker compose -f ./docker/docker-compose.yml up