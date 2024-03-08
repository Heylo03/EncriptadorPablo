**CifradoDES**

DES es un cifrador de bloque con tamaño de bloque de 64 bits. Para cada 

bloque de 64 bits de entrada se obtienen 64 bits a la salida, es decir, el 

tamaño del fichero resultante no crece ni decrece.

**Algoritmo de encriptación DES :**

![image](https://github.com/Heylo03/EncriptadorPablo/assets/127136385/f218dec1-8ca1-4a3d-8a63-8aa6ae0247bf)


**Instrucciones de uso :**

Ejecutar el programa: Ejecute java CifradoDES en la terminal.
Seleccionar unas de las siguientes opciones del menú : 

Cifrar en DES: Permite cifrar un archivo de texto utilizando DES.

Descifrar en DES: Permite descifrar un archivo de texto cifrado utilizando DES.

Salir: Finaliza la ejecución del programa.

Aclaración : Todos los textos para encriptar deben estar dentro de la carpeta del proyecto

**Funcionamiento** 

Vista del menú: 

![image](https://github.com/Heylo03/EncriptadorPablo/assets/127136385/2d138d45-f442-4745-bcd4-3499aab1c5e2)

Opción de encriptación : 

![image](https://github.com/Heylo03/EncriptadorPablo/assets/127136385/4ce2490e-bb22-465d-b217-f94c5cd9a4e1)

Opción de desencriptación : 

![image](https://github.com/Heylo03/EncriptadorPablo/assets/127136385/6d8f06b6-282a-4419-bd9f-6a7e8f65f848)

**Más información sobre el cifrado DES :**

**Ventajas:**

-Velocidad: DES es un algoritmo de cifrado relativamente rápido en comparación con otros algoritmos más recientes. Esto lo hace adecuado para aplicaciones donde se requiere un rendimiento rápido de cifrado y descifrado.


-Implementación amplia: Dado que DES ha sido un estándar ampliamente utilizado durante décadas, hay una gran cantidad de implementaciones y herramientas disponibles para trabajar con él. Esto facilita su integración en una variedad de sistemas y plataformas.


-Compatibilidad: Debido a su larga historia de uso, muchos sistemas aún dependen del cifrado DES. Mantener la compatibilidad con sistemas heredados o con protocolos que requieren DES puede ser una ventaja en ciertos contextos.


**Desventajas:**
-Longitud de clave corta: El principal problema de seguridad de DES es su longitud de clave corta de 56 bits. Con los avances en el poder computacional, la longitud de la clave de DES es vulnerable a ataques de fuerza bruta modernos.


-Criptografía débil: Como resultado de la longitud de clave corta y otros aspectos de su diseño, DES se considera criptográficamente débil en comparación con algoritmos más recientes como AES (Advanced Encryption Standard).


-Sustituido por estándares más seguros: Debido a sus limitaciones de seguridad, DES ha sido en gran parte reemplazado por algoritmos de cifrado más seguros y modernos como AES. Esto significa que en la mayoría de los casos, es preferible utilizar algoritmos más robustos para garantizar una protección adecuada de los datos.


En resumen, mientras que DES tiene ventajas como su velocidad y amplia implementación, estas son contrarrestadas por sus limitaciones de seguridad, especialmente su longitud de clave corta. En la actualidad, se recomienda utilizar algoritmos de cifrado más fuertes como AES para garantizar una seguridad adecuada en las comunicaciones y el almacenamiento de datos.

