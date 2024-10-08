# Conversor de Monedas - Carlos Rosales

Este proyecto es un **conversor de monedas** que permite convertir entre diferentes divisas utilizando la API de ExchangeRate-API para obtener los tipos de cambio en tiempo real. La aplicación está diseñada para ejecutarse en consola y permite seleccionar el tipo de conversión, ingresar una cantidad y obtener el valor convertido.

## Estructura del Proyecto

ConversorMonedas/

│

├── src/

│   ├── com/

│   │   ├── aluracursos/

│   │   │   ├── controlador/

│   │   │   │   └── ControladorConversor.java

│   │   │   ├── modelo/

│   │   │   │   └── Conversor.java

│   │   │   ├── vista/

│   │   │   │   └── VistaConversor.java

│

├── README.md

└── .gitignore


- **ControladorConversor.java**: Controla la lógica del menú y las interacciones del usuario.
- **Conversor.java**: Contiene la lógica para conectarse a la API y realizar la conversión de divisas.
- **VistaConversor.java**: Punto de entrada principal de la aplicación donde se inicializa el controlador.

## Descripción de la Aplicación

La aplicación tiene la capacidad de realizar conversiones entre las siguientes monedas:

1. Dólar (USD) <=> Peso colombiano (COP)
2. Dólar (USD) <=> Peso mexicano (MXN)
3. Dólar (USD) <=> Euro (EUR)

El usuario selecciona una opción del menú, ingresa el monto que desea convertir, y la aplicación se conecta a la API de ExchangeRate-API para obtener la tasa de cambio correspondiente y realizar la conversión. La respuesta se muestra en el formato deseado:
El valor (cantidad ingresada) [moneda origen] corresponde al valor final de ==> (valor convertido) [moneda destino].

### Ejemplo

Si el usuario desea convertir **1000 COP** a dólares, la salida sería:
El valor 1000.00 [COP] corresponde al valor final de ==> 0.25 [USD].


## Lógica de Programación

1. **VistaConversor.java**: Es el punto de entrada de la aplicación. Inicializa la instancia del `ControladorConversor` y ejecuta el menú principal.
   
2. **ControladorConversor.java**:
   - **mostrarMenu()**: Este método muestra un menú con opciones para convertir entre varias monedas. Luego, solicita al usuario que ingrese la opción deseada y la cantidad de dinero que quiere convertir. Dependiendo de la opción seleccionada, llama al método `convertir` de la clase `Conversor`.
   - Cada opción corresponde a un par de monedas para realizar la conversión.
   
3. **Conversor.java**:
   - **convertir(String monedaDesde, String monedaHacia, double cantidad)**: Este método toma como parámetros la moneda de origen, la moneda de destino, y la cantidad a convertir. Luego, se conecta a la API de ExchangeRate-API y obtiene la tasa de cambio para realizar la conversión.
   - **obtenerTasaCambio(String monedaDesde, String monedaHacia)**: Este método realiza la conexión HTTP a la API y obtiene el tipo de cambio en formato JSON. Extrae el valor del tipo de cambio para la moneda destino y lo utiliza en la conversión.

## Cómo Ejecutar la Aplicación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/CR-Best/ChallengeConversorApp
2. Importa el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, etc.).
3. Ejecuta el archivo VistaConversor.java para iniciar el programa en consola.

Dependencias
Java 17 o superior.
Conexión a Internet para acceder a la API de ExchangeRate-API.
API Utilizada
Este conversor utiliza la API de ExchangeRate-API para obtener los tipos de cambio. Se requiere una API Key para acceder a los datos en tiempo real.

ExchangeRate-API
Contribución
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza los cambios necesarios y haz commit (git commit -m 'Añadir nueva característica').
Haz push a la rama (git push origin feature/nueva-caracteristica).
Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.


