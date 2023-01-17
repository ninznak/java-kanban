# Создание учебного проекта трекера задач
## _* KANBAN *-------//////////---------_  доска

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

#### Учебный проект 3-го спринта курса Yandex-Practicum

- Создание базовых классов и основной структуры проекта
<<<<<<< HEAD
-
- ✨Ma
-
=======
- 
- ✨Ma
- 
>>>>>>> 8208645169d5ed33a7f5baea74a5b27449348bac
## Features

- Import a HTML file and watch it magically convert to Markdown
- Drag and drop images (requires your Dropbox account be linked)
- Import and save files from GitHub, Dropbox, Google Drive and One Drive
- Drag and drop markdown and HTML files into Dillinger
- Export documents as Markdown, HTML and PDF

Markdown is a lightweight markup language based on the formatting conventions
that people naturally use in email.
As [John Gruber] writes on the [Markdown site][df1]

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

## Installation


```sh
cd dillinger
npm i
node app
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


