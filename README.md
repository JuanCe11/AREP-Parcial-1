# T�tulo del Proyecto

Taller de verificaci�n de conocimientos t�cnicos

 [![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://arep-parcial-1.herokuapp.com/)
 
 [!CircleCI](https://app.circleci.com/pipelines/github/JuanCe11/AREP-Parcial-1)
 

## Comenzando 


Para tener una copia del repositorio, desde consola ejecute el siguiente comando.

```
git clone https://github.com/JuanCe11/AREP-Parcial-1.git
```

### Pre-requisitos 

- Java 8 - [How install](https://www.java.com/es/download/help/windows_manual_download.xml)
- Git - [How install](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git)
- Maven - [How install](https://maven.apache.org/install.html)


### Instalaci�n 

Para la correcta instalaci�n se debe primero clonar el repositorio como se indic� anteriormente, despu�s se ingresa al directorio del proyecto y para ejecutar la clase App (el servicio web) se ejecutan los siguientes comandos en windows.

```
cd AREP-Parcial-1
mvn package
java -cp target/classes;target/dependency/* edu.escuelaing.arep.web.App
```
Para sistemas linux usar: 

```
cd AREP-Parcial-1
mvn package
java -cp target/classes:target/dependency/* edu.escuelaing.arep.web.App
```
Cuando se tenga el servicio corriendo se ingresa a la direccion http://localhost:4567/ para ver el el servicio en el navegador.

Puede revisar las fuentes del proyecto revisar a detalle los test.

Puede generar la docuementacion usando:

```
mvn javadoc:javadoc
```

## Ejecutando las pruebas 

Ahora para ejecutar los test se utiliza el comando:

```
mvn test
```

### Analice las pruebas end-to-end 

Las pruebas propuestas est�n enfocadas a la clase _Calculator_ pero al probar las funcionalidades de esta clase se est�n utilizando todas las clases de la logica de soluci�n.

Se est� probando que el lector de archivos funcione para obtener los datos, se crea la lista encadenada y se le agregan los nodos con los valores que se obtuvieron de los archivos.


## Construido con 

* [Java 8](https://www.java.com/es/about/whatis_java.jsp)
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spark Java](http://sparkjava.com/) - Framework de aplicaci�n web.


## Wiki

Puedes encontrar mucho m�s de c�mo utilizar este proyecto en nuestra [Wiki](https://github.com/JuanCe11/AREP-Taller-Heroku/wiki)


## Autores 

* **Juan Sebastia G�mez L�pez** - *Trabajo Inicial* - [JuanCe11](https://github.com/JuanCe11)


## Licencia

Este proyecto est� bajo la Licencia GNU General Public License - mira el archivo [LICENSE.txt](LICENSE.txt) para detalles

