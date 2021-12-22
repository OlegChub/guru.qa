# Проект автотестов на СоюзЦветТорг

## Покрыт следующий функционал

* UI тесты
  * ✅ Проверка наличия хедера на странице
  * ✅ Проверка правильности title страницы
  * ✅ Проверка наличия вакансии на странице
  * ✅ Проверка номера телефона на странице контактов
  * ✅ Проверка кол-ва интервалов доставки на странице доставки и оплаты
  * ✅ Проверка кол-ва размещенных и активных магазинов

## Технологический стек

Java, Gradle, JUnit5, IntelliJ IDEA, Selenide, Jenkins, Allure TestOps, Jira, Github, Telegram

<a href="https://github.com/angry-qa/vkc-demo">
  <img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Seleide"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"  alt="Jenkins"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure TestOps"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"  alt="Jira"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"  alt="Github"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"  alt="Telegram"/>
</a>

## Как запустить

Перед выполением необходимо:

* В launch.properies определяются следующие параметры конфигурации (для запуска тестов удаленно):
  - browser (default Chrome)
  - browserVersion (default 91.0)
  - browserSize (default 1920x1080)
  - remoteUrl (url address from selenoid or grid)

### Запуск локально

```
gradle clean test
```

### Запуск удаленно

```bash
gradle clean -DremoterUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ test
```

### Запуск в Jenkins

Статистика по запускам <br >
<a href="https://ibb.co/yFt5MYK"><img src="https://i.ibb.co/MkrpjGK/2021-12-22-16-11-14.png" alt="2021-12-22-16-11-14" border="0"></a>
Параметры запуска <br >
<a href="https://ibb.co/BLmVPhm"><img src="https://i.ibb.co/wyTNLnT/2021-12-22-16-09-31.png" alt="2021-12-22-16-09-31" border="0"></a>

### Отчёт о прохождении автотестов в Allure Report

<a href="https://ibb.co/TRNLXG2"><img src="https://i.ibb.co/RPJynKb/2021-12-22-16-04-26.png" alt="2021-12-22-16-04-26" border="0"></a>

### Список автотестов в Allure Report

<a href="https://ibb.co/nm8RY3r"><img src="https://i.ibb.co/8s4XfzM/2021-12-22-16-12-59.png" alt="2021-12-22-16-12-59" border="0"></a>

### Видео о прохождении тестов

<a href="https://ibb.co/t3LP09y"><img src="https://i.ibb.co/vDXvNS2/video.gif" alt="video" border="0"></a>

### Уведомления о прохождении автотестов в Telegram

<a href="https://ibb.co/rMNd4L9"><img src="https://i.ibb.co/ctVYDpq/2021-12-22-16-03-39.png" alt="2021-12-22-16-03-39" border="0"></a>