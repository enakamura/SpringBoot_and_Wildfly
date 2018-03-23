# SOBRE

Wildfly 11.0.0 com webservice criado com Spring Boot 5.10.

* Em __wildfly__ esta o servidor Wildfly 11.0.0.
* Em __webservice__ esta o projeto do webservice em java.

## Como usar o webservice?
O webservice esta escutando na porta 8080 e URI "sendNotification", utilizada para requisições HTTP.

```
http://localhost:8080/sendNotification/
```

O webservice possui um método chamado "notificationMessage" que esta escutando a URI "/notificationMessage".
Este webservice é responsável por receber os parâmetros necessários para fazer o envio de uma notificação para o Firebase Cloud Message.

Ele espera três parâmetros:
* token: token do dispositivo que vai receber a notificação
* title: Título da notificaço
* message: Mensagem da notificação

```
http://localhost:8080/notification-1.0.0/notificationMessage?token=c86VHZESwf0:APA91bGqaunz6Vc5t0sYjv1ZJAJOcaNS-0gouQMJ0tDZJVXwyMH77zYVe7jSiefs5B_2KRj2yElKj9EnhVrGhdV7LyFbUstCq2l9Hzgw6hek7WhX6EXRM9SRi4wsmax103e8KdyCVLVf&title=Teste Maroto&message=Hello World!!!!
```

Como é um requisição GET, podemos utilizar um browser para realizar a chamada.

Se a mensagem conseguir ser enviada para o FCM, teremos como resposta uma mensagem JSON:

```javascript
{
	"code": "1",
	"message": "Success"
}
```

Exemplo de uma resposta de erro:

```javascript
{
  "code": "0",
  "message": "Server returned HTTP response code: 400 for URL: https://fcm.googleapis.com/fcm/send"
}
```
___

## Wildfly

### Como fazer o start do wildfly?
Em wildfly-11.0.0.Final/bin, executar:

```
./standalone.sh -b 0.0.0.0
```

Se tudo ocorrer bem, no final ser mostrado algo como:

