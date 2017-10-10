# Dimayor_cloud
# Taller Google App Engine Endpoints

Este taller tiene la intención de introducir a los estudiantes que conforman la empresa ScheduleDoc al mundo de los endpoints de Google y su framework, mediante la elaboración de un API. El API que se desarrollará, deberá contar con los siguientes servicios: 1)Crear equipo, 2)Eliminar equipo, 3)Editar equipo y 4) Listar equipos.

Este API debe obtener la información de los equipos desde una base de datos SQL a la cual está conectada.

## Ejecución del proyecto 

#### - Descargar las dependencias 
Una vez hemos abierto el proyecto en Eclipse o Spring Tools STS debemos descargar las dependencias maven declaradas en el archivo pom.xml. Esto lo hacemos 1) dandole click derecho sobre el proyecto, 2) luego Maven y 3) update project.
#### - Modificar archivo para la conexión a la base de datos
Ahora debemos modificarl el archivo persistence.xml para realizar la conexión a la base de datos SQL. En este se debe cambiar los siguientes campos: host, puerto, usuario y constraseña. Así como se muestra a continuación. 

```xml
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://HOST:PUERTO/mydb?zeroDateTimeBehavior=convertToNull"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.user" value="USUARIO" />
            <property name="javax.persistence.jdbc.password" value="CONTRASEÑA"/>
```

#### Correr el proyecto en appengine 
Antes de correr el proyecto debemos correr el comando "mvn clean" y por último pasamos a correr el proyecto de manera local con el siguiente comando.
```ssh
mvn appengine:run
```
Para poder comprobar el correcto funcionamiento del proyecto podemos utilizar un agente de peticiones http como Postman. En este debemos ingresar una url diferente, dependiendo del servicio que queramos solicitar. Por ejemplo para solicitar la lista de equipos, tendríamos que introducir lo siguiente con un metodo POST:

```ssh
localhost:8080/_ah/api/dimayor/vi/listarEquipos
```
