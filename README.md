# Итоговый проект 9 вариант
## Ход выполнения:
1. Написал класс для парса csv файлов
2. Распарсил файл
3. Написал несколько классов объединяющих смысловые компоненты
4. Написал общий класс для школы
5. Создал набор объектов класса School
6. Проанализировал данную таблицу и понял, что она готова к полному переносу в БД (соответствует 3 норм. форме)
7. С помощью JDBC создал БД SQL Lite
8. Создал класс для работы с БД DbHandler
9. Приступил к заданиям и по мере их выполнения добавлял новые методы в DbHandler
10. Для выполнения 1 заданя скачал JFreeChart и написал класс ChartHandler для работы с библиотекой
11. Для 2 и 3 задания только добавлял методы в DbHandler и доставал данные с помощью SQL-запросов
В коммитах мейна можно увидеть вызовы решения заданий

## Задание 1
***Задача:*** *постройте график по среднему количеству студентов, в 10 различных странах, взять на свой выбор.*

**График:**
![alt text](https://sun9-27.userapi.com/impg/W-B_OaMvoBvR5XCfZhhv4egFgTm3s90e792NtA/lYm44YZPVzg.jpg?size=1100x400&quality=96&sign=e58e0e5ac87e857cce56e01d43cb06fc&type=album)

## Задание 2
***Задача:*** *выведите в консоль среднее количество расходов(expenditure) в Fresno, Contra Costa, El Dorado и Glenn, у которых расход больше 10.*

**Результат:**

![alt text](https://sun9-13.userapi.com/impg/xSXm6lMKEl9q_4JzP4Yf8czHnaFZUWrgIZb3LA/cUO19tzdFGw.jpg?size=198x101&quality=96&sign=f47b0271fae50ac09488b0083018c5be&type=album)

В задаче требуется вывести среднее количество расходов более 10, но самый минимальный - 3000. Поэтому результат аналогичен просто средним расходом данных стран.

## Задание 3
***Задача:*** *Выведите в консоль учебное заведение, с количеством студентов равному от 5000 до 7500 и с 10000 до 11000, с самым высоким показателем по математике (math).*

**Результат:**

![alt text](https://sun9-66.userapi.com/impg/eyhR4jEIgg-EpGgPpagm65hu2YPTL347Zjlxiw/EN_pZdTTzkg.jpg?size=225x25&quality=96&sign=0036f5fa830d3387d0468d1490af35bf&type=album)
