# MercadoTest

## 🏃🏻‍♂️ Correr la app

1. Clona el repo
2. Abre la carpeta MercadoTest usando Android Studio
3. Corre el proyecto en emulador o dispositivo(recomendado)
4. Para hacer una busqueda introduce algúna query, solo las palabras 'iphone' y 'samsung' traeran 
data, cualquier otra query producira un EmptyState.
5. Cada 3 busquedas producirá un error intencional para probar el manejo de errores.


## 🦾 Technical Stack

* Creado enteramente en kotlin y Jetpack compose
* hilt para inyección de dependencias
* Retrofit para llamadas a api
* Mockk para pruebas unitarias
* Coroutines para llamadas async
* Arquitectura MVI

## 🤌🏼 Code Quality

+ Linter: Ktlint
+ pruebas unitarias usando Mockk
+ pruebas de integracion usando Jetpack compose