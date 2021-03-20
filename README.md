# chinese_checkers
Chinese checkers in java with storing games in database. I tried to use OOP, patterns, hibernate, client-server connection and maven. It is the result of working with a friend via git. I was focused on back-end, connecting the client to the server. Friend's job was client's GUI

Here's a UML diagram. Sorry for some minor inaccuracies with the design, I will try to find the latest version
https://drive.google.com/file/d/1CGc5Z_iN4tG9wzTvdlPMY03SqhXfEl7f/view?usp=sharing

Instruction:

-Load database from .sql backup

-Source is directory "China". Maven should help

-Run ServerExec.java in package Server

-Choose options. Don't spoil the party here, I didn't want to do "IF statment's forest"

-Run ClientExec.java in package Client. In normal game or with recording run in parallel for each player

-One run is enough, if you try watch game  In DB you have games with id 1, 2 to start with

-If you don't want to use tests, it's better to uncomment code in ServerHead stop function to auto-stop server when somebody leave
