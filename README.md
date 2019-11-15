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
> String STORE_URI = "http://musicgallery/stores/"
> Model model = ModelFactory.createDefaultModel();
> Resource store = model.createResource(STORE_URI + "rock-roll-planet"); 
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
> String STORE_URI = "http://musicgallery/stores/"
> Model model = ModelFactory.createDefaultModel();
> Resource store = model.createResource(STORE_URI + "rock-roll-planet");
> Property nameProperty = model.createResource(STORE_URI + "name");
> Literal name = model.createLiteral("Rock-And-Roll-Planet");
> Statement stmt = model.createStatement(store, nameProperty, name)
>```

* Adding declaration in to de *Model*
     `` model.add(stm) ``
     
### Iterators
#### Resources
* walking through the properties of a **resource**
```java
Iterator<Statement> iterator = store.listProperties();
while(iterator.hasNext()) {
    //DO SOMETHING
}
```

* Get statement based in a specific property
```java
Property nameProperty = model.createResource(STORE_URI + "name");
Iterator<Statement> iterator = store.listProperties(nameProperty);
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

#### Model
* walking through the statements of a **model**
```java
Iterator<Statement> iterator = model.listStatements();
while(iterator.hasNext()) {
    //DO SOMETHING
}

```
* walking through the **RESOURCES** of a **model**
```java
Iterator<Resources> iterator = model.listSubjects();
while(iterator.hasNext()) {
    //DO SOMETHING
}
```

* walking through the **RESOURCES** of a **model** for a given predicate
```java
Property nameProperty = model.createResource(STORE_URI + "name");
Iterator<Resources> iterator = model.listSubjects(nameProperty);
while(iterator.hasNext()) {
    //DO SOMETHING
}
```

* walking through the **RESOURCES** of a **model** for a given predicate with a given value for a property
```java
Property nameProperty = model.createResource(STORE_URI + "name");
Resource storeRockAndRoll = model.createResource(STORE_URI + "rock-roll-planet"); 
Iterator<Resources> iterator = model.listSubjects(nameProperty, storeRockAndRoll);
while(iterator.hasNext()) {
    //DO SOMETHING
}
```

* walking through the **RESOURCES** of a **model** for a given relationship <subject, pred, obj>
```java
Property nameProperty = model.createResource(STORE_URI + "name");
Resource storeRockAndRoll = model.createResource(STORE_URI + "rock-roll-planet"); 
Iterator<Resources> iterator = model.listSubjects(subj, pred, object);
while(iterator.hasNext()) {
    //DO SOMETHING
}
```

### SPARQL 

### ModelMaker

* Working with models stored in relational databases
```java
IDBConnection conn = new DBConnection(DB_URL, DB_USER, DB_PWD, DB_TYPE);
ModelMaker mm = ModelFactory.createRDBModelMaker(conn);
```

* Creating a model `Model model = mm.createModel("MusicGallery");`
* Open an existing model `Model model = mm.openModel("MusicGallery");`
* Verify if there is a model `if(mm.hasModel("MusicGallery")){...}`

### Reasoner

**Inference in a SemanticWeb context** can be interpreted as the act of adding new triple to the model.

Reasoner are divided in two categories: 

#### InfModel
Infmodel has an API to make basic inference

```java
Model model = mm.createModel("MusicGallery");
InfModel inferredModel = ModelFactory.createRDFSModel(model);
```

#### Reasoner

```java

```
