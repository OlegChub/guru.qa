# Проект автотестов на МЕДИНДЕКС

## Покрыт следующий функционал

* UI тесты
    * ✅ Проверка наличия хедера на странице
    * ✅ Проверка правильности title страницы
    * ✅ Проверка наличия вакансии на странице

## Технологический стек

Java, Gradle, JUnit5, IntelliJ IDEA, Selenide, Jenkins, Allure TestOps, Jira, Github, Telegram

<a href="https://github.com/angry-qa/vkc-demo">
  <img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Seleide"/>
<img src="https://starchenkov.pro/qa-guru/img/skills/Selenium.svg" width="40" height="40"  alt="Java"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"  alt="Jenkins"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure TestOps"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"  alt="Jira"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"  alt="Github"/>
  <img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"  alt="Telegram"/>
</a>

## Как запустить

Перед выполением необходимо:

* в local.properies определить параметры конфигурации (для запуска тестов локально)
* в remote.properies определить параметры конфигурации (для запуска тестов удаленно) или передать значения:
    - browser (default chrome)
    - browserVersion (default 89.0)
    - browserSize (default 1920x1080)
    - browserMobileView (mobile device name, for example iPhone X)
    - remoteDriverUrl (url address from selenoid or grid)
    - videoStorage (url address where you should get video)
    - threads (number of threads)

### Локально

```
gradle clean test
```

### Удаленно

```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Видео о прохождении тестов

<img src="https://i.ibb.co/93q2DGd/fefcc5cbac5d03c1.gif" alt="video test" border="0" />

### Запуск в Jenkins

Статистика по запускам <br >
<a href="https://ibb.co/nnKgcv6"><img src="https://i.ibb.co/CMS17Zm/statistic-jenkins.png" alt="Статистика по запускам" border="0" /></a>

Параметры запуска <br >
<a href="https://ibb.co/zbNbgHb"><img src="https://i.ibb.co/Y8b8ST8/jenkins-parametrs.png" alt="jenkins-parametrs" border="0" /></a>

### Отчёт о прохождении автотестов в Allure Report

<a href="https://ibb.co/HzG3q6q"><img src="https://i.ibb.co/WyBjfZf/Allure-report.png" alt="Allure-report" border="0" /></a>

### Список автотестов в Allure Report

<a href="https://ibb.co/sWqKV61"><img src="https://i.ibb.co/hYVBmZd/Allure-list.png" alt="Allure-list" border="0" /></a>

### Уведомления о прохождении автотестов в Telegram

<a href="https://ibb.co/zFnQg63"><img src="https://i.ibb.co/kJH5TmL/2021-12-15-18-40-02.png" alt="2021-12-15-18-40-02" border="0"></a>