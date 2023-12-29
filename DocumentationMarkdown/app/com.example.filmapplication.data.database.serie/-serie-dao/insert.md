//[app](../../../index.md)/[com.example.filmapplication.data.database.serie](../index.md)/[SerieDao](index.md)/[insert](insert.md)

# insert

[androidJvm]\
abstract suspend fun [insert](insert.md)(item: [dbSerie](../db-serie/index.md))

Inserts a [dbSerie](../db-serie/index.md) item into the database. If there is a conflict with an existing record, it replaces the existing record with the new one.

#### Parameters

androidJvm

| | |
|---|---|
| item | The [dbSerie](../db-serie/index.md) object to insert or replace. |
