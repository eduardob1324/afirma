# AcademiaAfirma

### Caso:
> Una empresa necesita un sistema para gestionar sus empleados. Los empleados pueden ser de tipo Permanente o Temporal, y cada tipo tiene un salario que se calcula de manera diferente:
>
> Los empleados permanentes tienen un salario fijo mensual.
>
> Los empleados temporales tienen un salario por hora trabajada.

# UML
### diagrama de clases 
<img src="diagrama.png" width="400" />

# SOLID
### 1.- Explica cómo el principio de Responsabilidad Única (SRP) aplica al caso anterior
> En el caso anterior, el principio de Responsabilidad Única se aplica de la siguiente manera:
> 
> la clase Empleado tiene una sola responsabilidad que es la de representar a un empleado, la clase EmpleadoPermanente solo tiene la responsabilidad de calcular el salario para un empleado permanente y asu vez la clase EmpleadoTemporal tiene solo la responsabilidad de calcular el salario para el empleado temporal, por lo tanto se cumple con el principio de responsabilidad unica ya que nuestras clases cumplen con una sola responsabilidad.

### 2.- Define cómo se puede aplicar el principio de Inversión de Dependencias
> En este caso, se puede definir una interfaz  llamada SalarioCalculable que defina el método calcularSalario(). Tanto EmpleadoPermanente como EmpleadoTemporal implementarán esta interfaz, permitiendo que el cálculo dependa de la abstracción y no de la clase.

### 3.- Da un ejemplo de una violación al principio Open/Closed (OCP)
> Si la clase Empleado tiene un método calcularSalario con una estructura if-else para diferenciar entre empleados temporales y permanentes, el código estaría abierto a modificaciones cada vez que se añada un nuevo tipo de empleado. por esta razon lo mas conveniente es definir la clase de Empleado en una clase abstracta con el método calcularSalario definido en las subclases.

# Patrones de diseño
### ¿Cuándo usarías el patrón Strategy? Da un ejemplo práctico.
>

###  ¿Cuál es la diferencia principal entre Factory Method y Visitor? 
>La principal diferencia es que el patrón Factory Method se utiliza para crear objetos sin especificar la clase concrete del objeto que se va a crear, mientras que el patrón Visitor permite agregar nuevas funcionalidades a una estructura de objetos sin modificar las clases de los objetos sobre los que opera.

###  Menciona un caso de uso donde Visitor sería ideal.
> cuando se tenga una aplicacion legacy que sea muy critica y por ejemplo se quiera utilizar algunas de sus clases para generar reportes, ya que se podria implementar la funcionalidad para generar los reportes sin afectar las clases existentes lo que permitiria poder integrar los reporte sin generar cambios significativos a las clases existentes.
