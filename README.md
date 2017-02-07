# dbpedia-chatbot_warmup
Repository for the warmup tasks mentioned on http://wiki.dbpedia.org/ideas/idea/282/first-chatbot-for-dbpedia/

This project is a Slack bot which receives messages on the channel, queries the WolframAlpha API, and displays the resulting pods and subpods as simple text messages on the channel.

### Getting started
To use this project, follow the steps given below:

1. Clone this project `$ git clone https://github.com/parthsuresh/alfred` and `$ cd alfred`
2. [Create a slack bot](https://my.slack.com/services/new/bot) and get your token.
3. Paste the token in [application.properties](/src/main/resources/application.properties) file.
4. Invite the bot to your channel.
5. [Create a wolfram alpha developer id] (http://products.wolframalpha.com/simple-api/documentation/), create an app and paste the app-id in [WolframAPI.java](/src/main/java/com/parthsuresh/alfred/WolframAPI/WolframAPI.java) file.
6. Install [Java binding for WolframAlphaAPI] (http://products.wolframalpha.com/api/libraries.html) into local maven repository.
7. Run the application by running `AlfredApplication` in your IDE or via commandline.
```
$ mvn spring-boot:run
```

### Deploy to the Cloud

This project is Heroku ready. To deploy, you need to perform the below simple steps:

1. Clone this project `$ git clone https://github.com/parthsuresh/alfred` and `$ cd alfred`
2. Get your [slack bot token](https://my.slack.com/services/new/bot).
3. Paste the above tokens/urls in [application.properties](/src/main/resources/application.properties) file.
4. Invite the bot to your channel.
5. [Create a wolfram alpha developer id] (http://products.wolframalpha.com/simple-api/documentation/), create an app and paste the app-id in [WolframAPI.java](/src/main/java/com/parthsuresh/alfred/WolframAPI/WolframAPI.java) file.
6. [Download Toolbelt](https://toolbelt.heroku.com/) for your system.
7. `$ heroku login` - Login to Heroku.
8. `$ heroku create` - Create an app on Heroku.
9. `$ git push heroku master` - Push your code to Heroku.
10. `$ heroku ps:scale web=1` - Start your application.

However, you would need a paid tier to keep this bot running at all times, as the bot will sleep after 30 mins of inactivity on the free tier.

### Dependencies

1. [jbot] (https://github.com/ramswaroop/jbot/) by ramswaroop
2. [Java binding for WolframAlpha API] (http://products.wolframalpha.com/api/libraries.html) by Todd Gayley
