Jetty-Servlet Hello Heroku
==========================

This app is meant for use in demonstrating how to deploy a simple Java application on [Deis Workflow](https://deis.com/docs/workflow/).

It should also be able to run in Heroku and any Heroku-inspired PaaS that supports deploying applications via [Heroku Buildpacks](https://devcenter.heroku.com/articles/buildpacks).

Deis Workflow Usage
-------------------
### Create the App
```
git clone https://github.comcast.com/twilfo201/jetty-servlet-hello
cd jetty-servlet-hello
deis create
deis apps:info
```
### Push to Build and Deploy
```
git push deis master
deis apps:info
deis apps:open
```
### Other Commands
```
deis config:set HELLO_MESSAGE='Good day to you.'
deis config:list
deis releases
deis scale web=2
```
### Destroy App
```
deis apps:destroy
```
