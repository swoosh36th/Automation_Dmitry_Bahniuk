Task 10

1. Обновить версии всех библиотек в проекте и ее вывод
        Команда - mvn versions:display-dependency-updates 

        [INFO] --- versions-maven-plugin:2.12.0:display-dependency-updates (default-cli) @ Automation_Dmitry_Bahniuk ---
        [INFO] No dependencies in Dependencies have newer versions.

2. Запустить тесты используя mvn clean test команду и ее вывод
        Команда - mvn clean test -DsuiteXmlFile=task9

        [INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 25.126 s - in TestSuite

3. Использовать параметры для запуска конкретных тестов и методов
        Команда - mvn -Dtest=lecture9_1Test test

        [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.628 s - in lecture9.lecture9_1Test

        Команда - mvn -Dtest=lecture9_1Test#test1
        
        [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.578 s - in lecture9.lecture9_1Test

        Команда - mvn -Dtest=task9_1Test#loginTest1+loginTest2 test

        [INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.93 s - in task_9.task9_1Test

4. Пробросить параметр из mvn command line внутрь теста
        Команда mvn -Dtest=task10 -Dusername="standard_user" -Dpassword="secret_sauce" test

        [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.85 s - in task_10.task10

        

