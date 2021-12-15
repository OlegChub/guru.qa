# Проект автотестов на СоюзЦветТорг

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
<a href="https://ibb.co/tBy7ZKX"><img src="https://i.ibb.co/Nxw81CS/2021-12-15-18-54-02.png" alt="2021-12-15-18-54-02" border="0"></a>

Параметры запуска <br >
<a href="https://ibb.co/phH347m"><img src="https://i.ibb.co/BnhgTp1/2021-12-15-18-58-00.png" alt="2021-12-15-18-58-00" border="0"></a>

### Отчёт о прохождении автотестов в Allure Report

<a href="https://ibb.co/3mqnbxp"><img src="https://i.ibb.co/b5ZkV4s/2021-12-15-18-59-37.png" alt="2021-12-15-18-59-37" border="0"></a>

### Список автотестов в Allure Report

<a href="https://ibb.co/TPzjtky"><img src="https://i.ibb.co/kqYbXxZ/2021-12-15-19-00-47.png" alt="2021-12-15-19-00-47" border="0"></a>

### Видео о прохождении тестов

</a><a href="https://ibb.co/cwzhJQY"><img src="https://i.ibb.co/tzypBDL/video-online-video-cutter-com.gif" alt="video-online-video-cutter-com" border="0"></a>
### Уведомления о прохождении автотестов в Telegram

<a href="https://ibb.co/4g1bTsn"><img src="https://i.ibb.co/G3HZ2s4/2021-12-15-19-01-45.png" alt="2021-12-15-19-01-45" border="0"></a>