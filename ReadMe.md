# PlayGraund Application


```sh
## build
mvn clean install

## jar package
mvn package

##test

java -jar ...jar
```


## Usage With Swagger UI:

`http://localhost:8000/swagger-ui.html
`

###1. create playsite as many you want
`http://localhost:8000/addplaysite?......
`

###2. add players addplayer as many you want
`http://localhost:8000/addplaysite?......
`

###3. add player to a site
`http://localhost:8000/addplayertosite?......
`

###4. start playgraund (ms: periodic play time for a game)
`http://localhost:8000/startplaygraund?......
`

###6. get playsite history
`http://localhost:8000/gethistory?......
`

### look at swagger for other usefull end points