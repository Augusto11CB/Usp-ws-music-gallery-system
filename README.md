# Usp-ws-music-gallery-system

## Jena Java API
Jena is a free and open source Java framework for building Semantic Web and Linked Data applications. Site []

* Model: It is a Graph

### Basic Commands and Declarations

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

* Create a literal
>```java
> String type = " "http://www.w3.org/2001/XMLSchema#int"
> Model model = ModelFactory.createDefaultModel();
> Literal storeStock = model.createTypeLiteral("42",type); 
>```

>```java
> RRDFDatatype type = XSDDatatype.XSDint;
> Model model = ModelFactory.createDefaultModel();
> Literal storeStock = model.createTypeLiteral("42",type); 
>```

### Making Assertions 

* *<subject, predicate, object>* are called declaration
>```java
> String STORE_URI = "http://musicgallery/stores/rock-roll-planet/"
> Model model = ModelFactory.createDefaultModel();
> Resource store = model.createResource(STORE_URI);
> Property nameProperty = model.createResource(STORE_URI + "name");
> Literal name = model.createLiteral("Rock-And-Roll-Planet");
> Statement stmt = model.createStatement(store, nameProperty, name)
>```

* Adding declaration in to de *Model*
     `` model.add(stm) ``
     
### Iterators 
* walking through the properties of a **resource**
```java
Iterator<Statement> iterator = store.listProperties();
// print walking through the properties of store
while(it.hasNext()) {
    //DO SOMETHING
}
```

* Get statement based in a specific property
```java
Property nameProperty = model.createResource(STORE_URI + "name");
Iterator<Statement> iterator = store.listProperties(nameProperty);
// print walking through the properties of store
while(it.hasNext()) {
    //DO SOMETHING
}
```

* Method **getProperty()**
```java
Property nameProperty = model.createResource(STORE_URI + "name");
store.getProperty(nameProperty);
```
* getRequiredProperty
* hasProperty
* hasLiteral