```
15:38:31,410 INFO  [org.jboss.as.server.deployment.scanner] (MSC service thread 1-6) WFLYDS0013: Started FileSystemDeploymentService for directory /home/nakamura/Program/wildfly/wildfly-11.0.0.Final/standalone/deployments
15:38:31,422 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-7) WFLYSRV0027: Starting deployment of "notification-1.0.0.war" (runtime-name: "notification-1.0.0.war")
15:38:31,433 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-2) WFLYUT0006: Undertow HTTPS listener https listening on 0.0.0.0:8443
15:38:31,908 INFO  [org.jboss.ws.common.management] (MSC service thread 1-5) JBWS022052: Starting JBossWS 5.1.9.Final (Apache CXF 3.1.12) 
15:38:33,666 WARN  [org.jboss.as.ee] (MSC service thread 1-4) WFLYEE0007: Not installing optional component org.springframework.http.server.ServletServerHttpAsyncRequestControl due to an exception (enable DEBUG log level to see the cause)
15:38:33,676 WARN  [org.jboss.as.ee] (MSC service thread 1-4) WFLYEE0007: Not installing optional component org.springframework.web.context.request.async.StandardServletAsyncWebRequest due to an exception (enable DEBUG log level to see the cause)
15:38:33,750 INFO  [org.infinispan.factories.GlobalComponentRegistry] (MSC service thread 1-8) ISPN000128: Infinispan version: Infinispan 'Chakra' 8.2.8.Final
15:38:34,201 INFO  [org.jboss.as.clustering.infinispan] (ServerService Thread Pool -- 62) WFLYCLINF0002: Started client-mappings cache from ejb container
15:38:34,354 INFO  [io.undertow.servlet] (ServerService Thread Pool -- 70) 2 Spring WebApplicationInitializers detected on classpath
15:38:34,876 INFO  [stdout] (ServerService Thread Pool -- 70) 
15:38:34,877 INFO  [stdout] (ServerService Thread Pool -- 70)   .   ____          _            __ _ _
15:38:34,879 INFO  [stdout] (ServerService Thread Pool -- 70)  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
15:38:34,879 INFO  [stdout] (ServerService Thread Pool -- 70) ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
15:38:34,880 INFO  [stdout] (ServerService Thread Pool -- 70)  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
15:38:34,880 INFO  [stdout] (ServerService Thread Pool -- 70)   '  |____| .__|_| |_|_| |_\__, | / / / /
15:38:34,881 INFO  [stdout] (ServerService Thread Pool -- 70)  =========|_|==============|___/=/_/_/_/
15:38:34,886 INFO  [stdout] (ServerService Thread Pool -- 70)  :: Spring Boot ::       (v1.5.10.RELEASE)
15:38:34,888 INFO  [stdout] (ServerService Thread Pool -- 70) 
15:38:35,009 INFO  [com.notification.core.NotificationApplication] (ServerService Thread Pool -- 70) Starting NotificationApplication on ENGDBNOTE378 with PID 30011 (started by nakamura in /home/nakamura/Program/wildfly/wildfly-11.0.0.Final/bin)
15:38:35,011 INFO  [com.notification.core.NotificationApplication] (ServerService Thread Pool -- 70) No active profile set, falling back to default profiles: default
15:38:35,074 INFO  [org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext] (ServerService Thread Pool -- 70) Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1a726f7: startup date [Fri Mar 23 15:38:35 BRT 2018]; root of context hierarchy
15:38:35,797 INFO  [org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor] (ServerService Thread Pool -- 70) JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
15:38:35,860 INFO  [io.undertow.servlet] (ServerService Thread Pool -- 70) Initializing Spring embedded WebApplicationContext
15:38:35,860 INFO  [org.springframework.web.context.ContextLoader] (ServerService Thread Pool -- 70) Root WebApplicationContext: initialization completed in 787 ms
15:38:36,536 INFO  [org.springframework.boot.web.servlet.ServletRegistrationBean] (ServerService Thread Pool -- 70) Mapping servlet: 'dispatcherServlet' to [/]
15:38:36,541 INFO  [org.springframework.boot.web.servlet.FilterRegistrationBean] (ServerService Thread Pool -- 70) Mapping filter: 'errorPageFilter' to: [/*]
15:38:36,542 INFO  [org.springframework.boot.web.servlet.FilterRegistrationBean] (ServerService Thread Pool -- 70) Mapping filter: 'characterEncodingFilter' to: [/*]
15:38:36,542 INFO  [org.springframework.boot.web.servlet.FilterRegistrationBean] (ServerService Thread Pool -- 70) Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
15:38:36,543 INFO  [org.springframework.boot.web.servlet.FilterRegistrationBean] (ServerService Thread Pool -- 70) Mapping filter: 'httpPutFormContentFilter' to: [/*]
15:38:36,543 INFO  [org.springframework.boot.web.servlet.FilterRegistrationBean] (ServerService Thread Pool -- 70) Mapping filter: 'requestContextFilter' to: [/*]
15:38:37,070 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter] (ServerService Thread Pool -- 70) Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1a726f7: startup date [Fri Mar 23 15:38:35 BRT 2018]; root of context hierarchy
15:38:37,161 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] (ServerService Thread Pool -- 70) Mapped "{[/notificationMessage]}" onto public com.notification.pojo.Response com.notification.core.NotificationController.notificationMessage(java.lang.String,java.lang.String,java.lang.String)
15:38:37,162 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] (ServerService Thread Pool -- 70) Mapped "{[/]}" onto public java.lang.String com.notification.core.NotificationController.index()
15:38:37,168 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] (ServerService Thread Pool -- 70) Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
15:38:37,171 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] (ServerService Thread Pool -- 70) Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
15:38:37,228 INFO  [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] (ServerService Thread Pool -- 70) Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
15:38:37,229 INFO  [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] (ServerService Thread Pool -- 70) Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
15:38:37,295 INFO  [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] (ServerService Thread Pool -- 70) Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
15:38:37,501 INFO  [org.springframework.jmx.export.annotation.AnnotationMBeanExporter] (ServerService Thread Pool -- 70) Registering beans for JMX exposure on startup
15:38:37,522 INFO  [com.notification.core.NotificationApplication] (ServerService Thread Pool -- 70) Started NotificationApplication in 3.038 seconds (JVM running for 12.262)
15:38:37,589 INFO  [javax.enterprise.resource.webcontainer.jsf.config] (ServerService Thread Pool -- 70) Initializing Mojarra 2.2.13.SP4  for context '/sendNotification'
15:38:39,251 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 70) WFLYUT0021: Registered web context: '/sendNotification' for server 'default-server'
15:38:39,269 INFO  [org.jboss.as.server] (ServerService Thread Pool -- 37) WFLYSRV0010: Deployed "notification-1.0.0.war" (runtime-name : "notification-1.0.0.war")
15:38:39,355 INFO  [org.jboss.as.server] (Controller Boot Thread) WFLYSRV0212: Resuming server
15:38:39,357 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0060: Http management interface listening on http://127.0.0.1:9990/management
15:38:39,358 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0051: Admin console listening on http://127.0.0.1:9990
15:38:39,358 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0025: WildFly Full 11.0.0.Final (WildFly Core 3.0.8.Final) started in 14027ms - Started 504 of 732 services (353 services are lazy, passive or on-demand)
```

### Como acessar o console do wildfly?
* Console: http://localhost:9990
* User: admin
* Pass: admin

### Como fazer o gerenciamento de usuários?
Executar o script "./add-user.sh" dentro de wildfly-11.0.0.Final/bin

### Como trocar a porta do webservice?
Podemos mudar a porta default dos deploys do wildfly se iniciarmos o standalone com o parametro:
-Djboss.http.port=1234

```
./standalone.sh -b 0.0.0.0 -Djboss.http.port=1234
```

Para acessarmos uma aplicacao: http://localhost:1234/URI

