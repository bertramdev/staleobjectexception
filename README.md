# StaleObjectException
In the process of creating a new plugin started noticing random StaleObjectExceptions occurring for really simple edits.  After trying a number of things decided to put my plugin's domains into the same datasource--I had wanted to keep them separate--and voila, the problem went away.

## The Problem
Turns out there is something in the MongoDB Grails plugin that doesn't play well with domains in SQL datasources other than the default, even though Mongo isn't being used!  This project only has domains in an H2 database and doesn't perform any Mongo operations at all.  A Mongo datasource isn't specified, either.

## To Reproduce
Go to http://localhost:8080/product and create a new product.  Continue editing that same product over and over and eventually (usually within five or six edits) a StaleObjectException will occur.

This project reproduces the problem in two different ways.  If you start the project as it you shouldn't observe any issues.  This is because the domain object uses the default datasource.  To cause the issue you need to run the application like so: ```./grailsw -Dstaleobject.datasource=ds2 -Dstaleobject.usemongo=true run-app```

To show that the mongo driver is the problem drop the ```staleobject.usemongo``` property from the command line and create a product, edit, etc.

## Workarounds (sorta)
1. Don't use multiple datasources.  Not really feasible.
2. Don't use the [MongoDB driver](http://grails.org/plugin/mongodb), though this isn't really an option since it is the one officially supported by SpringSource.  If other alternatives exist please let us know!
