//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[CachingActorRepository](index.md)/[getItem](get-item.md)

# getItem

[androidJvm]\
open override fun [getItem](get-item.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md)?&gt;

Retrieves an actor by their name from the local database.

#### Return

A flow of [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md) object representing the actor.

#### Parameters

androidJvm

| | |
|---|---|
| name | The name of the actor. |
