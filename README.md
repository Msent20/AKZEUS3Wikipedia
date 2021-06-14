# **WikipediaService**


### An Android library for communication with the external **Wikipedia** service.  
    
![alt text](images/wikipedia_logo.png) 


## Requirements  

Android Studio Version | Android API Version Min 
------------ | -------------
3.6+ | 16

## Getting Started    
-----------------------
#### To get started using this library, follow the steps below.  

1. Add the library to your proyect libs folder.
2. Modify the **settings.gradle** file so that the library is compiled as a module by adding the following lines : 

```kotlin 
include ':wikipediadata'
project(':wikipediadata').projectDir = new File('libs/WikipediaData')
```

3. Sync gradle. 
4. Add this lines as a new Gradle dependency :

```kotlin 
implementation project(":wikipediadata")
implementation project(path: ':wikipediadata')
```

5. Sync gradle.    
  

# WikipediaData Setup  


Instantiate an instance of the WikipediaService class.

```kotlin 
val wikipediaService: WikipediaService
```

You can retrieve the information by passing the name of an artist as a parameter

```kotlin
wikipediaService.getArticle(artistName)
```
