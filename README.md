# PracticeSpringBootApplication

Spring boot application integrated with google clould. 

__There are some things which I would have liked to do better which are documented in the [wiki](https://github.com/ntarunmenon/PracticeSpringBootApplication/wiki).__

[Access API Specs Here](https://tasks-application-225318.appspot.com/swagger-ui.html)

### List of APIs available
  - [GET /todo/{id}](https://tasks-application-225318.appspot.com/todo/1)
  - POST /todo
  - PATCH /todo/{id}
  - [GET /status](https://tasks-application-225318.appspot.com/status)
  - [GET /integration-test](https://tasks-application-225318.appspot.com/integrationTest?url=https://tasks-application-225318.appspot.com)

### Google Cloud Integration

  - Refer [here](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/helloworld-springboot) to set up a Spring boot app with google cloud
  - Run `mvn appengine:deploy` to deploy application to google cloud

### Running in local
- Run `mvn spring-boot:run` to deploy application to google cloud
- `mvn verify` will trigger integration test
