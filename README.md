# user-poll
REST API на Spring Framework опроса пользователей

## Функционал
Для администратора:
-  авторизация
-  добавление/изменение/удаление опросов
-  добавление/изменение/удаление вопросов в опросе

Для пользователей:
-  получение списка активных опросов
-  получение списка вопросов в опросе
-  прохождение опросов
-  получение пройденных опросов

## Запуск проекта
Для запуска проекта необходимо клонировать проет с репозитория и запустить в среде разработки.

Для аутентификация по умолчанию используются следующие данные:
- login : admin
- password : admin

```Хост``` http://localhost:8080


# Документация к API

## Авторизация - `POST /api/v1/auth/login`

**Авторизация:** не требуется

**Запрос:**

```json
{
  "login": "admin",
  "password": "admin"
}
```

* `login` - логин администратора
* `password` - пароль администратора


## Выход - `GET /api/v1/auth/logout`

**Авторизация:** требуется

## Добавление опроса `POST /api/v1/poll/add`

**Авторизация:** требуется

**Параметры запроса:**

```json
{
  "name": "Опрос",
  "description": "Описание опроса",
  "expiration_date": 1639336001
}
```

* `name` - название опроса
* `description` - описание опроса
* `expiration_date` - дата окончания опроса

## Редактирование опроса `PUT /api/v1/poll/{id}/update`

**Авторизация:** требуется

**Параметры:**

* `id` - id опроса

**Параметры запроса:**

```json
{
  "name": "Опрос",
  "description": "Измененное описание опроса",
  "expiration_date": 1640954748
}
```

* `name` - название опроса
* `description` - описание опроса
* `expiration_date` - дата окончания опроса

## Удаление опроса `DELETE /api/v1/poll/{id}`

**Авторизация:** требуется

## Добавление вопроса к опросу `POST /api/v1/poll/{id}/question`

**Авторизация:** требуется

**Параметры:**

* `id` - id опроса

**Параметры запроса:**

```json
{
  "text": "Вопрос",
  "type": "TEXT"
}
```

* `text` - текст вопроса
* `type` - тип ответа для вопроса:
  * `TEXT` - ответ с текстом
  * `SINGLE_SELECT` - ответ с выбором одного варианта
  * `MULTI_SELECT` - ответ с выбором нескольких вариантов
  
## Изменение существующего вопроса `PUT /api/v1/poll/question/{id}`

**Авторизация:** требуется

**Параметры:**

* `id` - id вопроса

**Параметры запроса:**

```json
{
  "text": "Измененный текст вопроса",
  "type": "SINGLE_SELECT"
}
```

## Удаление вопроса `DELETE /api/v1/poll/question/{id}`

**Авторизация:** требуется

**Параметры:**

* `id` - id вопроса

## Список опросов `GET /api/v1/poll/active`

**Авторизация:** не требуется

**Пример ответа:**

```json
{
    "poll_name": "Опрос",
    "poll_description": "описание опроса",
    "start_date": "2021-12-09 21:18",
    "end_date": "2021-12-12 23:59"
}
```

## Список вопросов в опросе `GET /api/v1/poll/active/{id}`

**Авторизация:** не требуется

**Пример ответа:**

```json
{
    "poll_name": "Опрос",
    "poll_description": "описание опроса",
    "start_date": "2021-12-09 21:18",
    "end_date": "2021-12-12 23:59",    
    "questions": [
        {
            "id": 1,
            "text": "текст вопроса",
            "type": "TEXT"
        }
    ]
}
```

## Прохождение опроса `POST /api/v1/poll/pass`

**Авторизация:** не требуется

**Параметры запроса:**

```json
{
    "user_id": 3,
    "poll": [
        {
            "id": 1,
            "questions": [
                {
                    "id": 1,
                    "answer": {
                        "text": "Ответ на вопрос",
                        "type": "TEXT"
                    }
                  }
            ]
        }
    ]
}
```

* `user_id` - уникальный идентификатор пользователя
* `poll` - список пройденных пользователем опросов
  * `id` - уникальный идентификатор опроса
  * `questions` - список вопросов в каждом опросе
    * `id` - уникальный идентификатор вопроса
    * `answer` - ответ на вопрос
      * `text` - текст ответа на вопрос
      * `type` - тип ответа на вопрос
      
# Получение детализации пройденных опросов `GET /api/v1/poll/passed/{id}`

**Авторизация:** не требуется

**Параметры:**

* `id` - уникальный идентификатор пользователя

**Формат ответа:**

```json
[
    {
        "poll_name": "Опрос_1",
        "poll_description": "Первый опрос",
        "questions": [
            {
                "question_text": "Текст вопроса для первого опроса",
                "question_type": "TEXT",
                "answer": {
                    "text": "Ответ на вопрос",
                    "type": "TEXT"
                }
            }
        ]
    }
]
```