Podemos também alterar o arquivo "wildfly-11.0.0.Final/standalone/configuration/standalone.xml"

```xml
<socket-binding name="http" port="${jboss.http.port:8080}"/>
```

Substituir o valor 8080 por outra porta.


### Como definir uma URI para a aplicação?
Por padrão a aplicação possui como URI o nome do arquivo que foi implatado.
No nosso exemplo, a URI deveria ser 

```
http://localhost:8080/notification-1.0.0/
```

Através deste arquivo conseguimos definir a URI que a nossa aplicação vai ser acessada no Wildfly.
Colocarmos o arquivo dentro de: 

```
WEB-INF/jboss-web.xml
```


```xml
<?xml version="1.0" encoding="UTF-8"?>
<jboss-web>
	<context-root>sendNotification</context-root>
</jboss-web>
```

Com esta alteração, passamos a aplicação passa a funcionar na URI:

```
http://localhost:8080/sendNotification/
```

### Usando o log do Wildfly

Utilizamos o arquivo de configuração de log do Wildfly.
Esse arquivo fica em:

```
wildfly-11.0.0.Final/standalone/configuration/standalone.xml
```

As alterações foram colocar dentro da tag "subsystem" com namespace xmlns="urn:jboss:domain:logging:3.0"

```xml
<profile>
    <subsystem xmlns="urn:jboss:domain:logging:3.0">
        <periodic-rotating-file-handler name="FILE_notification" autoflush="true">
			<formatter>
				<named-formatter name="PATTERN"/>
			</formatter>
			<file relative-to="jboss.server.log.dir" path="notification.log"/>
			<suffix value=".yyyy-MM-dd"/>
			<append value="true"/>
		</periodic-rotating-file-handler>
		<logger category="com.notification.core">
			<level name="TRACE"/>
			<handlers>
				<handler name="FILE_notification"/>
			</handlers>
		</logger>
    </subsystem>
</profile>
```

Fonte:
https://stackoverflow.com/questions/27500038/how-to-log-application-auditing-to-separate-file-on-wildfly-8
No exemplo da URL, ele cria um handler "MYHANDLER" para gravar o log que ele precisa

No código, criamos uma variável static LOG:

```java
static final Logger LOG = LoggerFactory.getLogger(SendMessage.class);
```

E usamos ela para escrever no arquivo de log:

```java
LOG.trace(response.toString());
```

___

## Spring Boot

Configurações para colocar o projeto no Wildfly

Para fazer o deploy do war no Wildfly, fazer as seguintes alterações no pom.xml do projeto:

### Fazer a classe application extender a classe SpringBootServletInitializer.
O que faz essa classe:

> This new base class - SpringBootServletInitializer - taps into a Servlet 3 style Java configuration API which lets you describe in code what you could only describe in web.xml before. Such configuration classes are discovered and invoked at application startup. __This gives Spring Boot a chance to tell the web server about the application__, including the reqired Servlets, Filters and Listeners typically required for the various Spring projects.

Fonte: https://spring.io/blog/2014/03/07/deploying-spring-boot-applications

Ex.:
```java
package com.sendNotificationFCM.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class NotificationApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

}
```
### Mudar o formato do pacote de 'jar' para 'war':
Você deve mudar o packaging para war:

```xml
<packaging>war</packaging>
```

### Remover dependências do Tomcat:
Podemos fazer isso facilmente indo na aba "Dependency Hierarchy" e fazer a busca por tomcat no campo "filter"
Tanto na janela "Dependency Hierarchy" como em "Resolved Dependencies" vai aparecer o resultado da busca por "tomcat"
Em "Resolved Dependencies", clicar com o botão direito na dependência e escolher a opção: "Esclude Maven Artifact..."
Fazendo isso, ele vai atualizar a tag de dependência do "org.springframework.boot" com a tag "exclusions" escluindo o tomcat.
Isso é importante porque se você tentar fazer o deploy no wildfly, vai ter um erro por causa do tomcat.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

O erro é esse:

```
18:34:49,035 ERROR [org.jboss.msc.service.fail] (ServerService Thread Pool -- 74) MSC000001: Failed to start service jboss.undertow.deployment.default-server.default-host."/notification-1.0.0": org.jboss.msc.service.StartException in service jboss.undertow.deployment.default-server.default-host."/notification-1.0.0": java.lang.RuntimeException: java.lang.ClassCastException: org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to io.undertow.websockets.jsr.ServerWebSocketContainer
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentService$1.run(UndertowDeploymentService.java:84)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
        at org.jboss.threads.JBossThread.run(JBossThread.java:320)
Caused by: java.lang.RuntimeException: java.lang.ClassCastException: org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to io.undertow.websockets.jsr.ServerWebSocketContainer
```

### Adicionar o Java servlet:
Peguei essa dependencia do repositório do Maven, assim garanto pegar a versão do javax.servlet mais recente.

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.0</version>
    <scope>provided</scope>
</dependency>
```
