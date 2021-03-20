# chinese_checkers
Chinese checkers in java with storing games in database. I tried to use OOP, patterns, hibernate, client-server connection and maven

Here's a UML diagram. Sorry for some minor inaccuracies with the design, I will try to find the latest version
https://drive.google.com/file/d/1CGc5Z_iN4tG9wzTvdlPMY03SqhXfEl7f/view?usp=sharing

Instruction:

-Load database from .sql backup

-Source is directory "China". Maven should help

-Run ServerExec.java in put finishing touchespackage Server

-Choose options. Don't spoil the party here, I didn't want to do "IF statment's forest"

-Run for ClientExec in package Client. In normal game or with recording run in parallel for each player

-If you try watch game one run is enough. In DB you have games with id 1, 2 to start with

-If you don't want to use tests, it's better to uncomment code in ServerHead to auto-stop server when somebody leave
