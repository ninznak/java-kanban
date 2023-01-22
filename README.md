# Создание учебного проекта трекера задач
## _* KANBAN *-------//////////---------_  доска

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

#### Учебный проект 3-го спринта курса Yandex-Practicum

- Создание базовых классов и основной структуры проекта
<<<<<<< HEAD
-
- ✨Java Practicum
-
=======
- 
- ✨Kanban first
- 
>>>>>>> 8208645169d5ed33a7f5baea74a5b27449348bac
## Features

> tracker

## Installation


```sh
cd 
```

For production environments...

## Plugins

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |

## Development

Generating pre-built zip archives for distribution:

```sh
gulp build dist --prod
```

## Docker

```sh
cd dillinger
docker build -t <youruser>/dillinger:${package.json.version} .
```

```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=dillinger <youruser>/dillinger:${package.json.version}
```


```sh
127.0.0.1:8000
```

## License FREE


