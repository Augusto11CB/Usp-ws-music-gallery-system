# Usp-ws-music-gallery-system

## Jena Java API


* Model: It is a Graph

### 

* Model Declaration
>```java
> Model model = ModelFactory.createDefaultModel();
>```

* Resource Declaration
>```java
> String STORE_URI = "http://musicgallery/stores/rock-roll-planet"
> Model model = ModelFactory.createDefaultModel();
> Resource store = model.createResource(STORE_URI); 
>```

* Property Declaration
>```java
> String NAME_URI = "http://musicgallery/name/"
> Model model = ModelFactory.createDefaultModel();
> Property nameProperty = model.createResource(NAME_URI + "Rock-And-Roll-Planet"); 
>```

* Linking Property with Resource
>```java
> store.addProperty(nameProperty, "Rock and Roll Planet");
>```