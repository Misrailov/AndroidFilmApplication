//[app](../../../index.md)/[com.example.filmapplication.data.database.actor](../index.md)/[ActorDao](index.md)/[getItem](get-item.md)

# getItem

[androidJvm]\
abstract fun [getItem](get-item.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[dbActor](../db-actor/index.md)&gt;

Retrieves an actor by their primary name.

#### Return

A Flow emitting the actor with the specified name.

#### Parameters

androidJvm

| | |
|---|---|
| name | The primary name of the actor to retrieve. |
